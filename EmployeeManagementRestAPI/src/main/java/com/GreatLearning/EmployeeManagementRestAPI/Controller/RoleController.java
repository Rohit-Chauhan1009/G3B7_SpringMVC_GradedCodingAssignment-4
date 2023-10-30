package com.GreatLearning.EmployeeManagementRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Role;
import com.GreatLearning.EmployeeManagementRestAPI.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleservice;

	public RoleController(RoleService roleservice) {
		this.roleservice = roleservice;
	}

	@PostMapping("/api/roles")
	public Role createRole(@RequestBody Role role) {
		return roleservice.saveRole(role);
	}

	@GetMapping("/api/roles")
	public List<Role> getAllRoles() {
		return roleservice.getAllRoles();
	}

	@GetMapping("/api/roles/{id}")
	public Role getRoleById(@PathVariable Integer id) {
		return roleservice.getRoleById(id);
	}

}
