package com.ticket_management_system.central_api.Service;

import com.ticket_management_system.central_api.Middleware.DbApiIntegration;
import com.ticket_management_system.central_api.Model.Operation;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RoleService {
    @Autowired
    DbApiIntegration dbApiIntegration;

    @Autowired
    OperationService operationService;

    public Roles createDefaultAdminRole(Organization organization){
        List<Operation> oprs = operationService.getAllOperations();
        return Roles.builder().createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .roleName("ORG_ADMIN")
                .organization(organization).operationList(oprs)
                .build();
//        Roles roles = new Roles();
//        roles.setCreatedAt(LocalDateTime.now());
//        roles.setUpdatedAt(LocalDateTime.now());
//        roles.setRoleName("ORG_ADMIN");
//        roles.setOrganization(oprs);
    }
    public Roles getRoleByName(String name){
        return dbApiIntegration.callGetRoleByName(name);
    }

    public Roles getRoleById(int roleId) {
        return dbApiIntegration.callGetRoleById(roleId);
    }
}
