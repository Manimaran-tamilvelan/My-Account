package com.fullcreative.demo.test;

import org.junit.*;

import static org.junit.Assert.assertNotNull;

import java.util.*;
import com.fullcreative.demo.ListOfUsers;

public class ListOfUsersTest {

	static List<List> expectedList1;
	static List actualList;

	@Before
	public void beforeTest() {
		actualList = ListOfUsers.returnMyList();
	}

	@Test
	public void returnMyListDemoUsers() {

		List<List> expectedList = new ArrayList<>();

		List<String> user1 = new ArrayList<>();
		user1.add("Mani");
		user1.add("Mani@123");
		user1.add("maran.123@gmail.com");
		user1.add("01-05-1999");
		user1.add("9514430000");

		List<String> user2 = new ArrayList<>();
		user2.add("Demo");
		user2.add("Demo@123");
		user2.add("demo@gmail.com");
		user2.add("00-00-2020");
		user2.add("9990009900");

		expectedList.add(user1);
		expectedList.add(user2);

		// checking currently added user
		Assert.assertEquals(expectedList, actualList);
	}
	
	@Test
	public void ListOfUsers() {
		//users with DemoUsers
		
		expectedList1 = new ArrayList<>();
		List<String> user1 = new ArrayList<>();
		user1.add("Mani");
		user1.add("Mani@123");
		user1.add("maran.123@gmail.com");
		user1.add("01-05-1999");
		user1.add("9514430000");

		List<String> user2 = new ArrayList<>();
		user2.add("Demo");
		user2.add("Demo@123");
		user2.add("demo@gmail.com");
		user2.add("00-00-2020");
		user2.add("9990009900");

		List<String> user3 = new ArrayList<>();
		user3.add("Maran");
		user3.add("Mani@123");
		user3.add("maran.123@gmail.com");
		user3.add("01-05-1999");
		user3.add("9514430000");

		expectedList1.add(user1);
		expectedList1.add(user2);
		expectedList1.add(user3);

		ListOfUsers.demoUsers();
		List l1 = List.of("Maran", "Mani@123", "maran.123@gmail.com", "01-05-1999", "9514430000");
		ListOfUsers.setTest(l1);
		// u1.getter();

		// System.out.println(expectedList);
		// System.out.println(ListOfUsers.returnMyList());
		Assert.assertEquals(expectedList1, ListOfUsers.returnMyList());

	}
	
	@Test
	public void returnMyListNotNull() {

		ListOfUsers.demoUsers();
		List l2 = List.of("Maran", "Maran@123", "maran.123@gmail.com", "01-05-1999", "9514430010");
		ListOfUsers.setTest(l2);
	
		assertNotNull(ListOfUsers.returnMyList());


	}	
	
	

}
