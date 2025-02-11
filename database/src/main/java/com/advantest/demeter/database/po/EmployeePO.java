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
@TableName("EMPLOYEE_DB_TABLE")
public class EmployeePO {
    private Long id;
    private String account;
    private String password;
    private String employeeName;
    private String email;
    private String phone;
    private Boolean isActive;
    private Long creatorId;
    private Long updaterId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
