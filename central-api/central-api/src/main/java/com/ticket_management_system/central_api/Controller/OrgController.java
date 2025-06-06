package com.ticket_management_system.central_api.Controller;

import com.ticket_management_system.central_api.Service.OrgService;
import com.ticket_management_system.central_api.dto.Request.OrgReq;
import com.ticket_management_system.central_api.dto.Response.OrgResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/central/org")
public class OrgController {

    @Autowired
    OrgService orgService;

    @PostMapping("/registartion")
    public OrgResp createOrganization(@RequestBody OrgReq orgReq){
        return orgService.createOrg(orgReq);
    }
}
