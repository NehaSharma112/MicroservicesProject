package com.ticket_management_system.central_api.Converter;

import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Enum.EmployeeStatus;
import com.ticket_management_system.central_api.Model.Roles;
import com.ticket_management_system.central_api.dto.Request.EmployeeReq;
import com.ticket_management_system.central_api.dto.Request.InviteEmployeeDto;
import com.ticket_management_system.central_api.dto.Request.UserDetailDto;
import com.ticket_management_system.central_api.dto.Response.EmployeeResp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConverter {
    public static Employee employeeReqToEmployee(EmployeeReq employeeReq,List<Roles> roleList){

        return Employee.builder()
                .name(employeeReq.getName())
                .email(employeeReq.getEmail())
                .password(employeeReq.getPassword())
                .roleList(roleList)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .status(EmployeeStatus.ACTIVE)
                .build();
    }

    public static EmployeeResp employeeToEmployeeResp(Employee employee){
        return EmployeeResp.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .roleList(employee.getRoleList())
                .organization(employee.getOrganization())
                .build();
    }

    public static UserDetailDto employeeDetailsToUserDetailsDto(Employee employee, int orgId,Roles role){
        return UserDetailDto.builder()
                .username(employee.getEmail())
                .password(employee.getPassword())
                .orgId(orgId)
                .role(role.getRoleName())
                .build();
    }
}
