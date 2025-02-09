package com.advantest.demeter.service;

import com.advantest.demeter.database.entity.ProjectTaskEntity;
import com.advantest.demeter.database.mapper.*;
import com.advantest.demeter.database.service.ProjectTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl extends ServiceImpl<ProjectTaskMapper, ProjectTaskEntity> implements ProjectTaskService {
    private final ProjectTaskAttributeMapper taskAttributeMapper;
    private final ProjectTaskAttributeBooleanValueMapper taskAttributeBooleanValueMapper;
    private final ProjectTaskAttributeDatetimeValueMapper taskAttributeDatetimeValueMapper;
    private final ProjectTaskAttributeDateValueMapper taskAttributeDateValueMapper;
    private final ProjectTaskAttributeDoubleValueMapper taskAttributeDoubleValueMapper;
    private final ProjectTaskAttributeFloatValueMapper taskAttributeFloatValueMapper;
    private final ProjectTaskAttributeIntegerValueMapper taskAttributeIntegerValueMapper;
    private final ProjectTaskAttributeJsonValueMapper taskAttributeJsonValueMapper;
    private final ProjectTaskAttributeLongtextValueMapper taskAttributeLongtextValueMapper;
    private final ProjectTaskAttributeLongValueMapper taskAttributeLongValueMapper;
    private final ProjectTaskAttributeMediumtextValueMapper taskAttributeMediumtextValueMapper;
    private final ProjectTaskAttributeStringValueMapper taskAttributeStringValueMapper;
    private final ProjectTaskAttributeTextValueMapper taskAttributeTextValueMapper;
}
