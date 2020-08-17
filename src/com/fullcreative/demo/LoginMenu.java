package com.fullcreative.demo;

import java.util.*;

public class LoginMenu {

	public static void main(String[] args) {

		MainMenu();

	}

	public static void MainMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Admin Login");
		System.out.println("2. User Login");
		System.out.print("Enter Your Option: ");

		int a = sc.nextInt();
		int count = 0;

		ll: while (a >= 0) {
			if (count >= 1) {
				System.out.print("Enter valid Input or press [0] to break: ");

				a = sc.nextInt();
				if (a == 0) {
					break ll;
				}
			}
			if (a == 1) {
				// System.out.println("1");
				// implementation of admin login
				Admin.adminAuth();

				break;
			} else if (a == 2) {
				// System.out.println("2");
				// implementation of user login
				User.userAuth();
				break;
			} else {
				System.out.print("[Invalid]");
				count++;
				continue ll;

			}
		}

	}
}