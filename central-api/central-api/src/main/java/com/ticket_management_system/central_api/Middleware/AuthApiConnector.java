package com.ticket_management_system.central_api.Middleware;

import com.ticket_management_system.central_api.dto.Request.UserDetailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthApiConnector {

    @Value("${auth.api.base.url}")
    String baseurl;

    RestTemplate restTemplate = new RestTemplate();

    public String callGetJwtTokenEndpoint(UserDetailDto userDetailDto) {
        String url = baseurl+"/get";
        RequestEntity request = RequestEntity.put(url).body(userDetailDto);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT,request,String.class);
        return response.getBody();
    }
}
