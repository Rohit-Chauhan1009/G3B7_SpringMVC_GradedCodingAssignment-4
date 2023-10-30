package com.GreatLearning.EmployeeManagementRestAPI.service;

import java.util.List;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Role;

public interface RoleService {

	Role saveRole(Role role);

	List<Role> getAllRoles();

	Role getRoleById(Integer id);
}
