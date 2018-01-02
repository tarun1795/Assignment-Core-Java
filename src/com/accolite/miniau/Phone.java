package com.accolite.miniau;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.accolite.miniau.Constants.callStatus;
import com.accolite.miniau.Constants.callType;


public class Phone implements PhoneFunctionality{

	Hashtable<String,String> contacts;
	List<Call> callHistory;
	callStatus status;
	Call onGoingCall;
	
	public Phone()
	{
		contacts = new Hashtable<>();
		callHistory = new LinkedList<>();
		status = callStatus.IDLE;
		onGoingCall = null;
	}
	
	@Override
	public void call(String number) {
		
		if(status == callStatus.ONCALL)
		{
			System.err.println("Already on a call.\nCannot Place another Call!");
			return;
		}
		if(!Pattern.matches("\\d{10}", number))
		{
			System.err.println("Invalid Number");
			return;
		}
		status = callStatus.ONCALL;
		onGoingCall = new Call(number,callType.OUTGOING);
	}

	@Override
	public void recieveCall(String number) {
		if(status == callStatus.ONCALL)
		{
			System.err.println("Already on a call.\nCannot Recieve another call");
			return;
		}
		if(!Pattern.matches("\\d{10}", number))
		{
			System.err.println("Invalid Number");
			return;
		}
		status=callStatus.ONCALL;
		onGoingCall = new Call(number, callType.INCOMING);
	}
	@Override
	public void terminateOnGoingCall() {
		
		if(status == callStatus.IDLE)
		{
			System.err.println("No call to terminate");
			return;
		}
		Date startDate = onGoingCall.getDate();
		Long callDuration = new Date().getTime() - startDate.getTime();
		long second = TimeUnit.MILLISECONDS.toSeconds(callDuration);
		long minute = TimeUnit.MILLISECONDS.toMinutes(callDuration);
		long hour = TimeUnit.MILLISECONDS.toHours(callDuration);
		System.out.println("Call Ended\nCall Duration "+String.format("%02d:%02d:%02d", hour, minute, second));
		onGoingCall.setCallDuration(String.format("%02d:%02d:%02d", hour, minute, second));
		status = callStatus.IDLE;
		callHistory.add(onGoingCall);
		onGoingCall = null;
		
	}
	
	@Override
	public void getCallHistory() {
		
		System.out.println("\n\n**--CALL HISTORY--**\n");
		for(int i=callHistory.size()-1;i>=0;i--)
			System.out.println(callHistory.get(i).toString());
	}
	
	@Override
	public void getCallHistoryByType(callType type) {
		
		System.out.println("\n\n**--CALL HISTORY [ "+type+" ]--**\n");
		for(int i=callHistory.size()-1;i>=0;i--)
		{
			if(callHistory.get(i).getType() == type)
				System.out.println(callHistory.get(i).toString());
		}
	}

	@Override
	public void addContact(String name,String number) {
		
		if(contacts.get(name) != null)
		{
			System.err.println("Contact already exist with name "+name);
			return;
		}
		if(!Pattern.matches("\\d{10}", number))
		{
			System.err.println("Invalid Number");
			return;
		}
		contacts.put(name, number);
	}

	@Override
	public void getAllContacts() {
		
		System.out.println("\n\n**--CONTACT LIST --**\n");
		Enumeration<String> keys = contacts.keys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			System.out.println(key+"\t\t:"+contacts.get(key));
		}
		
	}

	@Override
	public void getContactDetails(String name) {
		
		String number = contacts.get(name);
		if(number == null)
			System.err.println("Contact doesn't exsist");
		else
			System.out.println(name+" \t: "+number);
		
	}
}
