package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.DepartmentPO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record DepartmentDTO(
        Long id,
        String departmentName,
        String description
) {
    public static DepartmentDTO of(DepartmentPO departmentPO) {
        return new DepartmentDTO(
                departmentPO.getId(),
                departmentPO.getDepartmentName(),
                departmentPO.getDescription()
        );
    }
}
