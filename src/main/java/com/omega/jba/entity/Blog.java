package com.omega.jba.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {
		@Id
		@GeneratedValue
		private Integer id;
		private String url;
		private String name;
		
		@ManyToOne
		@JoinColumn(name="user_id")
		private User user;
		
		
		public List<Item> getItems() {
			return Items;
		}
		public void setItems(List<Item> items) {
			Items = items;
		}
		@OneToMany(mappedBy="blog")
		private List<Item> Items;
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
