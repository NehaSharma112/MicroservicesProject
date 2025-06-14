package com.ticket_management_system.central_api.dto.Request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectDto {

    String name;
    String description;
    int orgId;
}
