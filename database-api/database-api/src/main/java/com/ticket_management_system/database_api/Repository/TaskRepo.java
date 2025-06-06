package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {
}
