package com.ticket_management_system.central_api.Converter.Mapper;

import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Enum.EmployeeStatus;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Project;
import com.ticket_management_system.central_api.Model.Roles;
import com.ticket_management_system.central_api.dto.Request.InviteEmployeeDto;
import com.ticket_management_system.central_api.dto.Request.ProjectDto;
import com.ticket_management_system.central_api.dto.Response.ProjectRespDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MappingUtil {
    public static Employee mapOrgAdminDetailsToEmployee(Organization organization, Roles roles){
        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(roles);
        return Employee.builder()
                .name(organization.getAdminName())
                .email(organization.getAdminEmail())
                .password(organization.getAdminPassword())
                .roleList(rolesList)
                .organization(organization)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Employee mapInviteEmployeeDetailsToEmployee(Organization org, Roles role, InviteEmployeeDto inviteEmployeeDto){
        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(role);

        return Employee.builder()
                .status(EmployeeStatus.INACTIVE)
                .name(inviteEmployeeDto.getName())
                .email(inviteEmployeeDto.getEmail())
                .password(inviteEmployeeDto.getPassword())
                .roleList(rolesList)
                .organization(org)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Project mapCreateProjectFromCreateProjectDto(ProjectDto projectDto, Organization organization, Employee employee){
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        return Project.builder().createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .employees(employeeList)
                .organization(organization)
                .build();
    }

    public static ProjectRespDto mapProjectToProjectRespDto(Project project){
        return ProjectRespDto.builder().description(project.getDescription())
                .name(project.getName())
                .employees(project.getEmployees())
                .build();
    }
}
