package com.GreatLearning.EmployeeManagementRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Employee;
import com.GreatLearning.EmployeeManagementRestAPI.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/api/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/api/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/api/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/api/employees/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchEmployeesByFirstName(@PathVariable String firstName) {
		return employeeService.searchEmployeeByFirstName(firstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortEmployeesInOrder(@RequestParam("order") String order) {
		return employeeService.sortEmployeeByOrder(order);
	}

}
