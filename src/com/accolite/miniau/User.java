package com.accolite.miniau;

import com.accolite.miniau.Constants.callType;

public class User implements UserFunctionality{

	private String name;
	private Phone phone;
		
	public User(String name) {
		super();
		this.name = name;
		this.phone = new Phone();
	}
	
	@Override
	public void makeCall() {
		
		String number;
		System.out.print("Enter phone number to dial:");
		number = Main.sc.next();
		phone.call(number);
	}
	@Override
	public void endCall() {
		
		phone.terminateOnGoingCall();
		
	}
	@Override
	public void getAllContacts() {
		
		phone.getAllContacts();
		
	}
	@Override
	public void searchContactByName() {
		
		System.out.print("Enter name to search in contacts: ");
		String name = Main.sc.next();
		phone.getContactDetails(name);
	}
	@Override
	public void getCallHistory() {
		
		phone.getCallHistory();
		
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		User u = (User) obj;
		if(this.name.equals(u.getName()))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void insertContact() {

		System.out.println("Enter name: ");
		String name = Main.sc.next();
		System.out.println("Enter number: ");
		String number = Main.sc.next();
		phone.addContact(name, number);
		
	}

	@Override
	public void attendCall() {

		System.out.println("Enter the number to attend the call: ");
		String number = Main.sc.next();
		phone.recieveCall(number);
	}

	@Override
	public void getCallHistoryByType() {
		
		System.out.println("Filter Call History by\n1. Incoming\n2. OutGoing\nEnter your choice");
		int ch = Main.sc.nextInt();
		switch(ch)
		{
		case 1:
			phone.getCallHistoryByType(callType.INCOMING);
			break;
		case 2:
			phone.getCallHistoryByType(callType.OUTGOING);
			break;
		default:
			System.err.println("Invalid option");
		}
		
	}

	
	
}
