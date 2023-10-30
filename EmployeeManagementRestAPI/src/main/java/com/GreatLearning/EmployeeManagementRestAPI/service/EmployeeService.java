package com.GreatLearning.EmployeeManagementRestAPI.service;

import java.util.List;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	public List<Employee> searchEmployeeByFirstName(String firstName);

	public List<Employee> sortEmployeeByOrder(String order);
}
