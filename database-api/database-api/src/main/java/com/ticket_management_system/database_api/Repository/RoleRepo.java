package com.ticket_management_system.database_api.Repository;

import com.ticket_management_system.database_api.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT * FROM role WHERE Role_Name = :roleName", nativeQuery = true)
    Role getByRoleName(String roleName);

//    @Query(value = "SELECT * FROM role WHERE organization_id=:orgId")
//    Role getRoleByOrgIdAndRoleName(int orgId, String roleName);

    @Query(value = "select * from roles where organization_id=:orgId and name=:name", nativeQuery = true)
    public Role getRoleByOrgIdAndRoleName(int orgId, String name);
}
