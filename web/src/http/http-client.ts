import {AnyType} from "@D/types";
import {log} from "@D/logging.ts";
import axios, {AxiosInstance, AxiosResponse, AxiosError, AxiosRequestConfig, InternalAxiosRequestConfig} from "axios";

let isRefreshing = false;
let refreshSubscribers: ((token: string) => void)[] = [];

const axiosInstance: AxiosInstance = axios.create({
    baseURL: "http://127.0.0.1:9090/api",
    timeout: 5000,
    withCredentials: true,
});

axiosInstance.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        const token = sessionStorage.getItem("token");
        if (token) config.headers.Authorization = `Bearer ${token}`;
        return config;
    },
    (error: AxiosError) => Promise.reject(error)
);

axiosInstance.interceptors.response.use(
    (response: AxiosResponse) => response,
    async (error: AxiosError) => {
        if (error.response?.status === 401) {
            const originalRequest = error.config!;
            if (!isRefreshing) {
                isRefreshing = true;
                try {
                    const response = await axios.post("http://127.0.0.1:9090/api/v1/auth/refresh", {}, {
                        withCredentials: true
                    });
                    const newToken: string = response.data;
                    sessionStorage.setItem("token", newToken);
                    // 通知所有订阅者，更新请求 Token
                    refreshSubscribers.forEach(callback => callback(newToken));
                    refreshSubscribers = [];
                    return axiosInstance.request(originalRequest);
                } catch (refreshError) {
                    log.warn(`Refresh token failed, error: ${refreshError}`);
                    sessionStorage.removeItem("token");
                    window.location.href = "/login";
                } finally {
                    isRefreshing = false;
                }
            } else {
                // 如果已经在刷新中，将请求添加到订阅列表中，等待刷新完成
                return new Promise(resolve => {
                    refreshSubscribers.push((token: string) => {
                        originalRequest.headers!.Authorization = `Bearer ${token}`;
                        resolve(axiosInstance.request(originalRequest));
                    });
                });
            }
        }
        return Promise.reject(error);
    }
);

export type RequestParams = Record<string, AnyType> | Array<AnyType>;

export class HttpClient {

    private static async request<T>(method: string, url: string, params?: RequestParams, config?: AxiosRequestConfig): Promise<T> {
        try {
            const response: AxiosResponse<T> = await axiosInstance.request<T>({
                method,
                url,
                data: ["post", "put"].includes(method) ? params : undefined,
                params: method === "get" ? params : undefined,
                ...config
            });
            return response.data;
        } catch (error) {
            log.error(`Unexpected error: ${String(error)}`);
            throw new Error(`Unexpected error: ${String(error)}`);
        }
    }

    static async get<T>(url: string, params?: RequestParams, config?: AxiosRequestConfig): Promise<T> {
        return this.request<T>("get", url, params, config);
    }

    static async post<T>(url: string, params?: RequestParams, config?: AxiosRequestConfig): Promise<T> {
        return this.request<T>("post", url, params, config);
    }

    static async put<T>(url: string, params?: RequestParams, config?: AxiosRequestConfig): Promise<T> {
        return this.request<T>("put", url, params, config);
    }

    static async delete<T>(url: string, config?: AxiosRequestConfig): Promise<T> {
        return this.request<T>("delete", url, undefined, config);
    }
}