package com.AuthApi.auth_api.Connector;

import com.AuthApi.auth_api.Models.Employee;
import com.AuthApi.auth_api.Models.Role;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DBAPI {

    @Value("${db.api.base.url}")
    String baseurl;

    RestTemplate restTemplate = new RestTemplate();

    public Employee callGetEmpByEmail(String email){
        String url = baseurl + "/employee/get/email/" + email;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<Employee> resp =restTemplate.exchange(url, HttpMethod.GET, request, Employee.class);
        return resp.getBody();
    }


    public Role callGetRoleByOrgIdEndpoint(int orgId, String roleName) {
        String url = baseurl + "/role/" + orgId + "/"+roleName;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<Role> resp =restTemplate.exchange(url, HttpMethod.GET, request, Role.class);
        return resp.getBody();
    }
}
