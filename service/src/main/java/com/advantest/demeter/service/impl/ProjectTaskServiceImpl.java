package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.*;
import com.advantest.demeter.database.po.ProjectTaskPO;
import com.advantest.demeter.service.ProjectTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl extends ServiceImpl<ProjectTaskMapper, ProjectTaskPO> implements ProjectTaskService {
    private final ProjectTaskAttributeMapper taskAttributeMapper;
    private final ProjectTaskAttributeTinyintValueMapper taskAttributeBooleanValueMapper;
    private final ProjectTaskAttributeDatetimeValueMapper taskAttributeDatetimeValueMapper;
    private final ProjectTaskAttributeDateValueMapper taskAttributeDateValueMapper;
    private final ProjectTaskAttributeDoubleValueMapper taskAttributeDoubleValueMapper;
    private final ProjectTaskAttributeFloatValueMapper taskAttributeFloatValueMapper;
    private final ProjectTaskAttributeIntValueMapper taskAttributeIntegerValueMapper;
    private final ProjectTaskAttributeJsonValueMapper taskAttributeJsonValueMapper;
    private final ProjectTaskAttributeLongtextValueMapper taskAttributeLongtextValueMapper;
    private final ProjectTaskAttributeLongValueMapper taskAttributeLongValueMapper;
    private final ProjectTaskAttributeMediumtextValueMapper taskAttributeMediumtextValueMapper;
    private final ProjectTaskAttributeStringValueMapper taskAttributeStringValueMapper;
    private final ProjectTaskAttributeTextValueMapper taskAttributeTextValueMapper;
}
