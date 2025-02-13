package com.advantest.demeter.api.controller;

import com.advantest.demeter.api.vo.ProjectVO;
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
    public ResponseEntity<ProjectVO> createProject(@RequestBody ProjectDTO project) {
        ProjectDTO projectDTO = projectService.createProject(project);
        ProjectVO projectVO = ProjectVO.of(projectDTO);
        return ResponseEntity.ok(projectVO);
    }

    @PostMapping("/deleteProject")
    public ResponseEntity<Boolean> deleteProject(@RequestBody Long projectId) {
        Boolean result = projectService.deleteProject(projectId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateProject")
    public ResponseEntity<ProjectVO> updateProject(@RequestBody ProjectDTO project) {
        ProjectDTO projectDTO = projectService.updateProject(project);
        ProjectVO projectVO = ProjectVO.of(projectDTO);
        return ResponseEntity.ok(projectVO);
    }

    @PostMapping("/getProjectsByCurrentEmployee")
    public ResponseEntity<List<ProjectVO>> getProjectsByCurrentEmployee() {
        List<ProjectVO> projectVOS = projectService.getProjectsByCurrentEmployee().stream().map(ProjectVO::of).toList();
        return ResponseEntity.ok(projectVOS);
    }
}
