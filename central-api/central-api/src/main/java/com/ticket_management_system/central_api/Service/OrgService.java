package com.ticket_management_system.central_api.Service;

import com.ticket_management_system.central_api.Converter.Mapper.MappingUtil;
import com.ticket_management_system.central_api.Converter.OrgConverter;
import com.ticket_management_system.central_api.Middleware.DbApiIntegration;
import com.ticket_management_system.central_api.Middleware.NotifyApiConnector;
import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import com.ticket_management_system.central_api.dto.Request.OrgReq;
import com.ticket_management_system.central_api.dto.Response.OrgResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    DbApiIntegration dbApiIntegration;

    @Autowired
    NotifyApiConnector notifyApiConnector;

    @Autowired
    RoleService roleService;

    @Autowired
    MappingUtil mappingUtil;

    public OrgResp createOrg(OrgReq orgReq){
        Organization organization = OrgConverter.orgReqToOrg(orgReq);
        Organization respOrg = dbApiIntegration.callCreateOrganization(organization);

        //create this user as by default OrgAdmin
        Roles roles = roleService.createDefaultAdminRole(organization);

        Employee firstEmp = mappingUtil.mapOrgAdminDetailsToEmployee(organization,roles);
        dbApiIntegration.callCreateEmployee(firstEmp);
        notifyApiConnector.notifyAdmin(respOrg);
        return OrgConverter.orgToOrgResp(respOrg);

    }

    public Organization getOrgById(int orgId){
        Organization org = dbApiIntegration.callGetOrgById(orgId);
        return org;

    }

}
