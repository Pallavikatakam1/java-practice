package com.controller;

import java.util.List;
import com.entity.User;
import com.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allows frontend requests
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Operations related to user management")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieves a list of all registered users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieves user details by their ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<User> getUserById(
        @Parameter(description = "ID of the user to be retrieved") @PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    @Operation(summary = "Create new user", description = "Registers a new user in the system")
    @ApiResponse(responseCode = "200", description = "User created successfully")
    public ResponseEntity<User> createUser(
        @Parameter(description = "User object to be created") @RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", description = "Updates existing user information")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User updated successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<User> updateUser(
        @Parameter(description = "ID of the user to be updated") @PathVariable Long id,
        @Parameter(description = "Updated user object") @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", description = "Remove a user from the system")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    public ResponseEntity<?> deleteUser(
        @Parameter(description = "ID of the user to be deleted") @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    @Operation(summary = "Search users by department", description = "Finds users by department name")
    @ApiResponse(responseCode = "200", description = "Search results matching criteria")
    public ResponseEntity<List<User>> searchUsersByDepartment(
        @Parameter(description = "Department name to search for") @RequestParam String department) {
        return ResponseEntity.ok(userService.searchUsersByDepartment(department));
    }
}
