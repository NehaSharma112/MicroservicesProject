package com.ticket_management_system.central_api.Controller;


import com.ticket_management_system.central_api.Service.ProjectService;
import com.ticket_management_system.central_api.dto.Request.ProjectDto;
import com.ticket_management_system.central_api.dto.Response.ProjectRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/proj")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create/project")
    public ProjectRespDto createProject(@RequestBody ProjectDto projectDto, @RequestHeader String Authorization){
        return projectService.createProject(projectDto,Authorization);
    }

}