import {HttpClient} from "@D/http/http-client.ts";

export interface EmployeeDTO {
    readonly id: string;
    readonly username: string;
    readonly password: string;
    readonly employeeName: string;
    readonly email: string;
    readonly isActive: boolean;
}

export class EmployeeService {

    private static instance: EmployeeService;

    public static getInstance(): EmployeeService {
        if (!EmployeeService.instance) {
            EmployeeService.instance = new EmployeeService();
        }
        return EmployeeService.instance;
    }

    public registerRequest(params: EmployeeDTO, success: (response: boolean) => void, failure?: (error: Error) => void) {
        const url = "/v1/employee/register";
        HttpClient.post<boolean>(url, {...params}).then(success).catch(failure);
    }
}