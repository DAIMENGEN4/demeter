package com.advantest.demeter.service;

import com.advantest.demeter.database.entity.DepartmentEntity;
import com.advantest.demeter.database.mapper.DepartmentMapper;
import com.advantest.demeter.database.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentEntity> implements DepartmentService {
}
