import React, {useState} from "react";
import {Dropdown, DropdownProps, MenuProps} from "antd";

export const PersistentDropdown: React.FC<DropdownProps> = (props) => {
    const [open, setOpen] = useState(false);

    const handleMenuClick: MenuProps["onClick"] = () => {
        setOpen(true);
    };

    const handleOpenChange: DropdownProps["onOpenChange"] = (nextOpen, info) => {
        if (info.source === "trigger" || nextOpen) {
            setOpen(nextOpen);
        }
    };

    return (
        <Dropdown {...props} menu={{...props.menu, onClick: handleMenuClick}} open={open}
                  onOpenChange={handleOpenChange}/>
    )
}