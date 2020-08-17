package com.fullcreative.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.fullcreative.demo.ListOfUsers;
import com.fullcreative.demo.User;

public class UserTest {
	
	@Test
	public void addUserTest() {

		List<String> expectedRes = new ArrayList<>();
		expectedRes.add("Mani");
		expectedRes.add("Mani@123");
		expectedRes.add("maran.123@gmail.com");
		expectedRes.add("01-05-1999");
		expectedRes.add("9514430000");

		User u1 = new User();
		u1.addUser("Mani", "Mani@123", "maran.123@gmail.com", "01-05-1999", "9514430000");
		// System.out.println(u1.get());
		assertEquals(expectedRes, u1.get());

	}

	
	
	@Test
	public void addUserTest1() {

		List<String> expectedRes = new ArrayList<>();
		expectedRes.add(null);
		expectedRes.add("Mani@123");
		expectedRes.add("maran.123@gmail.com");
		expectedRes.add(null);
		expectedRes.add(null);

		User u1 = new User();
		u1.addUser(null, "Mani@123", "maran.123@gmail.com", null,null);
		// System.out.println(u1.get());
		//System.out.println(expectedRes);
		assertEquals(expectedRes, u1.get());

	}
	
	@Test
	public void beforeAddEle() {
		
		List l1 = new ArrayList<>();

		User u1 = new User();
		assertEquals(l1, u1.get());

	}
	
	
}
