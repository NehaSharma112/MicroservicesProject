package com.ticket_management_system.database_api.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)//to make every var private
@Builder
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true)
    String name;

    @Column(unique = true)
    String websiteUrl;
    int companySize;
    String companyAddress;
    String adminName;
    String adminPassword;
    @Column(unique = true)
    String adminEmail;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
