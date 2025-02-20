import "./maintenance-gantt.scss";
import "full-flex-ui/dist/full-flex-ui.css";
import React, {useCallback} from "react";
import dayjs from "dayjs";
import {useWindowSize} from "usehooks-ts";
import {FullSchedule, SelectInfoArg} from "full-flex-ui";
import {mockResources} from "./mock-data/mock-resources";
import {mockEvents} from "./mock-data/mock-events";
import {mockCheckpoints} from "./mock-data/mock-checkpoints";
import {mockMilestones} from "./mock-data/mock-milestones";
import {CreateScheduleTask} from "@D/components/schedule/create-schedule-task/create-schedule-task.tsx";
import {useDemeterDispatch} from "@D/store/store.ts";
import {setTaskInitial, setVisibleCreateScheduleModal} from "@D/store/features/schedule-slice.ts";

export const MaintenanceGantt: React.FC<{ projectId: string }> = ({projectId}) => {
    const {height = 0} = useWindowSize();
    const dispatch = useDemeterDispatch();
    console.log(projectId);
    const selectAllow = useCallback((event: SelectInfoArg) => {
        const extendProps = event.resourceApi.getExtendProps().get();
        dispatch(setTaskInitial({
            taskName: "New Task",
            startDate: event.startDate.format("YYYY-MM-DD"),
            endDate: event.endDate.format("YYYY-MM-DD"),
            order: extendProps.order
        }));
        dispatch(setVisibleCreateScheduleModal(true));
    }, [dispatch]);
    return (
        <div className="maintenance-gantt">
            <FullSchedule end={dayjs("2024-10-09")}
                          start={dayjs("2024-08-10")}
                          events={mockEvents}
                          lineHeight={40}
                          editable={true}
                          selectable={true}
                          slotMinWidth={50}
                          defaultEmptyLanes={100}
                          scheduleMaxHeight={height - 174}
                          scheduleViewType={"Day"}
                          checkpoints={mockCheckpoints}
                          milestones={mockMilestones}
                          resources={mockResources}
                          selectAllow={selectAllow}/>
            <CreateScheduleTask/>
        </div>
    )
}