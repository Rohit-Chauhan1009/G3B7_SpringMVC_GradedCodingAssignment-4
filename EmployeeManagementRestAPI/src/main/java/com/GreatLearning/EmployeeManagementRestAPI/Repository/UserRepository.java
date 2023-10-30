package com.GreatLearning.EmployeeManagementRestAPI.Repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GreatLearning.EmployeeManagementRestAPI.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username =?1")
	public User getUserByUserName(String username);
}
