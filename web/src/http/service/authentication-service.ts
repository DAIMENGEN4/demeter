import {HttpClient} from "@D/http/http-client.ts";

export interface LoginRequestDTO {
    username: string;
    password: string;
}

export interface LoginResponseDTO {
    token: string;
    employeeId: string;
    employeeName: string;
}

export class AuthenticationService {

    private static instance: AuthenticationService;

    public static getInstance(): AuthenticationService {
        if (!AuthenticationService.instance) {
            AuthenticationService.instance = new AuthenticationService();
        }
        return AuthenticationService.instance;
    }

    public loginRequest(params: LoginRequestDTO, success: (response: LoginResponseDTO) => void, failure?: (error: Error) => void): void {
        const url = "/v1/auth/login";
        HttpClient.post<LoginResponseDTO>(url, {...params}).then(success).catch(failure);
    }

    public logoutRequest(success: () => void, failure?: (error: Error) => void): void {
        const url = "/v1/auth/logout";
        HttpClient.post<string>(url).then(success).catch(failure);
    }
}