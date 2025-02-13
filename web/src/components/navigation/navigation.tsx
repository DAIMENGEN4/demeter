import "./navigation.scss";
import React from "react";
import {Card, Flex} from "antd";
import {ScheduleNavigation} from "@D/components/navigation/schedule-navigation/schedule-navigation.tsx";

export const Navigation: React.FC = () => {
    return (
        <Flex gap={20} vertical={true} style={{padding: 20}}>
            <Card title={"热门工具"} variant={"borderless"}>
                <div className={"navigation-item-list"}>
                    <ScheduleNavigation/>
                </div>
            </Card>

            <Card title="内网平台" variant={"borderless"}>
                <div className={"navigation-item-list"}>
                    {Array.from({length: 10}, (_, i) => (
                        <Card key={i}>
                            <p>内网平台{i}</p>
                        </Card>
                    ))}
                </div>
            </Card>

            <Card title="学习平台" variant={"borderless"}>
                <div className={"navigation-item-list"}>
                    {Array.from({length: 10}, (_, i) => (
                        <Card key={i}>
                            <p>学习平台{i}</p>
                        </Card>
                    ))}
                </div>
            </Card>

            <Card title="技术社区" variant={"borderless"}>
                <div className={"navigation-item-list"}>
                    {Array.from({length: 10}, (_, i) => (
                        <Card key={i}>
                            <p>技术社区{i}</p>
                        </Card>
                    ))}
                </div>
            </Card>
        </Flex>
    )
}