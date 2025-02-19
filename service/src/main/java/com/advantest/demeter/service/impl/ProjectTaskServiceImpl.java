package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.*;
import com.advantest.demeter.database.po.ProjectTaskPO;
import com.advantest.demeter.service.ProjectTaskAttributeService;
import com.advantest.demeter.service.ProjectTaskService;
import com.advantest.demeter.service.dto.ProjectTaskAttributeDTO;
import com.advantest.demeter.service.dto.ProjectTaskDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl extends ServiceImpl<ProjectTaskMapper, ProjectTaskPO> implements ProjectTaskService {
    private final ProjectTaskAttributeService taskAttributeService;
    private final ProjectTaskAttributeTinyintValueMapper taskAttributeBooleanValueMapper;
    private final ProjectTaskAttributeDatetimeValueMapper taskAttributeDatetimeValueMapper;
    private final ProjectTaskAttributeDateValueMapper taskAttributeDateValueMapper;
    private final ProjectTaskAttributeDoubleValueMapper taskAttributeDoubleValueMapper;
    private final ProjectTaskAttributeFloatValueMapper taskAttributeFloatValueMapper;
    private final ProjectTaskAttributeIntValueMapper taskAttributeIntegerValueMapper;
    private final ProjectTaskAttributeJsonValueMapper taskAttributeJsonValueMapper;
    private final ProjectTaskAttributeLongtextValueMapper taskAttributeLongtextValueMapper;
    private final ProjectTaskAttributeBigintValueMapper taskAttributeLongValueMapper;
    private final ProjectTaskAttributeMediumtextValueMapper taskAttributeMediumtextValueMapper;
    private final ProjectTaskAttributeVarcharValueMapper taskAttributeStringValueMapper;
    private final ProjectTaskAttributeTextValueMapper taskAttributeTextValueMapper;

    @Override
    @Transactional
    public List<ProjectTaskDTO> getProjectTasksByProjectId(Long projectId) {
        List<ProjectTaskAttributeDTO> taskAttributes = taskAttributeService.getProjectTaskAttributes(projectId);
        return List.of();
    }
}
