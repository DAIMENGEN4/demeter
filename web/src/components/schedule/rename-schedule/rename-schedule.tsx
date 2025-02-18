import {Button, Flex, Form, Input, InputNumber, Popover, Select} from "antd";
import React, {useCallback, useState} from "react";
import {useDemeterDispatch} from "@D/store/store.ts";
import {ProjectDTO, ProjectService} from "@D/http/service/project-service.ts";
import {useFormDateFieldRules} from "@D/hooks/form/form-field/use-form-date-filed-rules.tsx";
import {useProjectStatus} from "@D/hooks/project/use-project-status.tsx";
import {ProjectVo} from "@D/views/vo/project-vo.ts";
import {updateProjectDTO} from "@D/store/features/project-slice.ts";
import {useAntdMessage} from "@D/hooks/message/use-antd-message.tsx";

export const RenameSchedule: React.FC<{ projectVO: ProjectVo }> = ({projectVO}) => {
    const {TextArea} = Input;
    const [form] = Form.useForm();
    const [open, setOpen] = useState(false);
    const {contextHolderMessage, success, failure} = useAntdMessage();
    const projectStatus = useProjectStatus();
    const dispatch = useDemeterDispatch();
    const renameSchedule = useCallback((value: ProjectDTO) => {
        ProjectService.getInstance().updateProjectRequest(value, (project: ProjectDTO) => {
            dispatch(updateProjectDTO(project));
            success("Rename schedule success").then(() => setOpen(false));
        }, error => failure(error.message));
    }, [dispatch, success, failure]);
    return (
        <Popover trigger={"click"} placement={"rightTop"} open={open} onOpenChange={setOpen} content={
            <div style={{minWidth: "300px"}}>
                <Form name={"rename-schedule"} layout={"vertical"} style={{height: "120px"}} form={form}
                      onFinish={renameSchedule}
                      initialValues={{
                          "id": projectVO.getId(),
                          "projectName": projectVO.getProjectName(),
                          "description": projectVO.getDescription(),
                          "startDateTime": projectVO.getStartDateTime(),
                          "endDateTime": projectVO.getEndDateTime(),
                          "projectStatus": projectVO.getProjectStatus(),
                          "version": projectVO.getVersion(),
                          "order": projectVO.getOrder(),
                      }}>
                    <Form.Item hidden={true} name={"id"}>
                        <Input/>
                    </Form.Item>

                    <Form.Item hidden={true} name="description"
                               rules={[{required: false}]}>
                        <TextArea placeholder="Autosize height with minimum and maximum number of lines"
                                  autoSize={{minRows: 3, maxRows: 10}}/>
                    </Form.Item>

                    <Form.Item hidden={true} name="startDateTime"
                               rules={useFormDateFieldRules(true)}>
                        <Input/>
                    </Form.Item>

                    <Form.Item hidden={true} name="endDateTime"
                               rules={useFormDateFieldRules(false)}>
                        <Input/>
                    </Form.Item>

                    <Form.Item hidden={true} name="projectStatus" rules={[{required: true}]}>
                        <Select showSearch options={projectStatus} filterOption={(input, option) => {
                            return (option?.label?.toString() ?? "").toLowerCase().includes(input.toLowerCase());
                        }}/>
                    </Form.Item>

                    <Form.Item hidden={true} name="version"
                               rules={useFormDateFieldRules(false)}>
                        <InputNumber/>
                    </Form.Item>

                    <Form.Item hidden={true} name="order"
                               rules={useFormDateFieldRules(false)}>
                        <InputNumber/>
                    </Form.Item>

                    <Form.Item layout={"vertical"} label="Schedule name" name="projectName" rules={[{required: true}]}>
                        <Input/>
                    </Form.Item>
                    <Form.Item>
                        <Flex justify={"space-between"} gap={20}>
                            <Button type={"primary"} style={{width: "50%"}}
                                    onClick={() => form.submit()}>Submit</Button>
                            <Button style={{width: "50%"}} onClick={() => form.resetFields()}>Reset</Button>
                        </Flex>
                    </Form.Item>
                </Form>
            </div>
        }>
            {contextHolderMessage}
            Rename Schedule
        </Popover>
    )
}