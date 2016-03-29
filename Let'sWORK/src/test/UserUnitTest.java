package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import business.Factory;
import persistence.Admin;
import persistence.Customer;
import persistence.Right;
import persistence.Seller;
import persistence.User;
import persistence.UserRole;

public class UserUnitTest {

	@Test
	public void test() {
		Factory factorio = new TestFactory();
		User user = factorio.createUser();
		user.setUsername("Azar");
		assertEquals("Getter and Setter of Username don't work", user.getUsername(), "Azar");
		
		user.setPassword("myPassword");
		assertEquals("Getter and Setter of Password don't work", user.getPassword(), "myPassword");
		
		List<UserRole> roles = user.getRoles();
		assertEquals(roles.size(), 0);
		assertEquals(user.getRole(Right.ADMIN), null);
		assertEquals(user.getRole(Right.CUSTOMER), null);
		assertEquals(user.getRole(Right.SELLER), null);
		
		Admin admin = factorio.createAdmin();
		user.addRole(admin);
		
		roles = user.getRoles();
		assertEquals(roles.size(), 1);
		assertEquals(user.getRole(Right.ADMIN), admin);
		assertEquals(user.getRole(Right.CUSTOMER), null);
		assertEquals(user.getRole(Right.SELLER), null);
		
		Admin admin2 = factorio.createAdmin();
		user.addRole(admin2);
		
		roles = user.getRoles();
		assertEquals(roles.size(), 1);
		assertEquals(user.getRole(Right.ADMIN), admin2);
		assertEquals(user.getRole(Right.CUSTOMER), null);
		assertEquals(user.getRole(Right.SELLER), null);
		
		Customer customer = factorio.createCustomer();
		user.addRole(customer);
		
		roles = user.getRoles();
		assertEquals(roles.size(), 2);
		assertEquals(user.getRole(Right.ADMIN), admin2);
		assertEquals(user.getRole(Right.CUSTOMER), customer);
		assertEquals(user.getRole(Right.SELLER), null);
		
		Seller seller = factorio.createSeller();
		user.addRole(seller);
		
		roles = user.getRoles();
		assertEquals(roles.size(), 3);
		assertEquals(user.getRole(Right.ADMIN), admin2);
		assertEquals(user.getRole(Right.CUSTOMER), customer);
		assertEquals(user.getRole(Right.SELLER), seller);
	}

}
