package com.languageLearning.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.languageLearning.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRoleName(String roleName);

}
