package com.omega.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omega.jba.entity.Item;

public interface ItemRepositories extends JpaRepository<Item, Integer>{
	
	

}
