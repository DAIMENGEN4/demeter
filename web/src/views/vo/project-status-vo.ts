export class ProjectStatusVo {
    private readonly label: string;
    private readonly value: number;

    constructor(label: string, value: number) {
        this.label = label;
        this.value = value;
    }

    getLabel(): string {
        return this.label;
    }

    getValue(): number {
        return this.value;
    }

    static of(status: number) {
        switch (status) {
            case 1:
                return new ProjectStatusVo("Not Started", status);
            case 2:
                return new ProjectStatusVo("Requirements Analysis", status);
            case 3:
                return new ProjectStatusVo("Planning", status);
            case 4:
                return new ProjectStatusVo("In Progress", status);
            case 5:
                return new ProjectStatusVo("Acceptance", status);
            case 6:
                return new ProjectStatusVo("Completed", status);
            case 7:
                return new ProjectStatusVo("Cancelled", status);
            case 8:
                return new ProjectStatusVo("On Hold", status);
            case 9:
                return new ProjectStatusVo("Delayed", status);
        }
    }
}