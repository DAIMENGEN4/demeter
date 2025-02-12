import {useDemeterSelector} from "@D/store/store";

export const useEmployeeId = () => {
    const employeeId = useDemeterSelector(state => state.employeeStore.employeeId);
    return employeeId ?? "";
}