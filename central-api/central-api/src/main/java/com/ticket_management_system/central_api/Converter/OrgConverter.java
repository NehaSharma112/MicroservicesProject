package com.ticket_management_system.central_api.Converter;

import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.dto.Request.OrgReq;
import com.ticket_management_system.central_api.dto.Response.OrgResp;

public class OrgConverter {
    public static Organization orgReqToOrg(OrgReq orgReq){
         return Organization.builder()
                .name(orgReq.getName())
                .websiteUrl(orgReq.getWebsiteUrl())
                .companySize(orgReq.getCompanySize())
                .companyAddress(orgReq.getCompanyAddress())
                .adminName(orgReq.getAdminName())
                .adminEmail(orgReq.getAdminEmail())
                .adminPassword(orgReq.getAdminPassword())
                .build();
    }
    public static OrgResp orgToOrgResp(Organization organization){
        return OrgResp.builder()
                .name(organization.getName())
                .websiteUrl(organization.getWebsiteUrl())
                .companySize(organization.getCompanySize())
                .companyAddress(organization.getCompanyAddress())
                .adminName(organization.getAdminName())
                .adminEmail(organization.getAdminEmail())
                .build();
    }
}
