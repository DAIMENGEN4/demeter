import dayjs from "dayjs";
import { Milestone } from "schedulant";

export const mockMilestones: Array<Milestone> = [
    {
        id: "1",
        title: "milestone1",
        time: dayjs("2024-08-31"),
        status: "Success",
        resourceId: "8638818878966724025",
    }
]