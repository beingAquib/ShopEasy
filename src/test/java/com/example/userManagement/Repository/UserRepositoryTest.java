package com.example.userManagement.Repository;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.userManagement.Entity.Role;
import com.example.userManagement.Entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTest {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	TestEntityManager em;

	@Test
	void testSingleRoleAssignment() {
		
		Role role=em.find(Role.class, 1);
		User user=new User("abc@xyz.com","raaj","raaz");
		user.addRole(role);
		ur.save(user);
		Assertions.assertThat(user.getUserId()>0);
		
	}
	@Test
	void testMultipleRoleAssignment() {
		
		//Role role=em.find(Role.class, 1);
		User user=new User("def@xyz.com","un","ps");
		Role role1=new Role(2);
		Role role2=new Role(3);
		user.addRole(role1);
		user.addRole(role2);
		ur.save(user);
		Assertions.assertThat(user.getUserId()>0);
		
	}
	@Test
	void testListAllUSers() {
		List<User> usersList=ur.findAll();
		usersList.forEach(n->System.out.println(n));
		
	}
	@Test
	void testUpdateUser() {
	User user=	ur.findById(1).get();
	user.setEnable(true);
	user.setEmail("updateTest@xyz.com");
	ur.save(user);
	
	}
	@Test
	void testUpdateRole() {
	User user=	ur.findById(1).get();
	Role roleRemove=new Role(1);
	Role roleAdd=new Role(5);
	
	user.getRoles().remove(roleRemove);
	user.addRole(roleAdd);
	
	ur.save(user);
	
	}
	@Test
	void testDeleteUser() {
		User userToDelete=em.find(User.class, 1);
	ur.delete(userToDelete);
	
	
	
	}

}
