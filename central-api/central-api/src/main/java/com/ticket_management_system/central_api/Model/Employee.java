package com.ticket_management_system.central_api.Model;

import com.ticket_management_system.central_api.Model.Enum.EmployeeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
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
    List<Roles> roleList;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    EmployeeStatus status;


}
