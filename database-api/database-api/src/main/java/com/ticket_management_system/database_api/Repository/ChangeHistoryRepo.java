package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeHistoryRepo extends JpaRepository<TaskHistory, Integer> {
}
