package com.UserManagementSystem.UserManagementSystemSpringBoot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.User;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.UserAddress;

public interface UserDao  extends JpaRepository<User,Integer>{
	
	@Query("from User where email=?1")
	public User userExist(String mail);
	
	@Query("from User where role='user'")
	public List<User> getUserList();
	
	@Query("from User where email=?1")
	public User validUser(String email);
	
	@Query("from UserAddress where user_userID=?1")
	public List<UserAddress> getUserAddress(int userid);
}
