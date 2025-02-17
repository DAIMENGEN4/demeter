package com.advantest.demeter.service;

import com.advantest.demeter.common.dto.SelectOptionDTO;
import com.advantest.demeter.database.po.ProjectPO;
import com.advantest.demeter.service.dto.ProjectDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public interface ProjectService extends IService<ProjectPO> {

    ProjectDTO createProject(ProjectDTO project);

    ProjectDTO updateProject(ProjectDTO project);

    Boolean deleteProject(Long projectId);

    ProjectDTO getProject(Long projectId);

    List<ProjectDTO> getAllProjects();

    List<ProjectDTO> getProjectsByCurrentEmployee();

    List<SelectOptionDTO<Integer>> getProjectStatusSelectOptions();
}
