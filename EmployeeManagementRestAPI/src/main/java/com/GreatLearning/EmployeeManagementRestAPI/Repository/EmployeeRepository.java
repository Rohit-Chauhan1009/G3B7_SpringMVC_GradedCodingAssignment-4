package com.GreatLearning.EmployeeManagementRestAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE %:firstName%")  
	List<Employee> findEmployeeByFirstName(@Param("firstName") String firstName);

	    List<Employee> findAllByOrderByFirstNameAsc();

	    List<Employee> findAllByOrderByFirstNameDesc();
	    
}
