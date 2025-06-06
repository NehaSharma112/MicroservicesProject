package com.notification.notificationApi.Service;

import com.notification.notificationApi.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    EmailService emailService;


    public void notifyEmployeeForInvitation(Employee employee) {
        String to = employee.getEmail();
        String subject = "You're invited to join "+employee.getOrganization().getName();
        emailService.sendHtmlEmail(to,subject,html);
    }
}
