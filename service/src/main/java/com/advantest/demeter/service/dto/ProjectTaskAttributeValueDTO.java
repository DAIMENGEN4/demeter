package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.ProjectTaskAttributeValuePO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record ProjectTaskAttributeValueDTO<T>(
        Long id,
        Long taskId,
        Long taskAttributeId,
        T taskAttributeValue
) {
    public static <T> ProjectTaskAttributeValueDTO<T> of(ProjectTaskAttributeValuePO<T> projectTaskAttributeValuePO) {
        return new ProjectTaskAttributeValueDTO<>(
                projectTaskAttributeValuePO.getId(),
                projectTaskAttributeValuePO.getTaskId(),
                projectTaskAttributeValuePO.getTaskAttributeId(),
                projectTaskAttributeValuePO.getTaskAttributeValue()
        );
    }
}

