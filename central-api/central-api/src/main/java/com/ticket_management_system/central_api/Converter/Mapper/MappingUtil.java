package com.ticket_management_system.central_api.Converter.Mapper;

import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Enum.EmployeeStatus;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import com.ticket_management_system.central_api.dto.Request.InviteEmployeeDto;

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
}
