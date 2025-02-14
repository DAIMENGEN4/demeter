import {useDemeterSelector} from "@D/store/store.ts";
import {ProjectVo} from "@D/views/vo/project-vo.ts";


export const useProjectVo = () => {
    const projectDTOS = useDemeterSelector(state => state.projectStore.projectDTOS);
    return projectDTOS.map(dto => ProjectVo.of(dto));
}