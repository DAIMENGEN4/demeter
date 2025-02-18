import React from "react";
import {Route, Routes} from "react-router-dom";
import {LoginPage} from "@D/page/login-page/login-page.tsx";
import {Authentication} from "@D/components/authentication/authentication.tsx";
import {HomePage} from "@D/page/home-page/home-page.tsx";
import {RegisterPage} from "@D/page/register-page/register-page.tsx";
import {Navigation} from "@D/components/navigation/navigation.tsx";
import {Schedule} from "@D/components/schedule/schedule.tsx";
import {ScheduleHome} from "@D/components/schedule/schedule-home/schedule-home.tsx";
import {ScheduleMaintenance} from "@D/components/schedule/schedule-maintenance/schedule-maintenance.tsx";

export const AppRoutes: React.FC = () => {
    return (
        <Routes>
            <Route path="/" element={<LoginPage/>}/>
            <Route path="/login" element={<LoginPage/>}/>
            <Route path="/register" element={<RegisterPage/>}/>
            <Route path="/home" element={<Authentication children={<HomePage/>}/>}>
                <Route index={true} element={<Navigation/>}/>
                <Route path={"/home/schedule"} element={<Schedule/>}>
                    <Route index={true} element={<ScheduleHome/>}/>
                    <Route path={"/home/schedule/maintenance/:projectId"} element={<ScheduleMaintenance/>}/>
                </Route>
            </Route>
        </Routes>
    )
}