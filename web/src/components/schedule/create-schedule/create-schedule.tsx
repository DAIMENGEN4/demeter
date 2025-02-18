import {Button, Flex, Form, Input, Popover, Select} from "antd";
import dayjs from "dayjs";
import {useFormDateFieldRules} from "@D/hooks/form/form-field/use-form-date-filed-rules.tsx";
import {useCallback, useState} from "react";
import {ProjectDTO, ProjectService} from "@D/http/service/project-service.ts";
import {useAntdMessage} from "@D/hooks/message/use-antd-message.tsx";
import {useDemeterDispatch} from "@D/store/store.ts";
import {createProjectDTO} from "@D/store/features/project-slice.ts";
import {useProjectStatus} from "@D/hooks/project/use-project-status.tsx";

export const CreateSchedule = () => {
    const {TextArea} = Input;
    const [form] = Form.useForm();
    const [open, setOpen] = useState(false);
    const {contextHolderMessage, success, failure} = useAntdMessage();
    const projectStatus = useProjectStatus();
    const dispatch = useDemeterDispatch();
    const createSchedule = useCallback((value: ProjectDTO) => {
        ProjectService.getInstance().createProjectRequest({...value, projectStatus: 1}, (project: ProjectDTO) => {
            dispatch(createProjectDTO(project));
            success("Create schedule success").then(() => setOpen(false));
        }, (error: Error) => failure(error.message));
    }, [success, dispatch, failure]);
    return (
        <Popover trigger={"click"} placement={"rightTop"} open={open} onOpenChange={setOpen} content={
            <div style={{minWidth: "300px"}}>
                <Form name={"create-schedule"} style={{ height: "510px"}} layout={"vertical"} form={form} onFinish={createSchedule}
                      initialValues={{
                          "projectName": "New Schedule",
                          "projectStatus": 3,
                          "startDateTime": dayjs().format("YYYY-MM-DD")
                      }}>
                    <Form.Item layout={"vertical"} label="Schedule name" name="projectName" rules={[{required: true}]}>
                        <Input/>
                    </Form.Item>
                    <Form.Item layout={"vertical"} label="Schedule status" name="projectStatus" rules={[{required: true}]}>
                        <Select showSearch options={projectStatus} filterOption={(input, option) => {
                            return (option?.label?.toString() ?? "").toLowerCase().includes(input.toLowerCase());
                        }}/>
                    </Form.Item>
                    <Form.Item layout={"vertical"} label="Schedule startDate" name="startDateTime"
                               rules={useFormDateFieldRules(true)}>
                        <Input/>
                    </Form.Item>
                    <Form.Item layout={"vertical"} label="Schedule endDate" name="endDateTime"
                               rules={useFormDateFieldRules(false)}>
                        <Input/>
                    </Form.Item>
                    <Form.Item layout={"vertical"} label="Schedule description" name="description"
                               rules={[{required: false}]}>
                        <TextArea placeholder="Autosize height with minimum and maximum number of lines"
                                  autoSize={{minRows: 3, maxRows: 10}}/>
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
            Create Schedule
        </Popover>
    )
}