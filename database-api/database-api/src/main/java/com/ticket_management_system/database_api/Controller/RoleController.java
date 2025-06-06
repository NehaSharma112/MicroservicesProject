package com.ticket_management_system.database_api.Controller;

import com.ticket_management_system.database_api.Model.Role;
import com.ticket_management_system.database_api.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/db/roles")
public class RoleController {

    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/{roleName}")
    public Role getRoleByName(@PathVariable String roleName){
        return roleRepo.getByRoleName(roleName);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getRoleByName(@PathVariable int roleId){
        try {
            return new ResponseEntity<>(roleRepo.findById(roleId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
