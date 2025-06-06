package com.ticket_management_system.database_api.Model;

import com.ticket_management_system.database_api.Model.Enum.EmployeeStatus;
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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @Column(unique = true)
    String email;
    String password;

    @ManyToOne
    @JoinColumn(name = "orgId")
    Organization organization;

    @OneToMany
    List<Role> roleList;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    EmployeeStatus status;

}
