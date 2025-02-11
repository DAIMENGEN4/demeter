import React from "react";
import Icon from "@ant-design/icons/lib/components/Icon";
import {StyleUtil} from "@D/utils/style-util.ts";

export const SaveIcon01: React.FC<{ width: number, height: number, color: string }> = (props) => {
    const saveIcon = () => (
        <svg className="save-icon-01" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
             width={`${StyleUtil.numberToPixels(props.width)}`} height={`${StyleUtil.numberToPixels(props.height)}`}>
            <path
                d="M292.571429 877.714286l438.857143 0 0-219.428571-438.857143 0 0 219.428571zm512 0l73.142857 0 0-512q0-8-5.714286-22t-11.428571-19.714286l-160.571429-160.571429q-5.714286-5.714286-19.428571-11.428571t-22.285714-5.714286l0 237.714286q0 22.857143-16 38.857143t-38.857143 16l-329.142857 0q-22.857143 0-38.857143-16t-16-38.857143l0-237.714286-73.142857 0 0 731.428571 73.142857 0 0-237.714286q0-22.857143 16-38.857143t38.857143-16l475.428571 0q22.857143 0 38.857143 16t16 38.857143l0 237.714286zm-219.428571-530.285714l0-182.857143q0-7.428571-5.428571-12.857143t-12.857143-5.428571l-109.714286 0q-7.428571 0-12.857143 5.428571t-5.428571 12.857143l0 182.857143q0 7.428571 5.428571 12.857143t12.857143 5.428571l109.714286 0q7.428571 0 12.857143-5.428571t5.428571-12.857143zm365.714286 18.285714l0 530.285714q0 22.857143-16 38.857143t-38.857143 16l-768 0q-22.857143 0-38.857143-16t-16-38.857143l0-768q0-22.857143 16-38.857143t38.857143-16l530.285714 0q22.857143 0 50.285714 11.428571t43.428571 27.428571l160 160q16 16 27.428571 43.428571t11.428571 50.285714z"
                fill={props.color}>
            </path>
        </svg>
    )
    return <Icon component={saveIcon} {...props}/>
}