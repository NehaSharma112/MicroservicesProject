package com.ticket_management_system.database_api.Controller;

import com.ticket_management_system.database_api.Model.Role;
import com.ticket_management_system.database_api.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity saveRole(@RequestBody Role role){
        roleRepo.save(role);
        return new ResponseEntity(role, HttpStatus.OK);
    }

    @GetMapping("/{orgId}/{roleName}")
    public ResponseEntity getRoleByOrgId(@PathVariable int orgId,
                                         @PathVariable String roleName){
        Role role = roleRepo.getRoleByOrgIdAndRoleName(orgId, roleName);
        return new ResponseEntity(role, HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getRoleById(@PathVariable int roleId){
        Role role = roleRepo.findById(roleId).orElse(null);
        return new ResponseEntity(role, HttpStatus.OK);
    }


}
