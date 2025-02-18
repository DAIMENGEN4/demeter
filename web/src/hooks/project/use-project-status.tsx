import {useEffect, useState} from "react";
import {SelectOptions} from "@D/types";
import {ProjectService} from "@D/http/service/project-service.ts";
import {log} from "@D/logging.ts";

export const useProjectStatus = () => {
    const [projectStatus, setProjectStatus] = useState<SelectOptions>([]);
    useEffect(() => {
        const projectService = ProjectService.getInstance();
        projectService.getProjectStatusSelectOptionsRequest((options: SelectOptions) => {
            setProjectStatus(options);
        }, error => log.error(error.message))
    }, []);
    return projectStatus;
}