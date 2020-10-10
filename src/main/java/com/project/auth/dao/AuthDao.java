package com.project.auth.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.auth.entity.UserEntity;
import com.project.auth.model.AuthRequest;

@Repository
public class AuthDao {
	@Autowired
	EntityManager em;
	
	public AuthRequest getUserDetails(String username) {
		UserEntity userEntity = em.find(UserEntity.class, username);
		if(userEntity != null) {
			AuthRequest user = new AuthRequest();
			user.setUsername(userEntity.getUsername());
			user.setPassword(userEntity.getPassword());
			return user;
		}
		return null;
	}
}
