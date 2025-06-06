package com.ticket_management_system.database_api.Controller;

import com.ticket_management_system.database_api.Model.Employee;
import com.ticket_management_system.database_api.Model.Organization;
import com.ticket_management_system.database_api.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/db/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @PostMapping("/save")
    public ResponseEntity createOrganization(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity getEmployeeByEmail(@PathVariable String email){
//        Employee emp = employeeRepo.getEmployeeByEmail(email);
        Employee emp = employeeRepo.findByEmail(email);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
