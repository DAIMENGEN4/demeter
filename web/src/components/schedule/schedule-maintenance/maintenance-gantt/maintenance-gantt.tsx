import "./maintenance-gantt.scss";
import React from "react";
import dayjs from "dayjs";
import {FullSchedule} from "full-flex-ui";
import "full-flex-ui/dist/full-flex-ui.css";
import {mockResources} from "./mock-data/mock-resources";
import {mockEvents} from "./mock-data/mock-events";
import {mockCheckpoints} from "./mock-data/mock-checkpoints";
import {mockMilestones} from "./mock-data/mock-milestones";

export const MaintenanceGantt: React.FC<{projectId: string}> = ({projectId}) => {
    console.log(projectId);
    return (
        <div className="maintenance-gantt">
            <FullSchedule end={dayjs("2024-10-09")}
                          start={dayjs("2024-08-10")}
                          events={mockEvents}
                          editable={true}
                          lineHeight={40}
                          slotMinWidth={50}
                          scheduleMaxHeight={500}
                          scheduleViewType={"Day"}
                          checkpoints={mockCheckpoints}
                          milestones={mockMilestones}
                          resources={mockResources}/>
        </div>
    )
}