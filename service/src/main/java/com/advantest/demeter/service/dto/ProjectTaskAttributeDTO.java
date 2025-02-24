package com.advantest.demeter.service.dto;

import com.advantest.demeter.common.constants.MysqlColumnType;
import com.advantest.demeter.database.po.ProjectTaskAttributePO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record ProjectTaskAttributeDTO(
        @JsonSerialize(using = ToStringSerializer.class)
        Long id,
        String taskAttributeName,
        MysqlColumnType taskAttributeType,
        @JsonSerialize(using = ToStringSerializer.class)
        Long projectId,
        JsonNode properties,
        Integer order
) {
    public static ProjectTaskAttributeDTO of(ProjectTaskAttributePO projectTaskAttributePO) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode properties;
        try {
            properties = objectMapper.readTree(projectTaskAttributePO.getProperties());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ProjectTaskAttributeDTO(
                projectTaskAttributePO.getId(),
                projectTaskAttributePO.getTaskAttributeName(),
                MysqlColumnType.fromColumnType(projectTaskAttributePO.getTaskAttributeType()),
                projectTaskAttributePO.getProjectId(),
                properties,
                projectTaskAttributePO.getOrder()
        );
    }
}
