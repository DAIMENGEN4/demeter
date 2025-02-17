package com.advantest.demeter.database.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@AllArgsConstructor
@TableName("PROJECT_DB_TABLE")
public class ProjectPO {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String projectName;
    private String description;
    private String startDateTime;
    private String endDateTime;
    private Integer projectStatus;
    private Integer version;
    @TableField(value = "`order`")
    private Integer order;
    @TableField(fill = FieldFill.INSERT)
    private Long creatorId;
    @TableField(fill = FieldFill.UPDATE)
    private Long updaterId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateDateTime;
}
