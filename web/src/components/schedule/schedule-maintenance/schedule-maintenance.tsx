import "./schedule-maintenance.scss";
import {useParams} from "react-router-dom";
import {useState} from "react";
import {useHtmlDivElementRef} from "@D/hooks/ref/use-html-div-element-ref.tsx";
import {Button, Flex, Popover, Tabs} from "antd";
import {HIGHLIGHT_COLOR} from "@D/theme/theme.ts";
import {DownIcon01} from "@D/icons/down-icon/down-icon-01.tsx";
import {MessageIcon01} from "@D/icons/message-icon/message-icon-01.tsx";
import {PeopleIcon01} from "@D/icons/people-icon/people-icon-01.tsx";
import {MoreIcon01} from "@D/icons/more-icon/more-icon-01";
import {HouseIcon01} from "@D/icons/house-icon/house-icon-01";
import {GanttIcon01} from "@D/icons/gantt-icon/gantt-icon-01.tsx";
import {useProjectName} from "@D/hooks/project/use-project-name.tsx";
import {MaintenanceGantt} from "@D/components/schedule/schedule-maintenance/maintenance-gantt/maintenance-gantt.tsx";

export const ScheduleMaintenance = () => {
    const {projectId} = useParams<{ projectId: string }>();
    const scheduleMaintenanceRef = useHtmlDivElementRef();
    const [highlightScheduleTitle, setHighlightScheduleTitle] = useState<boolean>();
    return (
        <div className={"schedule-maintenance"} ref={scheduleMaintenanceRef}>
            <div className={"schedule-maintenance-header"}>
                <Flex justify={"space-between"}>
                    <Popover title={"ScheduleTitle"}
                             trigger="click"
                             arrow={false}
                             placement="bottomLeft"
                             onOpenChange={setHighlightScheduleTitle}>
                        <Button type={"text"}
                                iconPosition={"end"}
                                style={{backgroundColor: highlightScheduleTitle ? HIGHLIGHT_COLOR : ""}}
                                icon={<DownIcon01 width={15} height={15} color={"#000000"}/>}>
                            <span style={{
                                fontSize: 25,
                                fontWeight: "normal"
                            }}>{useProjectName(projectId as string)}</span>
                        </Button>
                    </Popover>
                    <Flex gap={10} justify={"flex-end"} style={{paddingRight: 10}}>
                        <Button type={"text"} icon={<MessageIcon01 width={20} height={20} color={"#000000"}/>}/>
                        <Button type={"text"} icon={<PeopleIcon01 width={20} height={20} color={"#000000"}/>}/>
                        <Button type={"text"} icon={<MoreIcon01 width={20} height={20} color={"#000000"}/>}/>
                    </Flex>
                </Flex>
            </div>
            <div className={"schedule-maintenance-body"}>
                <Tabs indicator={{ size: (origin) => origin - 25, align: "center" }} items={[
                    {
                        key: "main-gantt",
                        label: <Button type={"text"} icon={<GanttIcon01 width={15} height={15} color={"#000000"}/>}>Main
                            Gantt</Button>,
                        children: projectId && <MaintenanceGantt projectId={projectId}/>
                    },
                    {
                        key: "main-table",
                        label: <Button type={"text"} icon={<HouseIcon01 width={15} height={15} color={"#000000"}/>}>Main
                            Table</Button>,
                        disabled: true
                    }
                ]} tabBarGutter={0}/>
            </div>
        </div>
    )
}