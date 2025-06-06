package com.notification.notificationApi.Service;

import com.notification.notificationApi.Model.Organization;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class OrgService {

    @Autowired
    EmailService emailService;
    public void mailAdminForOrgCreation(Organization organization) throws MessagingException {

        String to = organization.getAdminEmail();
        String subject = "Congratulations!! You have been registered as ORG_ADMIN";
        String html = "<h2>Welcome to Our Platform!</h2>" +
                        "<p>Dear " + organization.getAdminName() + ",</p>" +
                        "<p>Your organization <b>" + organization.getName() + "</b> has been successfully registered.</p>" +
                        "<p>You have been assigned the role of <b>ORG_ADMIN</b>.</p>" +
                        "<br>" +
                        "<p>Regards,<br>Team" + organization.getName() +"</p>";

        emailService.sendHtmlEmail(to,subject,html);
    }
}
