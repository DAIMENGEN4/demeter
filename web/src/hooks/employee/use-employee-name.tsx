import {useDemeterSelector} from "@D/store/store";

export const useEmployeeName = () => {
    const employeeName = useDemeterSelector(state => state.employeeStore.employeeName);
    return employeeName ?? "Unknown";
}