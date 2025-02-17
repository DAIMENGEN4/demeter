import {SelectOptions} from "@D/types";
import {HttpClient} from "@D/http/http-client.ts";

export interface ProjectDTO {
    id: string;
    projectName: string;
    description: string;
    startDateTime: string;
    endDateTime: string;
    projectStatus: number;
    version: number;
    order: number;
}

export class ProjectService {

    private static instance: ProjectService;

    public static getInstance(): ProjectService {
        if (!ProjectService.instance) {
            ProjectService.instance = new ProjectService();
        }
        return ProjectService.instance;
    }

    public createProjectRequest(params: ProjectDTO, success: (response: ProjectDTO) => void, failure?: (error: Error) => void) {
        const url = "/v1/project/createProject";
        HttpClient.post<ProjectDTO>(url, {...params}).then(success).catch(failure);
    }

    public deleteProjectRequest(params: {
        projectId: string
    }, success: (response: boolean) => void, failure?: (error: Error) => void) {
        const url = "/v1/project/deleteProject";
        HttpClient.post<boolean>(url, {...params}).then(success).catch(failure);
    }

    public updateProjectRequest(params: ProjectDTO, success: (response: ProjectDTO) => void, failure?: (error: Error) => void) {
        const url = "/v1/project/updateProject";
        HttpClient.post<ProjectDTO>(url, {...params}).then(success).catch(failure);
    }

    public getProjectsByCurrentEmployeeRequest(success: (response: Array<ProjectDTO>) => void, failure?: (error: Error) => void) {
        const url = "/v1/project/getProjectsByCurrentEmployee";
        HttpClient.post<ProjectDTO[]>(url).then(success).catch(failure);
    }

    public getProjectStatusSelectOptionsRequest(success: (response: SelectOptions) => void, failure?: (error: Error) => void) {
        const url = "/v1/project/getProjectStatusSelectOptions";
        HttpClient.post<SelectOptions>(url).then(success).catch(failure);
    }
}