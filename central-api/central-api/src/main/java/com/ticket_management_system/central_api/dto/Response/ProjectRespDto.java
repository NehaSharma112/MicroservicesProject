package com.ticket_management_system.central_api.dto.Response;

import com.ticket_management_system.central_api.Model.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProjectRespDto {
    String name;
    String description;
    List<Employee> employees;
}
