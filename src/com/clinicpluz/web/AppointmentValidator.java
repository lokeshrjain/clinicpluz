package com.clinicpluz.web;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.clinicpluz.model.Appointment;

public class AppointmentValidator implements Validator {

	
	@Override
	public boolean supports(Class clazz) {
		return Appointment.class.isAssignableFrom(clazz);
	}


	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required","First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required","Last Name is Required");
		ValidationUtils.rejectIfEmpty(errors, "address", "address.required","Address is requried");
		ValidationUtils.rejectIfEmpty(errors, "postcode", "postcode.required","Postcode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required","Gender is required");
	}
}
