package com.ticket_management_system.central_api.Middleware;

import com.ticket_management_system.central_api.dto.Request.TokenDetailsDto;
import com.ticket_management_system.central_api.dto.Request.UserDetailDto;
import com.ticket_management_system.central_api.dto.Response.TokenResDto;
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

    public String callDecryptTokenEndpoint(String token){
        String url = baseurl + "/verify";
        RequestEntity request = RequestEntity.get(url).header("Authorization",token).build();
        ResponseEntity<TokenDetailsDto> response = restTemplate.exchange(url,HttpMethod.GET,request, TokenDetailsDto.class);
        return response.getBody().getToken();

    }

    public boolean callVerifyAccessEndpoint(String opeationName, String token){
        try{
            String url = baseurl + "/verify/operation/access/" + opeationName;
            RequestEntity request = RequestEntity.get(url).header("Authorization", token).build();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<TokenResDto> resp = restTemplate.exchange(url, HttpMethod.GET, request, TokenResDto.class);
            return resp.getBody().isValid();
        }catch (Exception e){
            return false;
        }
    }
}
