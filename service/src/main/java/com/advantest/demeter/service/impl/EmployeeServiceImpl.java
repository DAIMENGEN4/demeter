package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.EmployeeMapper;
import com.advantest.demeter.database.po.EmployeePO;
import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.dto.EmployeeDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeePO> implements EmployeeService {

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeePO employeePO = getById(id);
        return EmployeeDTO.parse(employeePO);
    }

    @Override
    public EmployeeDTO getEmployeeByAccount(String account) {
        QueryWrapper<EmployeePO> queryWrapper = new QueryWrapper<EmployeePO>().eq("account", account);
        EmployeePO employeePO = getOne(queryWrapper);
        return EmployeeDTO.parse(employeePO);
    }
}
