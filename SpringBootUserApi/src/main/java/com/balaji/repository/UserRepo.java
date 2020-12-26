package com.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
