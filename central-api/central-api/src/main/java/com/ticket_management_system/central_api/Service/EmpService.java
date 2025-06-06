package com.ticket_management_system.central_api.Service;

import com.ticket_management_system.central_api.Converter.EmployeeConverter;
import com.ticket_management_system.central_api.Converter.OrgConverter;
import com.ticket_management_system.central_api.Exception.InvalidRoleException;
import com.ticket_management_system.central_api.Exception.UnauthorisedException;
import com.ticket_management_system.central_api.Exception.UserNotFoundException;
import com.ticket_management_system.central_api.Exception.WrongCredentials;
import com.ticket_management_system.central_api.Middleware.AuthApiConnector;
import com.ticket_management_system.central_api.Middleware.DbApiIntegration;
import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import com.ticket_management_system.central_api.dto.Request.*;
import com.ticket_management_system.central_api.dto.Response.EmployeeResp;
import com.ticket_management_system.central_api.dto.Response.OrgResp;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ticket_management_system.central_api.Converter.Mapper.MappingUtil.mapInviteEmployeeDetailsToEmployee;

@Service
public class EmpService {
    @Autowired
    DbApiIntegration dbApiIntegration;

    @Autowired
    RoleService roleService;

    @Autowired
    OrgService orgService;

    @Autowired
    AuthApiConnector authApiConnector;

    public EmployeeResp createEmp(EmployeeReq employeeReq){
        List<String> rolenames = employeeReq.getRoles();
        List<Roles> rolesList = new ArrayList<>();
        for(String rolename:rolenames){
            String properRoleName = rolename.toUpperCase();
            Roles role = roleService.getRoleByName(properRoleName);
            if(role!=null){
                rolesList.add(role);
            }else{
                throw new InvalidRoleException("Invalid role : "+role);
            }
        }
        Employee employee = EmployeeConverter.employeeReqToEmployee(employeeReq,rolesList);
        Employee employee1 = dbApiIntegration.callCreateEmployee(employee);
        return EmployeeConverter.employeeToEmployeeResp(employee1);
    }

    //internal api
    public Employee getEmployeeByEmail(String empEmail){
        return dbApiIntegration.getEmployeeByMail(empEmail);
    }

    public Employee saveEmployeeToDB(Employee employee){
        return dbApiIntegration.callSaveEmployeeEndpoint(employee);
    }

    public String loginEmployee(LoginDto loginDto) {
        Employee emp = this.getEmployeeByEmail(loginDto.getUsername());
        //if emp doesn't exist in db
        if(emp==null){
            throw new UserNotFoundException(loginDto.getUsername()+" does not exist.");
        }
        if(emp.getPassword().equals(loginDto.getPassword())){
            UserDetailDto userDetailDto = new UserDetailDto();
            userDetailDto.setUsername(emp.getEmail());
            userDetailDto.setPassword(emp.getPassword());
            userDetailDto.setRole(emp.getRoleList().get(0).getRoleName());
            userDetailDto.setOrgId(emp.getOrganization().getId());

            String token = authApiConnector.callGetJwtTokenEndpoint(userDetailDto);
            return token;
        }
        throw new WrongCredentials("Wrong password entered");
    }

    public void inviteEmployee(InviteEmployeeDto inviteEmployeeDto, String Authorization) {

        boolean authResp = authService.checkAccessAvailable(Authorization,"INVITE_EMPLOYEE");
        if(authResp==false){
            throw new UnauthorisedException("You don't have access to invite Employee");
        }
        int orgId = inviteEmployeeDto.getOrgId();
        int roleId = inviteEmployeeDto.getRoleId().get(0);
        Organization org = orgService.getOrgById(orgId);
        Roles role = roleService.getRoleById(roleId);
        Employee employee = mapInviteEmployeeDetailsToEmployee(org,role,inviteEmployeeDto);
        Employee employee2 = this.saveEmployeeToDB(employee);
        String token = authApiConnector.callGetJwtTokenEndpoint(EmployeeConverter.employeeDetailsToUserDetailsDto(employee2,orgId,role));

    }
}
