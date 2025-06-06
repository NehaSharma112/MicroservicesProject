package com.ticket_management_system.central_api.Service;

import com.ticket_management_system.central_api.Middleware.AuthApiConnector;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {
    @Autowired
    AuthApiConnector authApiConnector;
    public String getEmailFromJwtToken(String token){
        String empDetails = authApiConnector.callDecryptTokenEndpoint(token);
        return empDetails.split(":")[0];
    }

    public String getOrgIdFromJwtToken(String token){
        String userDetail = authApiConnector.callDecryptTokenEndpoint(token);
        return userDetail.split(":")[3];
    }

    public boolean checkAccessAvailable(String token, String oprName) {
        return authApiConnector.callCheckAccessAvailable(token,oprName);
    }
}
