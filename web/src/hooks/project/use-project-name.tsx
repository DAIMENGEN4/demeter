import { useDemeterSelector } from "@D/store/store";

export const useProjectName = (projectId: string) => {
  const projectDTO = useDemeterSelector(state => state.projectStore.projectDTOS.find(dto => dto.id === projectId));
  return projectDTO?.projectName ?? projectId;
}