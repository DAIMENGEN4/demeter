package com.advantest.demeter.service.dto;

import com.advantest.demeter.service.constants.ProjectStatus;
import com.advantest.demeter.database.po.ProjectPO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record ProjectDTO(
        Long id,
        String projectName,
        String description,
        String startDateTime,
        String endDateTime,
        ProjectStatus projectStatus,
        Integer version,
        Integer order
) {
    public static ProjectDTO defaultValue() {
        return new ProjectDTO(
                null,
                "null",
                "null",
                "null",
                "null",
                null,
                null,
                null
        );
    }

    public static ProjectDTO of(ProjectPO projectPO) {
        return new ProjectDTO(
                projectPO.getId(),
                projectPO.getProjectName(),
                projectPO.getDescription(),
                projectPO.getStartDateTime(),
                projectPO.getEndDateTime(),
                ProjectStatus.fromInt(projectPO.getProjectStatus()),
                projectPO.getVersion(),
                projectPO.getOrder()
        );
    }
}
