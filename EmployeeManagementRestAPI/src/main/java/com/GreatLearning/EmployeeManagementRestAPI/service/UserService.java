package com.GreatLearning.EmployeeManagementRestAPI.service;

import java.util.List;

import com.GreatLearning.EmployeeManagementRestAPI.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User saveUser(User user);

	User getUserById(Long id);

	User getUserByUsername(String username);
}
