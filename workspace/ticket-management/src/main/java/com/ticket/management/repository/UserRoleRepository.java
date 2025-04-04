package com.ticket.management.repository;

import com.ticket.management.entity.User;
import com.ticket.management.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    
    List<UserRole> findByUser(User user); // Retrieves all roles for a given user
}
