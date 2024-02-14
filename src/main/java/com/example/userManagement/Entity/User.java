package com.example.userManagement.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@Column(nullable = false,unique=true,length = 40)
	String email;
	
	@Column(nullable = false ,length = 40)
	String password;
	
	@Column(nullable = false ,length = 40)
	String firstName;
	
	@Column( length = 40)
	String lastName;
	
	@Column( length = 40)
	String photos;
	
	@Column
	Boolean enable;
	
	@ManyToMany
	@JoinTable(
			  name = "users_roles", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Role> roles=new HashSet<>();
	
	public void addRole(Role r) {
		this.roles.add(r);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User(String email, String password, String firstName) {
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
	}
	
public User() {
		
	}

@Override
public String toString() {
	return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", photos=" + photos + ", enable=" + enable + ", roles=" + roles + "]";
}
	
	
	
	
	
}
