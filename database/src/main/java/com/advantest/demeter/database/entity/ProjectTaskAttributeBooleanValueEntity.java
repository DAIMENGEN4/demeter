package com.advantest.demeter.database.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("PROJECT_TASK_ATTRIBUTE_BOOLEAN_VALUE_DB_TABLE")
public class ProjectTaskAttributeBooleanValueEntity {
    private Long id;
    private Long taskId;
    private Long taskAttributeId;
    private Boolean taskAttributeValue;
    private Long projectId;
    private Long creatorId;
    private Long updaterId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
