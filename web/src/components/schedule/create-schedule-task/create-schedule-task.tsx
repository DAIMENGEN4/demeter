import React, {useEffect} from "react";
import {useDemeterDispatch, useDemeterSelector} from "@D/store/store.ts";
import {Form, Input, InputNumber} from "antd";
import {useFormDateFieldRules} from "@D/hooks/form/form-field/use-form-date-filed-rules.tsx";
import {setVisibleCreateScheduleModal} from "@D/store/features/schedule-slice.ts";
import {DraggableModal} from "@D/components/common/draggable-modal/draggable-modal.tsx";

export const CreateScheduleTask: React.FC = () => {
    const [form] = Form.useForm();
    const dispatch = useDemeterDispatch();
    const visible = useDemeterSelector(state => state.scheduleStore.visibleCreateScheduleModal);
    const taskInitial = useDemeterSelector(state => state.scheduleStore.taskInitial);
    useEffect(() => {
        form.setFieldsValue(taskInitial);
    }, [form, taskInitial]);
    return (
        <DraggableModal classNames={{content: "create-schedule-task-draggable-modal"}}
                        open={visible}
                        onCancel={() => dispatch(setVisibleCreateScheduleModal(false))}
                        closable={true}
                        style={{top: 80}}
                        maskClosable={false}
                        cancelText={"Cancel"}
                        okText={"Create"}
                        onOk={form.submit}>
            <Form name={"create-schedule-task"} layout={"vertical"} form={form}
                  onFinish={(values) => {
                      console.log(values);
                  }}
                  initialValues={{
                      "taskName": "New Task"
                  }}>
                <Form.Item layout={"vertical"} label="Task Name" name="taskName"
                           rules={[{required: true, message: "Please input task name"}]}>
                    <Input/>
                </Form.Item>
                <Form.Item layout={"vertical"} label="Task startDate" name="startDate"
                           rules={useFormDateFieldRules(true)}>
                    <Input/>
                </Form.Item>
                <Form.Item layout={"vertical"} label="Task endDate" name="endDate"
                           rules={useFormDateFieldRules(false)}>
                    <Input/>
                </Form.Item>
                <Form.Item layout={"vertical"} hidden={true} name={"order"}>
                    <InputNumber/>
                </Form.Item>
            </Form>
        </DraggableModal>
    )
}