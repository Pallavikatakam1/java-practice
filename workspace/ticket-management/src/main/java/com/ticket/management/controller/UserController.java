package com.ticket.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.management.dto.UserRoleRequest;
import com.ticket.management.entity.LoginRequest;
import com.ticket.management.entity.User;
import com.ticket.management.repository.UserRoleRepository;
import com.ticket.management.repository.UserRepository;
import com.ticket.management.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * Get all users except the ones that are soft deleted
     */
    @GetMapping("/all")
    public List<User> getUsers(){
		return userService.getAllUsers();
	}

    @PostMapping("/users/add")
    @ResponseStatus(code = HttpStatus.CREATED)
	public User createUsersWithRole(@RequestBody UserRoleRequest userRoleRequest) {
        if (userRoleRequest.getRole() == null) { 
            throw new IllegalArgumentException("Role ID cannot be null.");
        }
        return userService.createUserWithRole(userRoleRequest);
    }
    
    @PutMapping("/users/update/{id}")
	public User updateUsers(@PathVariable Long id, @RequestBody UserRoleRequest userRoleRequest) {
        return userService.updateUser(id, userRoleRequest);
    }
    /**
     * User Login
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
		User user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword()).orElse(null);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.status(401).body("Invalid credentials...");
		}
    }
}
	
