import "./login-page.scss";
import React, {useCallback} from "react";
import {Button, Form, Input, Layout, Space} from "antd";
import {useAntdMessage} from "@D/hooks/message/use-antd-message";
import login_bg_image from "../../assets/images/jpeg/login-bg-image.jpeg";
import login_logo_wr_image from "../../assets/images/jpg/login_logo_wr.jpg";
import {AuthenticationService, LoginRequestDTO, LoginResponseDTO} from "@D/http/service/authentication-service.ts";
import {useDemeterDispatch} from "@D/store/store.ts";
import {useNavigate} from "react-router-dom";
import {setEmployeeIdAction, setEmployeeNameAction} from "@D/store/features/employee-slice.ts";

export const LoginPage: React.FC = () => {
    const {Content} = Layout;
    const navigate = useNavigate();
    const {contextHolderMessage, success, failure} = useAntdMessage();
    const demeterDispatch = useDemeterDispatch()
    const onFinish = useCallback((values: LoginRequestDTO) => {
        AuthenticationService.getInstance().loginRequest(
            values,
            (response: LoginResponseDTO) => {
                success("Login Successfully").then(() => {
                    sessionStorage.setItem("token", response.token)
                    demeterDispatch(setEmployeeIdAction(response.employeeId));
                    demeterDispatch(setEmployeeNameAction(response.employeeName));
                    navigate("/home");
                });
            },
            (error: Error) => {
                failure(error.message).then();
            }
        )
    }, [failure, success]);

    return (
        <Layout className={"login-page"} style={{
            backgroundImage: `url(${login_bg_image})`,
            backgroundSize: "cover",
            backgroundPositionX: "44%",
            backgroundAttachment: "fixed"
        }}>
            <Content className={"login-content"}>
                <div className={"login-form"}>
                    {contextHolderMessage}
                    <div className="logo-container">
                        <img src={login_logo_wr_image} alt="Advantest"/>
                    </div>
                    <h1 className="login-title">Welcome to Demeter</h1>
                    <Form
                        name="basic"
                        initialValues={{remember: true}}
                        onFinish={onFinish}
                        layout="vertical"
                    >
                        <Form.Item
                            name="username"
                            rules={[
                                {
                                    required: true,
                                    message: 'Please enter your username!'
                                }]}>
                            <Input placeholder={"You Username"} autoComplete="username"/>
                        </Form.Item>

                        <Form.Item
                            name="password"
                            rules={[
                                {
                                    required: true,
                                    message: 'Please enter your password!'
                                }]}>
                            <Input.Password placeholder={"You Password"} autoComplete="current-password"/>
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit" className="login-button">
                                Log in
                            </Button>
                        </Form.Item>
                    </Form>
                    <div style={{textAlign: "center", width: "100%"}}>
                        <Space>
                            <span style={{color: "#a7a5a5"}}>Don't have an account yet?</span>
                            <a href="#" onClick={() => navigate("/register")}>Sign up</a>
                        </Space>
                    </div>
                </div>
            </Content>
        </Layout>
    )
}