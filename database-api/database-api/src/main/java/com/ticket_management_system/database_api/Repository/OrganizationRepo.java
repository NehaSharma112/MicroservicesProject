package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization, Integer> {
}
