package com.ticket_management_system.central_api.Middleware;

import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Project;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NotifyApiConnector {

    String baseurl = "http://localhost:8082/api/notify";
    RestTemplate restTemplate = new RestTemplate();

    public void notifyAdmin(Organization organization){
        String url = baseurl+"/organization/createOrg";
        RequestEntity req = RequestEntity.post(url).body(organization);
        restTemplate.exchange(url, HttpMethod.PUT,req, Object.class);
    }

    public void notifyEmployeeForInvitation(Employee employee){
        String url = baseurl+"/employee/";
        RequestEntity req = RequestEntity.post(url).body(employee);
        restTemplate.exchange(url, HttpMethod.PUT,req, Object.class);
    }

    public void callCreateProjectNotificationEndpoint(Project project, String token){
        String url = baseurl + "/proj/create/" +token;
        RequestEntity req = RequestEntity.put(url).body(project);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Project> resp = restTemplate.exchange(url,HttpMethod.PUT,req, Project.class);

    }
}
