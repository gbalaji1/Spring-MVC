package com.balaji.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.exception.UserNameNotFoundException;
import com.balaji.exception.UserNotFoundException;
import com.balaji.model.User;
import com.balaji.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User add(User user) {
		return userRepo.save(user);
	}

	@Override
	public String update(User user) {
		userRepo.save(user);
		return "Inserted Successfully";
	}

	@Override
	public String delete(Integer id) {
		userRepo.deleteById(id);
		return "Deleted SuccessFully";
	}

	@Override
	public User findById(Integer id) {
		User user = null;
		try {
			user = userRepo.findById(id).get();
			if(user.getLname() == null || user.getFname() == null) {
				throw new UserNameNotFoundException("Name is not valid");
			}
		} catch (NoSuchElementException e) {
           throw new UserNotFoundException("User not found with id :"+id);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

}
