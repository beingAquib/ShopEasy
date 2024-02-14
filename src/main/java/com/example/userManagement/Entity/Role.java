package com.example.userManagement.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer roleId;
	
	@Column(nullable = false ,length = 30, unique = true)
	String name;
	
	@Column(nullable = false ,length = 100)
	String Description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Role(String name, String description) {
		
		this.name = name;
		Description = description;
	}
	
	public Role() {
		
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role(Integer roleId) {
		super();
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleId, other.roleId);
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", Description=" + Description + "]";
	}

	

	
	
	

}
