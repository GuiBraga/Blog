package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.ERole;
import com.blog.model.Role;
import com.blog.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Boolean isEmpty() {
    	return repository.findAll().isEmpty();
    }

    public Role save(Role user) {
      return repository.save(user);
    }
    
    public Role findByName(ERole name) {
		return repository.findByName(name).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	}

    public String deleteRole(Long id) {
        Role user = repository.getOne(id);
        
        repository.delete(user);

        return "Role deleted";
    }

}
