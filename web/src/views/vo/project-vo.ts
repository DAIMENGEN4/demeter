import {ProjectDTO} from "@D/http/service/project-service.ts";

export class ProjectVo {
    private readonly id: string;
    private readonly projectName: string;
    private readonly description: string;
    private readonly startDateTime: string;
    private readonly endDateTime: string;
    private readonly projectStatus: number;
    private readonly version: number;
    private readonly order: number;

    constructor(id: string, projectName: string, description: string, startDateTime: string, endDateTime: string, projectStatus: number, version: number, order: number) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.projectStatus = projectStatus;
        this.version = version;
        this.order = order;
    }

    getId(): string {
        return this.id;
    }

    getProjectName(): string {
        return this.projectName;
    }

    getDescription(): string {
        return this.description;
    }

    getStartDateTime(): string {
        return this.startDateTime;
    }

    getEndDateTime(): string {
        return this.endDateTime;
    }

    getProjectStatus(): number {
        return this.projectStatus;
    }

    getVersion(): number {
        return this.version;
    }

    getOrder(): number {
        return this.order;
    }

    static of(dto: ProjectDTO): ProjectVo {
        return new ProjectVo(dto.id, dto.projectName, dto.description, dto.startDateTime, dto.endDateTime, dto.projectStatus, dto.version, dto.order);
    }
}