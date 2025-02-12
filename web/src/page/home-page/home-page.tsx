import "./home-page.scss";
import {log} from "@D/logging.ts";
import React, {useCallback} from "react";
import {Layout, Menu, MenuProps, Space} from "antd";
import {Outlet, useNavigate} from "react-router-dom";
import {HomeOutlined, LogoutOutlined} from "@ant-design/icons";
import {AuthenticationService} from "@D/http/service/authentication-service.ts";
import {useEmployeeName} from "@D/hooks/employee/use-employee-name";
import header_logo_white_image from "../../assets/images/png/header_logo_white.png"

export const HomePage: React.FC = () => {
    const {Header, Content} = Layout;
    const navigate = useNavigate();
    const employeeName = useEmployeeName();
    const onClick: MenuProps["onClick"] = useCallback((e: any) => {
        const {key} = e;
        switch (key) {
            case "/login":
                AuthenticationService.getInstance().logoutRequest(() => {
                    localStorage.removeItem("token");
                    navigate(key);
                }, (error: Error) => log.error(error.message))
                break;
            case "/home":
                navigate(key);
                break;
            default:
                break;
        }
    }, [navigate]);

    return (
        <Layout className={"home-page"}>
            <Header className={"header"}>
                <Space className="header-left">
                    <div className="demo-logo-vertical">
                        <img src={header_logo_white_image} alt="Advantest"/>
                    </div>
                    <Menu className="header-left-menu"
                          onClick={onClick}
                          theme="dark"
                          mode="horizontal"
                          items={[{
                              key: '/home',
                              label: 'Home',
                              icon: <HomeOutlined/>,
                          }]}/>
                </Space>
                <Space className="header-right">
                    <Space>
                        <span style={{color: "white", fontSize: "16px"}}>{employeeName}</span>
                    </Space>
                    <Menu className="header-right-menu"
                          onClick={onClick}
                          theme="dark"
                          mode="horizontal"
                          items={[{
                              key: "/login",
                              label: "Logout",
                              icon: <LogoutOutlined/>
                          }]}/>
                </Space>
            </Header>
            <Content className={"content"}>
                <Outlet/>
            </Content>
        </Layout>
    )
}