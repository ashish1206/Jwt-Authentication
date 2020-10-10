package com.project.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.auth.dao.AuthDao;
import com.project.auth.model.AuthRequest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AuthDao authDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthRequest user = authDao.getUserDetails(username);
		if(user != null) {
			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("incorrect username");
		}
	}

}
