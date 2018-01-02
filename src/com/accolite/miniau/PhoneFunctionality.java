package com.accolite.miniau;

import com.accolite.miniau.Constants.callType;

public interface PhoneFunctionality {

	void call(String number);
	void terminateOnGoingCall();
	void getCallHistory();
	void getCallHistoryByType(callType type);
	void addContact(String name,String number);
	void getAllContacts();
	void getContactDetails(String name);
	void recieveCall(String number);
}
