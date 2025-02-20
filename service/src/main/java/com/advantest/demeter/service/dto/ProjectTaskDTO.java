package com.advantest.demeter.service.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Builder
public record ProjectTaskDTO(
        Long id,
        String taskName,
        Long parentTaskId,
        Integer order,
        List<ProjectTaskAttributeDTO> taskAttributes,
        List<ProjectTaskAttributeValueDTO<Long>> taskAttributeLongValues,
        List<ProjectTaskAttributeValueDTO<Boolean>> taskAttributeBooleanValues,
        List<ProjectTaskAttributeValueDTO<Double>> taskAttributeDoubleValues,
        List<ProjectTaskAttributeValueDTO<Integer>> taskAttributeIntegerValues,
        List<ProjectTaskAttributeValueDTO<Float>> taskAttributeFloatValues,
        List<ProjectTaskAttributeValueDTO<String>> taskAttributeTextValues,
        List<ProjectTaskAttributeValueDTO<String>> taskAttributeVarcharValues,
        List<ProjectTaskAttributeValueDTO<String>> taskAttributeLongTextValues,
        List<ProjectTaskAttributeValueDTO<String>> taskAttributeMediumtextTextValues,
        List<ProjectTaskAttributeValueDTO<JsonNode>> taskAttributeJsonValues,
        List<ProjectTaskAttributeValueDTO<LocalDate>> taskAttributeDateValues,
        List<ProjectTaskAttributeValueDTO<LocalDateTime>> taskAttributeDateTimeValues
) {
}
