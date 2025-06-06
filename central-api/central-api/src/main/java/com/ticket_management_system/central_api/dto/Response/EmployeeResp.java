package com.ticket_management_system.central_api.dto.Response;

import com.ticket_management_system.central_api.Model.Organization;
import com.ticket_management_system.central_api.Model.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EmployeeResp {

    String name;
    String email;
    Organization organization;
    List<Roles> roleList;
}
