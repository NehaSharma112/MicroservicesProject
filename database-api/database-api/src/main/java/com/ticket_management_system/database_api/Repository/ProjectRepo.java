package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
