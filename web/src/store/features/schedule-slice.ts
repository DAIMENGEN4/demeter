import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import dayjs from "dayjs";

export type ScheduleStore = {
    visibleCreateScheduleModal: boolean;
    taskInitial: {
        taskName: string;
        startDate: string, // YYYY-MM-DD
        endDate: string, // YYYY-MM-DD
        order: number
    }
}

const initialState: ScheduleStore = {
    visibleCreateScheduleModal: false,
    taskInitial: {
        taskName: "New Task",
        startDate: dayjs().format("YYYY-MM-DD"),
        endDate: dayjs().format("YYYY-MM-DD"),
        order: 0
    },
}

const ScheduleStoreSlice = createSlice({
    name: "schedule",
    initialState,
    reducers: {
        setVisibleCreateScheduleModal(state, action: PayloadAction<boolean>) {
            state.visibleCreateScheduleModal = action.payload;
        },
        setTaskInitial(state, action: PayloadAction<{
            taskName: string;
            startDate: string,
            endDate: string,
            order: number
        }>) {
            state.taskInitial = action.payload;
        }
    }
});

export const {
    setVisibleCreateScheduleModal,
    setTaskInitial
} = ScheduleStoreSlice.actions;

export default ScheduleStoreSlice.reducer;