package com.balaji.service;

import java.util.List;

import com.balaji.model.User;

public interface UserService{
	
	  public User add(User user);
	
	  public String update(User user);
	              
	  public String delete(Integer id);
	
	  public User findById(Integer id);
	
	
	   public List<User> findAll();
	
	}

