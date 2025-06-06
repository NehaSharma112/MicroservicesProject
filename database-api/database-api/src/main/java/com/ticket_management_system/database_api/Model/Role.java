package com.ticket_management_system.database_api.Model;

import jakarta.persistence.*;
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
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "Role_Name")
    String roleName;

    //one role can have many operations
    @OneToMany
    List<Operation> operationList;

    @ManyToOne
    Organization organization;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
