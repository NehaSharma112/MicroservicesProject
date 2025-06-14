package com.AuthApi.auth_api.Service;

import com.AuthApi.auth_api.Connector.DBAPI;
import com.AuthApi.auth_api.Models.Operation;
import com.AuthApi.auth_api.Models.Role;
import com.AuthApi.auth_api.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DBAPI dbapi;

    public boolean isValidAccess(String token, String oprName){
        String information = jwtUtil.decryptToken(token);
        String [] infoArr = information.split(":");
        String role = infoArr[2];
        int orgId = Integer.parseInt(infoArr[3]);
        Role roleDb = dbapi.callGetRoleByOrgIdEndpoint(orgId, role);
        List<Operation> operations = roleDb.getOperations();
        for(Operation opr: operations){
            if(opr.getName().equals(oprName)){
                return true;
            }
        }
        return false;
    }
}
