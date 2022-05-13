package com.UserManagementSystem.UserManagementSystemSpringBoot.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.UserAddress;

public interface UserAddressDao extends JpaRepository<UserAddress, Integer> {}

