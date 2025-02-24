package com.advantest.demeter.service;

import com.advantest.demeter.database.po.ProjectTaskAttributePO;
import com.advantest.demeter.service.dto.ProjectTaskAttributeDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public interface ProjectTaskAttributeService extends IService<ProjectTaskAttributePO> {

    ProjectTaskAttributeDTO createProjectTaskAttribute(ProjectTaskAttributeDTO projectTaskAttribute);

    ProjectTaskAttributeDTO getProjectTaskAttribute(Long id);

    List<ProjectTaskAttributeDTO> getProjectTaskAttributes(Long projectId);

}
