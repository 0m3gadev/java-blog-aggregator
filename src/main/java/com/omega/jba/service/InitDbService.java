package com.omega.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omega.jba.entity.Blog;
import com.omega.jba.entity.Role;
import com.omega.jba.entity.User;
import com.omega.jba.entity.Item;
import com.omega.jba.repository.BlogRepositories;
import com.omega.jba.repository.ItemRepositories;
import com.omega.jba.repository.RoleRepositories;
import com.omega.jba.repository.UserRepositories;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepositories roleRepository;
	
	@Autowired
	private UserRepositories userRepository;
	
	@Autowired
	private ItemRepositories itemRepository;
	
	@Autowired
	private BlogRepositories blogRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles =  new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JavaVids");
		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
			
		
			
	}
	
}
