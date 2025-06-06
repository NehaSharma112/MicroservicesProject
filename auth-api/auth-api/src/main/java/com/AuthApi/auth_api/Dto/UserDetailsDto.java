package com.AuthApi.auth_api.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDto {

    String username;
    String password;
    int orgId;
    String role;
}
