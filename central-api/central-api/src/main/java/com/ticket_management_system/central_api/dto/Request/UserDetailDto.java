package com.ticket_management_system.central_api.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailDto {
    String username;
    String password;
    int orgId;
    String role;
}
