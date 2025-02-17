package com.advantest.demeter.api.controller;

import com.advantest.demeter.service.ProjectService;
import com.advantest.demeter.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
