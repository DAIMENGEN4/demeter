package com.advantest.demeter.service;

import com.advantest.demeter.database.po.ProjectTaskPO;
import com.advantest.demeter.service.dto.ProjectTaskDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public interface ProjectTaskService extends IService<ProjectTaskPO> {

    List<ProjectTaskDTO> getProjectTasksByProjectId(Long projectId);
}
