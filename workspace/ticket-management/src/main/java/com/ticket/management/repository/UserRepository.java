package com.ticket.management.repository;

import com.ticket.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUserName(String userName); // Authentication will check the password manually
    
    Optional<User> findByUserNameAndPassword(String userName, String password); // Can be used if no hashing is needed
}
