package com.omega.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omega.jba.entity.User;

public interface UserRepositories extends JpaRepository<User, Integer>{
	
	

}
