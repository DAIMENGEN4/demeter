import React from "react";
import {Navigate} from "react-router-dom";

export const Authentication: React.FC<{ children?: React.ReactNode }> = ({children}) => {
    const token = sessionStorage.getItem("token");
    if (token) {
        return <>{children}</>;
    } else {
        return <Navigate to={"/login"} replace></Navigate>
    }
}