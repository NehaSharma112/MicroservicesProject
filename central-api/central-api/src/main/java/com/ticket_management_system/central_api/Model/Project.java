package com.ticket_management_system.central_api.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    int id;
    String name;
    String description;

    List<Employee> employees;

    Organization organization;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
