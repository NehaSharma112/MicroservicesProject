package com.ticket_management_system.database_api.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String projectName;
    String projectDescription;

    @OneToMany
    List<Employee> employeeList;
}
