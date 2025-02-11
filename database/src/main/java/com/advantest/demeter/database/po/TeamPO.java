package com.advantest.demeter.database.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("TEAM_DB_TABLE")
public class TeamPO {
    private Long id;
    private String teamName;
    private String description;
    private Long creatorId;
    private Long updaterId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateDateTime;
}
