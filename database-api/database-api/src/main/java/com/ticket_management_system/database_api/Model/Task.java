package com.ticket_management_system.database_api.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String description;

    @ManyToOne
    Employee assignee;

    @ManyToOne
    Project project;

    int priority;
    LocalDateTime cratedAt;
    LocalDateTime updatedAt;
}
