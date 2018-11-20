package com.clinicpluz.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class Appointment {

	private String apptId;
	private String custId;
	private String firstName;
	private String lastName;
	private String address;
	private String postcode;
	private String emailId;
	private String gender;
	private String AppointmentNote;
	private String IsNewAppt;
	private String AdditionalNote;
	private String phoneNo;
	private String mobileNo;
	private Date requestedDt;
	private Time requestedTime;
	private Date appointmentDt;
	private Date ModifiedDt;

	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getRequestedDt() {
		return requestedDt;
	}
	public void setRequestedDt(Date requestedDt) throws ParseException {
		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		this.requestedDt = requestedDt;
		this.requestedTime = new java.sql.Time(requestedDt.getTime());
	}
	
	public Date getAppointmentDt() {
		return appointmentDt;
	}
	public void setAppointmentDt(String appointmentDt) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.appointmentDt = df.parse(appointmentDt);
	}
	public Date getModifiedDt() {
		return ModifiedDt;
	}
	public void setModifiedDt(String modifiedDt) throws ParseException  {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		ModifiedDt = df.parse(modifiedDt);
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAppointmentNote() {
		return AppointmentNote;
	}
	public void setAppointmentNote(String appointmentNote) {
		AppointmentNote = appointmentNote;
	}
	public String getIsNewAppt() {
		return IsNewAppt;
	}
	public void setIsNewAppt(String isNewAppt) {
		IsNewAppt = isNewAppt;
	}
	public String getAdditionalNote() {
		return AdditionalNote;
	}
	public void setAdditionalNote(String additionalNote) {
		AdditionalNote = additionalNote;
	}
	public String getApptId() {
		return apptId;
	}
	public void setApptId(String apptId) {
		this.apptId = apptId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public Time getRequestedTime() {
		return requestedTime;
	}
	public void setRequestedTime(Date requestedDt) {
		this.requestedTime = new java.sql.Time(requestedDt.getTime());
	}
	
	public void load(Appointment appointment) {
		this.apptId = appointment.getApptId();
		this.custId = appointment.getCustId();
		this.firstName= appointment.getFirstName();
		this.lastName=appointment.getLastName();
		this.address =appointment.getAddress();
		this.postcode =appointment.getPostcode();
		this.emailId =appointment.getEmailId();
		this.gender =appointment.getGender();
		this.AppointmentNote =appointment.getAppointmentNote();
		this.IsNewAppt =appointment.getIsNewAppt();
		this.AdditionalNote =appointment.getAdditionalNote();
		this.phoneNo =appointment.getPhoneNo();
		this.mobileNo =appointment.getMobileNo();
		this.requestedDt =appointment.getRequestedDt();
		this.requestedTime =appointment.getRequestedTime();
		this.appointmentDt =appointment.getAppointmentDt();
		this.ModifiedDt =appointment.getModifiedDt();

	}  
}
