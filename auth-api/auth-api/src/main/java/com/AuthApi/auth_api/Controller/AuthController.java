package com.AuthApi.auth_api.Controller;

import com.AuthApi.auth_api.Dto.UserDetailsDto;
import com.AuthApi.auth_api.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestBody("/api/auth/token")
public class AuthController {
    @Autowired
    JwtUtil jwtUtil;

    @PutMapping("/get")
    public ResponseEntity generateToken(@RequestBody UserDetailsDto userDetailsDto){
        String orgId = ""+userDetailsDto.getOrgId();
        String token = jwtUtil.generateToken(userDetailsDto.getUsername(), userDetailsDto.getPassword(), orgId, userDetailsDto.getRole());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


}
