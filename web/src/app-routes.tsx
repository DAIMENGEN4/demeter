import React from "react";
import {Route, Routes} from "react-router-dom";
import {LoginPage} from "@D/page/login-page/login-page.tsx";
import {Authentication} from "@D/authentication/authentication.tsx";
import {HomePage} from "@D/page/home-page/home-page.tsx";

export const AppRoutes: React.FC = () => {
    return (
        <Routes>
            <Route path="/" element={<LoginPage/>}/>
            <Route path="/login" element={<LoginPage/>}/>
            <Route path="/home" element={<Authentication children={<HomePage/>}/>}/>
        </Routes>
    )
}