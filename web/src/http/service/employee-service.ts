import {HttpClient} from "@D/http/http-client.ts";

export class EmployeeService {

    private static instance: EmployeeService;

    public static getInstance(): EmployeeService {
        if (!EmployeeService.instance) {
            EmployeeService.instance = new EmployeeService();
        }
        return EmployeeService.instance;
    }

    public loginRequest(username: string, password: string, success: (token: string) => void, failure?: (error: Error) => void): void {
        const url = "/v1/auth/login";
        HttpClient.post<string>(url, {username, password}).then(success).catch(failure);
    }

}