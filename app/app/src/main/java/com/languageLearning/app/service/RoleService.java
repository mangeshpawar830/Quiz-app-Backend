package com.languageLearning.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.languageLearning.app.model.Role;
import com.languageLearning.app.repo.RoleRepository;

@Service
public class RoleService {
	
	  @Autowired
	    private RoleRepository roleRepository;

	    	public Role findRoleByName(String roleName) {
	        return roleRepository.findByRoleName(roleName);
	    }

}
