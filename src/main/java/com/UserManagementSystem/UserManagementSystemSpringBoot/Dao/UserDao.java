package com.UserManagementSystem.UserManagementSystemSpringBoot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.User;


public interface UserDao extends JpaRepository<User,Integer>{
	
	@Query("from User where email=?1")
	public User userExist(String mail);
	
	@Query("from User where role=?1")
	public List<User> getUserList(String role);
	
	@Query("from User where email=?1")
	public User validUser(String email);
	
	
}
