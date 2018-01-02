package com.accolite.miniau;

import java.util.Date;
import com.accolite.miniau.Constants.callType;


public class Call {

	callType type;
	public callType getType() {
		return type;
	}

	public void setType(callType type) {
		this.type = type;
	}

	String number;
	Date date;
	private String callDuration;
	
	
	public Call(String number,callType type) {
		super();
		this.number = number;
		this.date = new Date();
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCallDuration() {
		return callDuration;
	}

	@Override
	public String toString() {
		return "Call [type=" + type + ", number=" + number + ", date=" + date + ", callDuration=" + callDuration + "]";
	}

	public void setCallDuration(String callDuration1) {
		
		this.callDuration = callDuration1;
		
	}
	
}
