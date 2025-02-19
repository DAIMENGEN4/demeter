package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.ProjectTaskAttributeMapper;
import com.advantest.demeter.database.po.ProjectTaskAttributePO;
import com.advantest.demeter.service.ProjectTaskAttributeService;
import com.advantest.demeter.service.dto.ProjectTaskAttributeDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create on 2025/02/19
 * Author: mengen.dai@advantest.com
 */
@Service
public class ProjectTaskAttributeServiceImpl extends ServiceImpl<ProjectTaskAttributeMapper, ProjectTaskAttributePO> implements ProjectTaskAttributeService {
    @Override
    public List<ProjectTaskAttributeDTO> getProjectTaskAttributes(Long projectId) {
        var queryWrapper = new QueryWrapper<ProjectTaskAttributePO>().eq("project_id", projectId);
        List<ProjectTaskAttributePO> projectTaskAttributePOS = this.list(queryWrapper);
        return projectTaskAttributePOS.stream().map(ProjectTaskAttributeDTO::of).toList();
    }
}
