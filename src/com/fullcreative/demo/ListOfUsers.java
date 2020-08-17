package com.fullcreative.demo;

import java.util.*;

public class ListOfUsers {

	private static Map<Integer, List<String>> m = new TreeMap<>();

	static int userID = 101;

	static int count = 0;

	public static void demoUsers() {
		if (count == 0) {
			List<String> userOne = new ArrayList<>();
			List<String> userTwo = new ArrayList<>();

			userOne.add("Mani");
			userOne.add("Mani@123");
			userOne.add("maran.123@gmail.com");
			userOne.add("01-05-1999");
			userOne.add("9514430000");
			// User u1 = new User();

			// System.out.println(u1.getter());
			m.put(userID, userOne);
			userID++;

			// User u2 = new User();
			// User.addUser("Demo", "demo@gmail.com", "Demo@123", "00-00-2020", "");
			userTwo.add("Demo");
			userTwo.add("Demo@123");
			userTwo.add("demo@gmail.com");
			userTwo.add("00-00-2020");
			userTwo.add("9990009900");
			// System.out.println(u2.getter());
			m.put(userID, userTwo);
			userID++;
			count++;
		}

	}

	public void viewPresentUsers() {
		demoUsers();
		// System.out.println(m);
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"| User ID |      UserName      |      Password      |            mailID            |         DOB        |      Mobile No     |");
		// System.out.println("| UserID - UserName - Password - UserMailID - userDOB -
		// Mobile No ");
		for (Map.Entry<Integer, List<String>> entry : m.entrySet()) {

			System.out.print("|   " + entry.getKey() + "   |");

			for (int m = 0; m < entry.getValue().size(); m++) {
				String s0 = entry.getValue().get(m);
				int forAll = 20;

				if (m == 2) {
					forAll = 30;
				}

				int a = s0.length();

				int spaceCount = forAll - a;
				if (a % 2 != 0) {
					System.out.print(" ");
				}
				for (int i = 1; i <= spaceCount / 2; i++) {

					System.out.print(" ");
				}
				System.out.print(entry.getValue().get(m));
				for (int i = 1; i <= spaceCount / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("|");
			}

			System.out.println();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");
	}

	// using for user authentication to check user or not
	public static List returnMyList() {

		List forUserAuth = new ArrayList();
		demoUsers();

		for (Map.Entry<Integer, List<String>> entry : m.entrySet()) {
			forUserAuth.add(entry.getValue());
		}

		return forUserAuth;
	}

	// created for userTest
	public static Map setTest(List l) {
		m.put(userID, l);
		return m;
	}

	public static void finalUsers(List<String> newList) {

		demoUsers();

		m.put(userID, newList);
		userID++;
		// System.out.println(m);
		System.out.println("List of users: ");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"| User ID |      UserName      |      Password      |            mailID            |         DOB        |      Mobile No     |");
		for (Map.Entry<Integer, List<String>> entry : m.entrySet()) {
			System.out.print("|   " + entry.getKey() + "   |");

			for (int m = 0; m < entry.getValue().size(); m++) {
				String s0 = entry.getValue().get(m);
				int forAll = 20;
				int a = s0.length();

				if (m == 2) {
					forAll = 30;
				}
				int spaceCount = forAll - a;
				if (a % 2 != 0) {
					System.out.print(" ");
				}
				for (int i = 1; i <= spaceCount / 2; i++) {

					System.out.print(" ");
				}
				System.out.print(entry.getValue().get(m));
				for (int i = 1; i <= spaceCount / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("|");
			}

			System.out.println();

		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");
		// System.out.println(m);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter [1] to continue [2] to logout as admin or [0] to quit:");

		int loop = sc.nextInt();

		if (loop == 1) {
			// go to if loop in admin auth
			Admin.adminAccess();
		} else if (loop == 2) {
			LoginMenu.MainMenu();
		}

		else if (loop == 0) {
			System.out.println("Shutting Down..");

		}
		sc.close();
	}

	public static void userDelete(int a) {
		demoUsers();
		if (!m.containsKey(a)) {
			System.out.println("Invalid Key");
		}
		ll: if (m.containsKey(a)) {
			// if (a == 101 || a == 102) {
			// System.out.println("Cann't Delete demo users");
			// break ll;
			// }
			m.remove(a);
			System.out.println("Deleted!");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter [1] to continue or [0] to quit:");

		int loop = sc.nextInt();

		if (loop == 1) {
			// go to if loop in admin auth
			Admin.adminAccess();
		} else if (loop == 0) {
			System.out.println("Shutting Down..");

		}
		sc.close();
	}

	public static void userModify(int userId) {

		demoUsers();
		Scanner sc = new Scanner(System.in);

		List<String> newValues = new ArrayList<>();

		if (!m.containsKey(userId)) {
			System.out.println("Invalid Key");
		}

		l2: if (m.containsKey(userId)) {

			// if (userId == 101 || userId == 102) {
			// System.out.println("Cann't Modify in demo users");
			// break l2;
			// }

			System.out.println("[To Modify]Please Enter the Following:");
			System.out.print("UserName: ");
			String userName = sc.next();
			System.out.print("Password: ");
			String userPassword = sc.next();
			System.out.print("Mail ID: ");
			String eMail = sc.next();
			System.out.print("DOB: ");
			String userDOB = sc.next();
			System.out.print("Mobile No: ");
			String userMobileNo = sc.next();

			newValues.add(userName);
			newValues.add(userPassword);
			newValues.add(eMail);
			newValues.add(userDOB);
			newValues.add(userMobileNo);

			m.put(userId, newValues);

			System.out.println("Modification Successful");
		}

		System.out.print("Enter [1] to continue [2] to logout as admin or [0] to quit:");

		int loop = sc.nextInt();

		if (loop == 1) {
			// go to if loop in admin auth
			Admin.adminAccess();
		} else if (loop == 2) {
			LoginMenu.MainMenu();
		}

		else if (loop == 0) {
			System.out.println("Shutting Down..");

		}
		sc.close();

	}

}
