package com.GreatLearning.EmployeeManagementRestAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GreatLearning.EmployeeManagementRestAPI.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
