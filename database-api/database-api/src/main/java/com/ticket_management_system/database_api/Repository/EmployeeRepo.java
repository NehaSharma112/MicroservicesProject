package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

//    @Query(value = "SELECT * FROM employee WHERE email = :email", nativeQuery = true)
//    Employee getEmployeeByEmail(String email);

    Employee findByEmail(String email);
}
