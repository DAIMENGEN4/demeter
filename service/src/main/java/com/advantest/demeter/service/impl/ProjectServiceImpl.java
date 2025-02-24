package com.advantest.demeter.service.impl;

import com.advantest.demeter.common.dto.SelectOptionDTO;
import com.advantest.demeter.database.mapper.ProjectMapper;
import com.advantest.demeter.database.po.ProjectPO;
import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.ProjectService;
import com.advantest.demeter.service.constants.ProjectStatus;
import com.advantest.demeter.service.dto.ProjectDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectPO> implements ProjectService {
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public ProjectDTO createProject(ProjectDTO project) {
        var projectId = IdWorker.getId();
        var projectPO = ProjectPO.builder()
                .id(projectId)
                .projectName(project.projectName())
                .description(project.description())
                .startDateTime(project.startDateTime())
                .endDateTime(project.endDateTime())
                .projectStatus(project.projectStatus().toInt())
                .version(project.version())
                .order(project.order())
                .build();
        if (this.save(projectPO)) {
            return this.getProject(projectId);
        }
        throw new RuntimeException("Failed to create project");
    }

    @Override
    @Transactional
    public ProjectDTO updateProject(ProjectDTO project) {
        var oldProject = this.getById(project.id());
        var projectPO = ProjectPO.builder()
                .id(project.id())
                .projectName(project.projectName())
                .description(project.description())
                .startDateTime(project.startDateTime())
                .endDateTime(project.endDateTime())
                .projectStatus(project.projectStatus().toInt())
                .version(project.version())
                .order(project.order())
                .creatorId(oldProject.getCreatorId())
                .createDateTime(oldProject.getCreateDateTime())
                .build();
        if (this.updateById(projectPO)) {
            return this.getProject(project.id());
        }
        throw new RuntimeException("Failed to update project");
    }

    @Override
    public Boolean deleteProject(Long id) {
        return this.removeById(id);
    }

    @Override
    public ProjectDTO getProject(Long id) {
        var projectPO = this.getById(id);
        return ProjectDTO.of(projectPO);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return this.list().stream().map(ProjectDTO::of).toList();
    }

    @Override
    public List<ProjectDTO> getProjectsByCurrentEmployee() {
        var creatorId = employeeService.getCurrentEmployee().id();
        var queryWrapper = new QueryWrapper<ProjectPO>();
        queryWrapper.eq("creator_id", creatorId);
        return this.list(queryWrapper).stream().map(ProjectDTO::of).toList();
    }

    @Override
    public List<SelectOptionDTO<Integer>> getProjectStatusSelectOptions() {
        return Arrays.stream(ProjectStatus.values()).map(status -> new SelectOptionDTO<>(status.toLabel(), status.toInt())).toList();
    }
}
