package com.ticket_management_system.database_api.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;


//Is role X allowed to perform operation Y on resource Z?
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
//@Entity
public class RoleOperationAllowed {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    int id;
//
//    @Enumerated(EnumType.STRING) Operation operation;
//
//    @Enumerated(EnumType.STRING)
//    Role role;
//
//    @Enumerated(EnumType.STRING)
//    Resources resources;
}
