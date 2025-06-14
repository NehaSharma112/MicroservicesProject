package com.AuthApi.auth_api.Security;

import com.AuthApi.auth_api.Connector.DBAPI;
import com.AuthApi.auth_api.Models.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Autowired
    DBAPI dbapi;
    @Value("${auth.secret.password}")
    String secretPassword;

    Long expirationTime = 1000000L;

    public String generateToken(String userId, String password, String orgId, String role){
        String info = userId+":"+password+":"+orgId+":"+role;
        String jwtToken = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secretPassword)
                .setSubject(info)
                .compact();
        return jwtToken;
    }

    public String decryptToken(String token){
        String credentials = Jwts.parser().setSigningKey(secretPassword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();//we are taking body of the token and then subject of it which actually contains credentials
        return credentials;
    }

    public boolean verifyToken(String token){
        String credentials = this.decryptToken(token);
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        Employee emp =  dbapi.callGetEmpByEmail(email);
        if(emp==null){
            return false;
        }
        if(emp.getPassword().equals(password)){
            return true;
        }
        return false;
    }

}
