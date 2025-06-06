package com.notification.notificationApi.Controller;

import com.notification.notificationApi.Model.Organization;
import com.notification.notificationApi.Service.OrgService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify/organization")
public class OrganizationController {
    @Autowired
    OrgService orgService;

    @PutMapping("/createOrg")
    public void notifyAdminForOrgCreation(Organization organization) throws MessagingException {
        orgService.mailAdminForOrgCreation(organization);
    }
}
