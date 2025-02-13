package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.ProjectTaskPO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record ProjectTaskDTO(
        Long id,
        String taskName,
        Long parentTaskId,
        Long projectId
) {
    public static ProjectTaskDTO of(ProjectTaskPO projectTaskPO) {
        return new ProjectTaskDTO(
                projectTaskPO.getId(),
                projectTaskPO.getTaskName(),
                projectTaskPO.getParentTaskId(),
                projectTaskPO.getProjectId()
        );
    }
}
