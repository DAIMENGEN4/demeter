package com.advantest.demeter.database.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@AllArgsConstructor
@TableName("HOLIDAY_DB_TABLE")
public class HolidayPO {
    private Long id;
    private String holidayName;
    private String description;
    private LocalDate holidayDate;
    private Integer holidayType;
    private Boolean isRecurring;
    private Integer countryCode;
    @TableField(fill = FieldFill.INSERT)
    private Long creatorId;
    @TableField(fill = FieldFill.UPDATE)
    private Long updaterId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateDateTime;
}
