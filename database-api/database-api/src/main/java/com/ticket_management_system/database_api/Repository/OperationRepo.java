package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation, Integer> {
}
