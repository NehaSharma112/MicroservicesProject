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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String description;

    @ManyToOne
    Task task;
    LocalDateTime createdAt;

//    @ManyToOne
//    Employee performedBy;

//    @Enumerated(EnumType.STRING)
//    Operation operation;


}
