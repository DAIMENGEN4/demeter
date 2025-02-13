package com.advantest.demeter.service.impl;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.database.mapper.EmployeeMapper;
import com.advantest.demeter.database.po.EmployeePO;
import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.dto.EmployeeDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeePO> implements EmployeeService {

    @Override
    public EmployeeDTO getCurrentEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<EmployeeDetails> optional = EmployeeDetails.parse(authentication.getPrincipal());
        if (optional.isPresent()) {
            EmployeeDetails employeeDetails = optional.get();
            EmployeePO employeePO = getById(employeeDetails.getEmployeeId());
            return EmployeeDTO.of(employeePO);
        }
        throw new IllegalStateException("Invalid authentication state: Failed to retrieve employee details from authentication context");
    }

    @Override
    public Boolean registerEmployee(EmployeeDTO employeeDTO) {
        long employeeId = IdWorker.getId();
        // createDateTime mybatis-plus 自动插入, 对于新增, updaterId 和 updaterDateTime 为空!
        EmployeePO employeePO = EmployeePO.builder()
                .id(employeeId)
                .username(employeeDTO.username())
                .password(employeeDTO.password())
                .employeeName(employeeDTO.employeeName())
                .email(employeeDTO.email())
                .phone(employeeDTO.phone())
                .isActive(employeeDTO.isActive())
                .creatorId(employeeId)
                .build();
        return this.save(employeePO);
    }

    @Override
    public Boolean createEmployee(EmployeeDTO employeeDTO) {
        // id, creatorId, createDateTime mybatis-plus 自动插入, 对于新增, updaterId 和 updaterDateTime 为空!
        EmployeePO employeePO = EmployeePO.builder()
                .username(employeeDTO.username())
                .password(employeeDTO.password())
                .employeeName(employeeDTO.employeeName())
                .email(employeeDTO.email())
                .phone(employeeDTO.phone())
                .isActive(employeeDTO.isActive())
                .build();
        return this.save(employeePO);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeePO employeePO = getById(id);
        return EmployeeDTO.of(employeePO);
    }

    @Override
    public EmployeeDTO getEmployeeByUsername(String username) {
        QueryWrapper<EmployeePO> queryWrapper = new QueryWrapper<EmployeePO>().eq("username", username);
        EmployeePO employeePO = getOne(queryWrapper);
        return EmployeeDTO.of(employeePO);
    }
}
