package com.AuthApi.auth_api.Models;

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
public class Role {
    int id;
    String name;
    Organization organization;
    List<Operation> operations;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
