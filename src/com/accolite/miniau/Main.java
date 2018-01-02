package com.accolite.miniau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);

		List<User> users = new ArrayList<>();
		
		users.add(new User("tarun"));
		users.add(new User("piyush"));
		users.add(new User("mohan"));
		users.add(new User("sathya"));
		users.add(new User("ajith"));
		users.add(new User("praveen"));
		users.add(new User("vijay"));
		users.add(new User("andrew"));
		users.add(new User("sudhan"));
		users.add(new User("saurabh"));
		
		int ch=-1;
		do
		{
			System.out.println("\n\n**-- MENU --**");
			System.out.println("0. VIEW USERS");
			System.out.println("1. ADD USER");
			System.out.println("2. MAKE CALL");
			System.out.println("3. TERMINATE CALL");
			System.out.println("4. GET CONTACTS");
			System.out.println("5. SEARCH SINGLE CONTACT");
			System.out.println("6. ADD CONTACT TO PHONE");
			System.out.println("7. GET CALL HISTORY");
			System.out.println("8. RECIEVE CALL FROM A NUMBER");
			System.out.println("9. FILTER CALL HISTORY");
			System.out.print("\nEnter your choice:");
			ch = sc.nextInt();
			switch(ch)
			{
			case 0:
				System.out.println(users.toString());
				break;
			case 1:
				System.out.print("Enter Name: ");
				users.add(new User(sc.next()));
				break;
			case 2:
				System.out.print("Enter User Name from whose phone you want to make call:");
				String name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).makeCall();
				}
				else
					System.err.println("User not available");
				break;
			case 3:
				System.out.print("Enter User Name from whose phone you want to terminate call:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).endCall();
				}
				else
					System.err.println("User not available");
				break;
			case 4:
				System.out.print("Enter User Name from whose phone you want to display the contacts:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).getAllContacts();
				}
				else
					System.err.println("User not available");
				break;
			case 5:
				System.out.print("Enter User Name from whose phone you want to search contact:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).searchContactByName();
				}
				else
					System.err.println("User not available");
				break;
			case 6:
				System.out.print("Enter User Name for whose phone you want to add a contact:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).insertContact();
				}
				else
					System.err.println("User not available");
				
				break;
			case 7:
				System.out.print("Enter User Name for whose phone you want to display call history:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).getCallHistory();
				}
				else
					System.err.println("User not available");
				
				break;
			case 8:
				System.out.print("Enter User Name for whose phone you want recieve call	:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).attendCall();
				}
				else
					System.err.println("User not available");
				
				break;
			case 9:
				System.out.print("Enter User Name for whose phone you want filter call history:");
				name = sc.next();
				if(users.contains(new User(name)))
				{
					int index = users.indexOf(new User(name));
					users.get(index).getCallHistoryByType();
				}
				else
					System.err.println("User not available");
				
				break;
			default:
				System.exit(0);
			}
		}while(ch>=0 && ch<10);
	}

}
