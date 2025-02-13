package com.advantest.demeter.api.vo;

import com.advantest.demeter.service.dto.ProjectDTO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record ProjectVO(
        String id,
        String projectName,
        String description,
        String startDateTime,
        String endDateTime,
        Integer projectStatus,
        Integer version,
        Integer order
) {
    public static ProjectVO defaultValue() {
        return new ProjectVO(
                "null",
                "null",
                "null",
                "null",
                "null",
                null,
                null,
                null
        );
    }

    public static ProjectVO of(ProjectDTO projectDTO) {
        return new ProjectVO(
                projectDTO.id().toString(),
                projectDTO.projectName(),
                projectDTO.description(),
                projectDTO.startDateTime(),
                projectDTO.endDateTime(),
                projectDTO.projectStatus().toInt(),
                projectDTO.version(),
                projectDTO.order()
        );
    }
}
