package com.ticket_management_system.central_api.dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class InviteEmployeeDto {
    String name;
    String email;
    String password;
    int orgId;
    List<Integer> roleId;
}
