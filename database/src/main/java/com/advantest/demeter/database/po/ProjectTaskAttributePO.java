package com.advantest.demeter.database.po;

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
@TableName("PROJECT_TASK_ATTRIBUTE_DB_TABLE")
public class ProjectTaskAttributePO {
    private Long id;
    private String taskAttributeName;
    private String taskAttributeType;
    private Long projectId;
    private String properties;
    private Integer order;
    private Long creatorId;
    private Long updaterId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
