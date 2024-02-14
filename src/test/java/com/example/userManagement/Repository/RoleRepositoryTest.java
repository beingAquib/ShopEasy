package com.example.userManagement.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.userManagement.Entity.Role;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RoleRepositoryTest {
	
	@Autowired
	RoleRepository rr;

	@Test
	void addAdminRole() {
		Role admin=new Role("Admin","This is Admin Role and super user");
		
		Role r=rr.save(admin);
		
		assertThat((r.getRoleId()>0));
				
		
	}
	
	@Test
	void addOtherRoles() {
		Role salesPerson=new Role("Sales Person","This is Sales Person. ");
		
		Role roleEditor=new Role("Role Editor","This is Role Editor. ");
		
		Role roleShipper=new Role("Role Shipper","This is Role Shipper. ");
		
		Role roleAssistant=new Role("Role Assistant","This is Role Assistant. ");
		
		rr.saveAll(List.of(salesPerson,roleEditor,roleShipper,roleAssistant));
		
		assertTrue(true);
				
		
	}

}
