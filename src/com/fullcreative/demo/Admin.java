package com.fullcreative.demo;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin {
	static Scanner sc;

	static void adminAuth() {
		// System.out.println("admin page");
		sc = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String adminUserName = sc.next();
		System.out.print("Enter Password: ");
		String adminPassword = sc.next();

		if (adminUserName.equals("admin") && adminPassword.equals("admin")) {
			// Users.viewPresentUsers();
			adminAccess();

		} else {
			System.out.println("Invalid Credentials");
		}
		sc.close();
	}

	static void adminAccess() {
		System.out.println("1. Create User");
		System.out.println("2. Update User");
		System.out.println("3. Delete User");
		System.out.println("4. View Users");

		System.out.println("Enter your Choice: ");
		int choice = sc.nextInt();

		if (choice == 1) {
			User u = new User();
			System.out.println("Please Enter the Following:");
			System.out.print("UserName: ");
			String userName = sc.next();
			System.out.print("Password: ");
			String userPassword = sc.next();

			// checking password using lookahead
			Pattern p1 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
			Matcher m2 = p1.matcher(userPassword);

			if (m2.find()) {
				System.out.print("Mail ID: ");
				String eMail = sc.next();

				// checking mail id
				Pattern p = Pattern
						.compile("[A-Za-z0-9]+[.]?[A-Za-z0-9]*@[A-Za-z]+\\.[A-Za-z]+(\\.[A-Za-z]*)?[A-Za-z]");

				Matcher m = p.matcher(eMail);

				if (m.find()) {

					eMail = m.group();

					System.out.print("DOB: ");
					String userDOB = sc.next();
					System.out.print("Mobile No[Num Only]: ");
					String userMobileNo = sc.next();

					u.addUser(userName, userPassword, eMail, userDOB, userMobileNo);

					// System.out.println("Added: "+u.getter());
					u.getter();
					// add the getter to ListOfUsers
					// u = null;
				}

				else {
					System.out.println("[Try Again] Incorrect eMail");
					adminAccess();
				}

			} else {

				System.out.println("[Try Again] > 8 char, 1 Upper & 1 Special Case & 1 Caps");
				adminAccess();

			}

		}

		else if (choice == 2) {
			System.out.println("Enter the UserID that you are going to modify:");
			int userID = sc.nextInt();

			ListOfUsers.userModify(userID);

		} else if (choice == 3) {

			System.out.println("Enter UserID No:");
			int a = sc.nextInt();
			ListOfUsers.userDelete(a);

		} else if (choice == 4) {
			// Listofusers
			ListOfUsers ls = new ListOfUsers();
			ls.viewPresentUsers();
			System.out.print("Enter [1] to continue [2] to logout admin or [0] to quit: ");
			int quitChoice = sc.nextInt();

			if (quitChoice == 1) {
				adminAccess();
			} else if (quitChoice == 2) {
				LoginMenu.MainMenu();
			}

			else if (quitChoice == 0) {
				System.out.println("Shutting Down..");
			}

		} else {
			System.out.println("Invalid Choice");
		}
	}

}
