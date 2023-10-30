package com.GreatLearning.EmployeeManagementRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.EmployeeManagementRestAPI.entity.User;
import com.GreatLearning.EmployeeManagementRestAPI.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/api/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/api/users")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/api/users/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
}
