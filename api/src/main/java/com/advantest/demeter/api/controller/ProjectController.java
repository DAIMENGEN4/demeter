package com.advantest.demeter.api.controller;

import com.advantest.demeter.common.dto.SelectOptionDTO;
import com.advantest.demeter.service.ProjectService;
import com.advantest.demeter.service.ProjectTaskAttributeService;
import com.advantest.demeter.service.dto.ProjectDTO;
import com.advantest.demeter.service.dto.ProjectTaskAttributeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectTaskAttributeService projectTaskAttributeService;

    @PostMapping("/createProject")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO project) {
        var projectDTO = projectService.createProject(project);
        return ResponseEntity.ok(projectDTO);
    }

    @PostMapping("/deleteProject")
    public ResponseEntity<Boolean> deleteProject(@RequestBody Long projectId) {
        var result = projectService.deleteProject(projectId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateProject")
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO project) {
        var projectDTO = projectService.updateProject(project);
        return ResponseEntity.ok(projectDTO);
    }

    @PostMapping("/getProjectsByCurrentEmployee")
    public ResponseEntity<List<ProjectDTO>> getProjectsByCurrentEmployee() {
        var projectVOS = projectService.getProjectsByCurrentEmployee();
        return ResponseEntity.ok(projectVOS);
    }

    @PostMapping("/getProjectStatusSelectOptions")
    public ResponseEntity<List<SelectOptionDTO<Integer>>> getProjectStatusSelectOptions() {
        var selectOptions = projectService.getProjectStatusSelectOptions();
        return ResponseEntity.ok(selectOptions);
    }

    @PostMapping("/createProjectTaskAttribute")
    public ResponseEntity<ProjectTaskAttributeDTO> createProjectTaskAttribute(@RequestBody ProjectTaskAttributeDTO projectTaskAttribute) {
        var projectTaskAttributeDTO = projectTaskAttributeService.createProjectTaskAttribute(projectTaskAttribute);
        return ResponseEntity.ok(projectTaskAttributeDTO);
    }
}
