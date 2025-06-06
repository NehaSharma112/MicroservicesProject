package com.AuthApi.auth_api.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Employee {
    int id;
    String name;
    String email;
    String password;
    Organization organization;
    List<Role> roleList;
}
