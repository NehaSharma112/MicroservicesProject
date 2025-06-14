package com.ticket_management_system.database_api.Controller;


import com.ticket_management_system.database_api.Model.Project;
import com.ticket_management_system.database_api.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/proj")
public class ProjectController {
    @Autowired
    ProjectRepo projectRepo;

    @PostMapping("/create/")
    public ResponseEntity createProj(@RequestBody Project project){
        projectRepo.save(project);
        return new ResponseEntity(project, HttpStatus.CREATED);
    }
}
