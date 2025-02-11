package com.advantest.demeter.service;

import com.advantest.demeter.database.po.EmployeePO;
import com.advantest.demeter.service.dto.EmployeeDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public interface EmployeeService extends IService<EmployeePO> {

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO getEmployeeByAccount(String account);
}
