package com.example.userManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManagement.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
