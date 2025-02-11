import axios, {AxiosInstance, AxiosResponse} from "axios";
import {AnyType} from "@D/types";

const axiosInstance: AxiosInstance = axios.create({
    baseURL: "http://localhost:9090",
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

    async get<T>(url: string, params?: RequestParams): Promise<T> {
        const response: AxiosResponse<T> = await axiosInstance.get(url, {params}).catch(error => {
            throw new Error(`Request failed, URL: ${url}, error: ${error}`);
        });
        return response.data;
    }

    async post<T>(url: string, params?: RequestParams): Promise<T> {
        const response: AxiosResponse<T> = await axiosInstance.post(url, params).catch(error => {
            throw new Error(`Request failed, URL: ${url}, error: ${error}`);
        });
        return response.data;
    }

    async put<T>(url: string, params?: RequestParams): Promise<T> {
        const response: AxiosResponse<T> = await axiosInstance.put(url, params).catch(error => {
            throw new Error(`Request failed, URL: ${url}, error: ${error}`);
        });
        return response.data;
    }

    async delete<T>(url: string): Promise<T> {
        const response: AxiosResponse<T> = await axiosInstance.delete(url).catch(error => {
            throw new Error(`Request failed, URL: ${url}, error: ${error}`);
        });
        return response.data;
    }

    parseResponseError(error: Error): string {
        const errorPrefix = "error:";
        const errorIndex = error.message.indexOf(errorPrefix);
        if (errorIndex !== -1) {
            return error.message.slice(errorIndex + errorPrefix.length).trim();
        } else {
            return error.message;
        }
    }
}