import {AnyType} from "@D/types";
import {log} from "@D/logging.ts";
import axios, {AxiosInstance, AxiosResponse} from "axios";

const axiosInstance: AxiosInstance = axios.create({
    baseURL: "http://127.0.0.1:9090/api",
    timeout: 5000,
    withCredentials: true,
});

axiosInstance.interceptors.request.use(
    config => {
        const token = localStorage.getItem("token");
        if (token) {
            config.headers["Authorization"] = `Bearer ${token}`;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
)

axiosInstance.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        return Promise.reject(error);
    }
)

export type RequestParams = Record<string, AnyType> | Array<AnyType>;

export class HttpClient {

    static async get<T>(url: string, params?: RequestParams): Promise<T> {
        try {
            const response: AxiosResponse<T> = await axiosInstance.get(url, {params});
            return response.data;
        } catch (error) {
            if (axios.isAxiosError(error)) {
                log.error(`Get request failed, URL: ${url}, error: ${error.message}`);
                throw error;
            } else {
                log.error(`Unexpected error: ${String(error)}`);
                throw new Error(`Unexpected error: ${String(error)}`);
            }
        }
    }

    static async post<T>(url: string, params?: RequestParams): Promise<T> {
        try {
            const response: AxiosResponse<T> = await axiosInstance.post(url, params);
            return response.data;
        } catch (error) {
            if (axios.isAxiosError(error)) {
                log.error(`Post request failed, URL: ${url}, error: ${error.message}`);
                throw error;
            } else {
                log.error(`Unexpected error: ${String(error)}`);
                throw new Error(`Unexpected error: ${String(error)}`);
            }
        }
    }

    static async put<T>(url: string, params?: RequestParams): Promise<T> {
        try {
            const response: AxiosResponse<T> = await axiosInstance.put(url, params);
            return response.data;
        } catch (error) {
            if (axios.isAxiosError(error)) {
                log.error(`Put request failed, URL: ${url}, error: ${error.message}`);
                throw error;
            } else {
                log.error(`Unexpected error: ${String(error)}`);
                throw new Error(`Unexpected error: ${String(error)}`);
            }
        }
    }

    static async delete<T>(url: string): Promise<T> {
        try {
            const response: AxiosResponse<T> = await axiosInstance.delete(url);
            return response.data;
        } catch (error) {
            if (axios.isAxiosError(error)) {
                log.error(`Delete request failed, URL: ${url}, error: ${error.message}`);
                throw error;
            } else {
                log.error(`Unexpected error: ${String(error)}`);
                throw new Error(`Unexpected error: ${String(error)}`);
            }
        }
    }

    static parseResponseError(error: Error): string {
        const errorPrefix = "error:";
        const errorIndex = error.message.indexOf(errorPrefix);
        if (errorIndex !== -1) {
            return error.message.slice(errorIndex + errorPrefix.length).trim();
        } else {
            return error.message;
        }
    }
}