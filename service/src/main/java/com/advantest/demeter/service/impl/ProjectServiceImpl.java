package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.mapper.ProjectMapper;
import com.advantest.demeter.database.po.ProjectPO;
import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.ProjectService;
import com.advantest.demeter.service.dto.ProjectDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectPO> implements ProjectService {
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public ProjectDTO createProject(ProjectDTO project) {
        Long projectId = IdWorker.getId();
        ProjectPO projectPO = ProjectPO.builder()
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
        ProjectPO oldProject = this.getById(project.id());
        ProjectPO projectPO = ProjectPO.builder()
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
    public Boolean deleteProject(Long projectId) {
        return this.removeById(projectId);
    }

    @Override
    public ProjectDTO getProject(Long projectId) {
        ProjectPO projectPO = this.getById(projectId);
        return ProjectDTO.of(projectPO);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return this.list().stream().map(ProjectDTO::of).toList();
    }

    @Override
    public List<ProjectDTO> getProjectsByCurrentEmployee() {
        Long creatorId = employeeService.getCurrentEmployee().id();
        QueryWrapper<ProjectPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creatorId", creatorId);
        return this.list(queryWrapper).stream().map(ProjectDTO::of).toList();
    }
}
