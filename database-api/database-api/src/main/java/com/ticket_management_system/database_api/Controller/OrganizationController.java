package com.ticket_management_system.database_api.Controller;

import com.ticket_management_system.database_api.Model.Organization;
import com.ticket_management_system.database_api.Repository.OrganizationRepo;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/db/organization")
public class OrganizationController {

    @Autowired
    OrganizationRepo organizationRepo;

    @GetMapping("{id}")
    public ResponseEntity getOrganizationById(@PathVariable int id){
        try {
            return new ResponseEntity<>(organizationRepo.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity createOrganization(@RequestBody Organization organization){
        organizationRepo.save(organization);
        return new ResponseEntity<>(organization,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrganization(@PathVariable int id){
        organizationRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrganization(@PathVariable int id, @RequestBody Organization organization){
        Optional<Organization> optionalOrganization = organizationRepo.findById(id);
        if (optionalOrganization.isEmpty()) {
            return new ResponseEntity<>("Organization not found", HttpStatus.NOT_FOUND);
        }
        Organization existingOrg = optionalOrganization.get();
        existingOrg.setName(organization.getName());
        existingOrg.setWebsiteUrl(organization.getWebsiteUrl());
        existingOrg.setCompanyAddress(organization.getCompanyAddress());
        existingOrg.setCompanySize(organization.getCompanySize());

        organizationRepo.save(existingOrg);
        return new ResponseEntity<>(existingOrg,HttpStatus.OK);

    }
}
