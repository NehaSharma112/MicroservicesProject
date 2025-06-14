package com.ticket_management_system.central_api.Service;

import com.ticket_management_system.central_api.Converter.Mapper.MappingUtil;
import com.ticket_management_system.central_api.Exception.UnauthorisedException;
import com.ticket_management_system.central_api.Middleware.NotifyApiConnector;
import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Project;
import com.ticket_management_system.central_api.dto.Request.ProjectDto;
import com.ticket_management_system.central_api.dto.Response.ProjectRespDto;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {
    @Autowired
    AuthService authService;

    @Autowired
    OrgService orgService;

    @Autowired
    EmpService empService;

    @Autowired
    NotifyApiConnector notifyApiConnector;

    public ProjectRespDto createProject(ProjectDto projectDto, String Authorization){
        boolean authResp = authService.checkAccessAvailable(Authorization, "CREATE_PROJECT");
        if(authResp == false){
            throw new UnauthorisedException("User doesn't have access");
        }
        String creatorEmail = authService.getEmailFromJwtToken(Authorization);
        Employee creator = empService.getEmployeeByEmail(creatorEmail);//now we have emp to add
        Organization org = orgService.getOrgById(projectDto.getOrgId());
        Project proj = MappingUtil.mapCreateProjectFromCreateProjectDto(projectDto,org,creator);// project object to save in db
        notifyApiConnector.callCreateProjectNotificationEndpoint(proj,Authorization);
        return MappingUtil.mapProjectToProjectRespDto(proj);

    }
}
