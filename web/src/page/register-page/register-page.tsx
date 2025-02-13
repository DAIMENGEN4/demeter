import "./register-page.scss";
import React, {useCallback} from "react";
import {useNavigate} from "react-router-dom";
import {Button, Form, Input, Layout} from "antd";
import {useAntdMessage} from "@D/hooks/message/use-antd-message.tsx";
import login_bg_image from "@D/assets/images/jpeg/login-bg-image.jpeg";
import login_logo_wr_image from "@D/assets/images/jpg/login_logo_wr.jpg";
import {EmployeeDTO, EmployeeService} from "@D/http/service/employee-service.ts";

export const RegisterPage: React.FC = () => {
    const {Content} = Layout;
    const navigate = useNavigate();
    const {contextHolderMessage, success, failure} = useAntdMessage();
    const onFinish = useCallback((values: EmployeeDTO) => {
        EmployeeService.getInstance().registerRequest(
            values,
            (response: boolean) => {
                if (response) {
                    success("Register Successfully").then(() => {
                        navigate("/login");
                    });
                } else {
                    failure("Register Failed").then();
                }
            },
            (error: Error) => {
                failure(error.message).then();
            }
        )
    }, [failure, success]);

    return (
        <Layout className={"register-page"} style={{
            backgroundImage: `url(${login_bg_image})`,
            backgroundSize: "cover",
            backgroundPositionX: "44%",
            backgroundAttachment: "fixed"
        }}>
            <Content className={"register-content"}>
                <div className={"register-form"}>
                    {contextHolderMessage}
                    <div className="logo-container">
                        <img src={login_logo_wr_image} alt="Advantest"/>
                    </div>
                    <h1 className="register-title">Welcome Register</h1>
                    <Form
                        name="basic"
                        initialValues={{remember: true}}
                        onFinish={onFinish}
                        layout="vertical"
                    >
                        <Form.Item
                            name="employeeName"
                            rules={[
                                {
                                    required: true,
                                    message: "Please enter your name!"
                                }
                            ]}>
                            <Input placeholder={"You Name"} autoComplete="name"/>
                        </Form.Item>

                        <Form.Item
                            name="username"
                            rules={[
                                {
                                    required: true,
                                    message: "Please enter your username!"
                                }
                            ]}>
                            <Input placeholder={"You Username"} autoComplete="username"/>
                        </Form.Item>

                        <Form.Item
                            name="password"
                            rules={[
                                {
                                    required: true,
                                    message: "Please enter your password!"
                                }
                            ]}>
                            <Input.Password placeholder={"You Password"} autoComplete="current-password"/>
                        </Form.Item>
                        <Form.Item
                            name="email"
                            rules={[
                                {
                                    required: true,
                                    message: "Please enter your email!"
                                },
                                {
                                    pattern: /^[a-zA-Z0-9._%+-]+@advantest\.com$/,
                                    message: "Please enter a valid company email address!"
                                }
                            ]}>
                            <Input placeholder={"You Email"} autoComplete="email"/>
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit" className="register-button">
                                Register
                            </Button>
                        </Form.Item>
                    </Form>
                </div>
            </Content>

        </Layout>
    )
}