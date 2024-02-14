package com.example.userManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
