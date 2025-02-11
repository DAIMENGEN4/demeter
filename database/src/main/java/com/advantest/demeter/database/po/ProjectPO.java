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
@TableName("PROJECT_DB_TABLE")
public class ProjectPO {
    private Long id;
    private String projectName;
    private String description;
    private String startDateTime;
    private String endDateTime;
    private Integer projectStatus;
    private Integer version;
    private Integer order;
    private Long creatorId;
    private Long updaterId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
