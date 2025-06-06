package com.ticket_management_system.central_api.Middleware;

import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class DbApiIntegration {

    @Value("${db.api.base.url}")
    String baseurl;
    RestTemplate restTemplate = new RestTemplate();

    public Organization callCreateOrganization(Organization organization){
        //create endpoint
        String url = baseurl+"/organization/create";
        //create request
        RequestEntity req = RequestEntity.post(url).body(organization);
        //Hit the request
//        RestTemplate restTemplate = new RestTemplate();
        //exchange method hits the db api
        ResponseEntity<Organization> response= restTemplate.exchange(url, HttpMethod.POST,req, Organization.class);
        return response.getBody();
    }

    public Employee callSaveEmployeeEndpoint(Employee employee) {
        String url = baseurl+"/employee/save";
        RequestEntity req = RequestEntity.post(url).body(employee);
        ResponseEntity<Employee> response= restTemplate.exchange(url, HttpMethod.POST,req, Employee.class);
        return response.getBody();

    }

    public Employee getEmployeeByMail(String email){
//        String url = baseurl+"/employee/get/email/"+email;
//        ResponseEntity<Employee> respEmp = restTemplate.exchange(url,HttpMethod.GET,null,Employee.class);
//        return respEmp.getBody();

        String url = baseurl + "/employee/get/email/" + email;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<Employee> resp =restTemplate.exchange(url, HttpMethod.GET, request, Employee.class);
        return resp.getBody();
    }

    public Organization callGetOrgById(int id){
        String url = baseurl+"/organization/"+id;
        RequestEntity req = RequestEntity.get(URI.create(url)).build();
        ResponseEntity<Organization> response = restTemplate.exchange(url,HttpMethod.GET,req, Organization.class);
        return response.getBody();
    }
    public Employee callCreateEmployee(Employee employee){
        String url = baseurl+"/employee/create";
        RequestEntity req = RequestEntity.post(url).body(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(url,HttpMethod.POST,req, Employee.class);
        return response.getBody();
    }
    public Roles callGetRoleByName(String roleName){
        String url = baseurl+"/roles/"+roleName;
        RequestEntity req = RequestEntity.get(URI.create(url)).build();
        ResponseEntity<Roles> response = restTemplate.exchange(url,HttpMethod.GET,req,Roles.class);
        return response.getBody();
    }

    public Roles callGetRoleById(int roleId) {
        String url = baseurl+"/roles/"+roleId;
        RequestEntity req = RequestEntity.get(URI.create(url)).build();
        ResponseEntity<Roles> response = restTemplate.exchange(url,HttpMethod.GET,req,Roles.class);
        return response.getBody();
    }


}
