package com.ticket.management.service;

import com.ticket.management.dto.UserRoleRequest;
import com.ticket.management.entity.User;
import com.ticket.management.entity.UserRole;
import com.ticket.management.repository.UserRepository;
import com.ticket.management.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    UserRoleRepository userRoleRepository;
    
    public List<User> getAllUsers() {	
        return userRepository.findAll();
    }

    @Transactional
    public User createUserWithRole(UserRoleRequest userRoleRequest) {
        
       User user = new User();
        user.setUserName(userRoleRequest.getUserName());
        user.setPassword(userRoleRequest.getPassword());
        user.setName(userRoleRequest.getName());
        user.setEmail(userRoleRequest.getEmail());
        user.setPhoneNumber(userRoleRequest.getPhoneNumber());
        user.setDepartment(userRoleRequest.getDepartment());

        user = userRepository.save(user);

        UserRole userRole = userRoleRepository.findById(userRoleRequest.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found: " + userRoleRequest.getRole()));

        UserRole newUserRole = new UserRole();
        newUserRole.setRoleName(userRole.getRoleName());
        newUserRole.setUser(user);

        userRoleRepository.save(newUserRole);

        List<UserRole> roles = new ArrayList<>();
        roles.add(newUserRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRoleRequest userRoleRequest) {
        return userRepository.findById(id).map(user -> {
            user.setDepartment(userRoleRequest.getDepartment());
            user.setEmail(userRoleRequest.getEmail());
            user.setUserName(userRoleRequest.getUserName());
            user.setPassword(userRoleRequest.getPassword());
            user.setPhoneNumber(userRoleRequest.getPhoneNumber());
            user.setName(userRoleRequest.getName());
            
            user.getRoles().clear();
            
            UserRole userRole = userRoleRepository.findById(userRoleRequest.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found : " + userRoleRequest.getRole()));
            userRole.setUser(user);
            user.getRoles().add(userRole);
            
            return userRepository.save(user); 
        }).orElseThrow(() -> new RuntimeException("User not found : " + id));
    }

}