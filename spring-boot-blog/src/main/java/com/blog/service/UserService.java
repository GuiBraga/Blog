package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.model.User;
import com.blog.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    @Autowired
	PasswordEncoder encoder;

    public Boolean isEmpty() {
    	return repository.findAll().isEmpty();
    }

    public User create(User user) {
    	user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
      }
    
    public User save(User user) {
      return repository.save(user);
    }

    public String deleteUser(Long id) {
        User user = repository.getOne(id);
        
        repository.delete(user);

        return "User deleted";
    }

	public boolean existsByUsername(String username) {
		return repository.existsByUsername(username);
	}

	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	}

	public User getUser(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		user.setPassword(null);
		return user;
	}

}
