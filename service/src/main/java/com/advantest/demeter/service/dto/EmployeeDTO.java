package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.EmployeePO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record EmployeeDTO(
        Long id,
        String username,
        String password,
        String employeeName,
        String email,
        String phone,
        Boolean isActive
) {
    public static EmployeeDTO parse(EmployeePO employeePO) {
        return new EmployeeDTO(
                employeePO.getId(),
                employeePO.getUsername(),
                employeePO.getPassword(),
                employeePO.getEmployeeName(),
                employeePO.getEmail(),
                employeePO.getPhone(),
                employeePO.getIsActive()
        );
    }
}
