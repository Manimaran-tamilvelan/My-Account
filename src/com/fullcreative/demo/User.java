package com.fullcreative.demo;

import java.util.*;

public class User {

	// Map<Integer, List> m = new HashMap<Integer, List>();

	// static int userID = 101;
	List l = new ArrayList<>();

	private static String actualusersName;
	private static String enteredUserName;
	private static String actualUsersPassword;
	private static String enteredPassword;

	public static void userAuth() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Username:");
		enteredUserName = sc.next();
		System.out.print("Enter your Password: ");
		enteredPassword = sc.next();

		List myLocalList = ListOfUsers.returnMyList();

		// System.out.println(myLocalList.size());
		// System.out.println(myLocalList);
		int visit = 0;

		for (int i = 0; i < myLocalList.size(); i++) {

			for (int j = 0; j < 1; j++) {
				// System.out.print(" " +" ");
				actualusersName = (String) ((List) myLocalList.get(i)).get(j);
				actualUsersPassword = (String) ((List) myLocalList.get(i)).get(j + 1);

				if (actualusersName.equals(enteredUserName) && actualUsersPassword.equals(enteredPassword)) {

					visit++;
					// System.out.println("1. UserName, 2. Password, 3. MailID, 4. DOB, 5. Mobile
					// No");
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(
							"|        User Name        |        Password         |             mailID            |           DOB           |        Mobile No        |");
					// int size = 0;
					// System.out.print("|");
					// System.out.println(myLocalList.get(i));

					Map<Integer, List> localMap = new HashMap<>();
					localMap.put(null, (List) myLocalList.get(i));

					// System.out.println(localMap);

					for (Map.Entry<Integer, List> entry : localMap.entrySet()) {
						// System.out.println(entry.getKey()+""+entry.getValue());

						System.out.print("|");

						for (int m = 0; m < entry.getValue().size(); m++) {

							String s = (String) entry.getValue().get(m);
							// System.out.println(s);
							int forAll = 24;

							if (m == 2) {
								forAll = 30;
							}

							int size = s.length();
							int overAll = forAll - size;
							if ((size % 2) != 0) {
								System.out.print(" ");
							}
							for (int k = 0; k < overAll / 2; k++) {

								System.out.print(" ");
							}
							System.out.print(entry.getValue().get(m));
							for (int k = 0; k <= overAll / 2; k++) {
								System.out.print(" ");
							}

							System.out.print("|");

						}

						System.out.println();

					}

					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");
					System.out.print("Enter [1] togo userlogin page [2] for main login or [0] to quit:");

					int loop = sc.nextInt();

					if (loop == 1) {
						// go to if loop in admin auth
						User.userAuth();

					}
					if (loop == 2) {
						LoginMenu.MainMenu();
					}

					else if (loop == 0) {
						System.out.println("Shutting Down..");

					}

				}

			}

		}

		if (visit == 0) {
			System.out.print("[Invalid]");

			System.out.print("Enter [1] togo userlogin page again [2] for main login or [0] to quit:");

			int loop = sc.nextInt();

			if (loop == 1) {
				// go to if loop in admin auth
				User.userAuth();

			}
			if (loop == 2) {
				LoginMenu.MainMenu();
			}

			else if (loop == 0) {
				System.out.println("Shutting Down..");

			}

		}
		sc.close();

	}

	@SuppressWarnings("unchecked")
	public void addUser(String userName, String userPassword, String eMail, String userDOB, String userMobileNo) {
		// setter
		// l.clear();
		l.add(userName);
		l.add(userPassword);
		l.add(eMail);
		l.add(userDOB);
		l.add(userMobileNo);

	}

	public void getter() {
		// m.put(userID, l);
		// return m;
		ListOfUsers.finalUsers(l);
		// return l;
		// lu = null;
	}

	// method used To test the current list
	public List get() {
		return l;
	}

}
