package com.ticket_management_system.central_api.dto.Request;

import com.ticket_management_system.central_api.Model.Organization;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EmployeeReq {

    String name;
    String email;
    String password;
    Organization organization;
//    List<Roles> roleList;
    List<String> roles;
}
