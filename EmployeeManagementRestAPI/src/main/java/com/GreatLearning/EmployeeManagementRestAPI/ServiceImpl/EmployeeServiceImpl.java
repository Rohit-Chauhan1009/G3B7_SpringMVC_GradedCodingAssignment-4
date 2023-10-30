package com.GreatLearning.EmployeeManagementRestAPI.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.EmployeeManagementRestAPI.Repository.EmployeeRepository;
import com.GreatLearning.EmployeeManagementRestAPI.entity.Employee;
import com.GreatLearning.EmployeeManagementRestAPI.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
			Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employee.getId());

			if (existingEmployeeOptional.isPresent()) {
				Employee existingEmployee = existingEmployeeOptional.get();
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setEmail(employee.getEmail());

				return employeeRepository.save(existingEmployee);
			} else {
				return null;
			}

		} catch (Exception ex) {

			ex.printStackTrace();

			return null;
		}

	}

	@Override
	public void deleteEmployeeById(Long id) {
		try {
			Employee existingEmployee = employeeRepository.findById(id)
					.orElseThrow(() -> new Exception("Employee not found with id " + id));

			employeeRepository.delete(existingEmployee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		return employeeRepository.findEmployeeByFirstName(firstName.toLowerCase());
	}

	@Override
	public List<Employee> sortEmployeeByOrder(String order) {

		List<Employee> employees = null;

		if (order.toLowerCase().equals("asc")) {
			employees = employeeRepository.findAllByOrderByFirstNameAsc();
		} else if (order.toLowerCase().equals("desc")) {
			employees = employeeRepository.findAllByOrderByFirstNameDesc();
		} else {
			throw new RuntimeException("No proper order mentioned");
		}
		return employees;
	}
}
