package com.notification.notificationApi.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Employee {
    int id;
    String name;
    String email;
    String password;
    Organization organization;
}
