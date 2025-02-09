package com.advantest.demeter.service;

import com.advantest.demeter.database.entity.EmployeeEntity;
import com.advantest.demeter.database.mapper.EmployeeMapper;
import com.advantest.demeter.database.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {
}
