package com.AuthApi.auth_api.Connector;

import com.AuthApi.auth_api.Models.Employee;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class DBAPI {

    @Value("${db.api.base.url}")
    String baseurl;


}
