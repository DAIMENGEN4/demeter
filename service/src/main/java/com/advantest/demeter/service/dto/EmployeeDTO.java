package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.EmployeePO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String account;
    private String password;
    private String employeeName;
    private String email;
    private String phone;
    private Boolean isActive;

    public static EmployeeDTO parse(EmployeePO employeePO) {
        return EmployeeDTO.builder()
                .id(employeePO.getId())
                .account(employeePO.getAccount())
                .password(employeePO.getPassword())
                .employeeName(employeePO.getEmployeeName())
                .email(employeePO.getEmail())
                .phone(employeePO.getPhone())
                .isActive(employeePO.getIsActive())
                .build();
    }
}
