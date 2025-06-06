package com.ticket_management_system.central_api.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrgReq {

    String name;
    String websiteUrl;
    int companySize;
    String companyAddress;
    String adminName;
    String adminEmail;
    String adminPassword;


}
