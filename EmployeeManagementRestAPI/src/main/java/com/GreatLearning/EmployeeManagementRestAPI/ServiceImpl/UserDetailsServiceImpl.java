package com.GreatLearning.EmployeeManagementRestAPI.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.GreatLearning.EmployeeManagementRestAPI.Repository.UserRepository;
import com.GreatLearning.EmployeeManagementRestAPI.entity.User;
import com.GreatLearning.EmployeeManagementRestAPI.security.EmployeeUserDetail;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUserName(username);

        if (user == null) {
        	throw new UsernameNotFoundException("Could not find user!!!");
        }

        return new EmployeeUserDetail(user);
    }
	
}
