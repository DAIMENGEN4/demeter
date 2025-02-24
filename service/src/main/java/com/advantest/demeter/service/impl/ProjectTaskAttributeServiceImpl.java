package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.ProjectTaskAttributeMapper;
import com.advantest.demeter.database.po.ProjectTaskAttributePO;
import com.advantest.demeter.service.ProjectTaskAttributeService;
import com.advantest.demeter.service.dto.ProjectTaskAttributeDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create on 2025/02/19
 * Author: mengen.dai@advantest.com
 */
@Service
public class ProjectTaskAttributeServiceImpl extends ServiceImpl<ProjectTaskAttributeMapper, ProjectTaskAttributePO> implements ProjectTaskAttributeService {
    @Override
    @Transactional
    public ProjectTaskAttributeDTO createProjectTaskAttribute(ProjectTaskAttributeDTO projectTaskAttribute) {
        var taskAttributeId = IdWorker.getId();
        var projectTaskAttributePO = ProjectTaskAttributePO.builder()
                .id(taskAttributeId)
                .projectId(projectTaskAttribute.projectId())
                .taskAttributeName(projectTaskAttribute.taskAttributeName())
                .taskAttributeType(projectTaskAttribute.taskAttributeType().toString())
                .properties(projectTaskAttribute.properties().toPrettyString())
                .order(projectTaskAttribute.order())
                .build();
        if (this.save(projectTaskAttributePO)) {
            return this.getProjectTaskAttribute(taskAttributeId);
        }
        return null;
    }

    @Override
    public ProjectTaskAttributeDTO getProjectTaskAttribute(Long taskAttributeId) {
        ProjectTaskAttributePO taskAttributePO = this.getById(taskAttributeId);
        return ProjectTaskAttributeDTO.of(taskAttributePO);
    }

    @Override
    public List<ProjectTaskAttributeDTO> getProjectTaskAttributes(Long projectId) {
        var queryWrapper = new QueryWrapper<ProjectTaskAttributePO>().eq("project_id", projectId);
        List<ProjectTaskAttributePO> projectTaskAttributePOS = this.list(queryWrapper);
        return projectTaskAttributePOS.stream().map(ProjectTaskAttributeDTO::of).toList();
    }
}
