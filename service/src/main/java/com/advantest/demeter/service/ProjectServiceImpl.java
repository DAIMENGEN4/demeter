package com.advantest.demeter.service;

import com.advantest.demeter.database.entity.ProjectEntity;
import com.advantest.demeter.database.mapper.ProjectMapper;
import com.advantest.demeter.database.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {
}
