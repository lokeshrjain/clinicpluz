package com.clinicpluz.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	String custId;
	String firstName;
	String lastName;
	String address;
	String postcode;
	String emailId;
	String passId;
	String passIdConfirm;
	String gender;
	String note;
	Date regDate;




	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
	    DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
	    try {
			this.regDate = df.parse(regDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassId() {
		return passId;
	}
	public void setPassId(String passId) {
		this.passId = passId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getPassIdConfirm() {
		return passIdConfirm;
	}

	public void setPassIdConfirm(String passIdConfirm) {
		this.passIdConfirm = passIdConfirm;
	}

}
