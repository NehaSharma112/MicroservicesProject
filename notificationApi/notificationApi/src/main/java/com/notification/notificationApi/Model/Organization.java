package com.notification.notificationApi.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)//to make every var private
@Builder
public class Organization {

    int id;
    String name;
    String websiteUrl;
    int companySize;
    String companyAddress;
    String adminName;
    String adminPassword;
    String adminEmail;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
