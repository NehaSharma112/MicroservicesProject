package com.ticket_management_system.central_api.dto.Response;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrgResp {

    String name;
    String websiteUrl;
    int companySize;
    String companyAddress;
    String adminName;
    String adminEmail;
}
