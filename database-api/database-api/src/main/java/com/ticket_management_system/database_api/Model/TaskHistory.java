package com.ticket_management_system.database_api.Model;

import com.ticket_management_system.database_api.Model.Enum.Operations;
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
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String description;

    @ManyToOne
    Task task;

//    @ManyToOne
//    Employee performedBy;

//    @Enumerated(EnumType.STRING)
//    Operations operations;
    
    LocalDateTime createdAt;
}
