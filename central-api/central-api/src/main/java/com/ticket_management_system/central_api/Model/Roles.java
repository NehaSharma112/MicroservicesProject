package com.ticket_management_system.central_api.Model;

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
public class Roles {

    int id;

    String roleName;

    List<Operation> operationList;

    Organization organization;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
