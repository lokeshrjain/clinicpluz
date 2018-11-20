package com.clinicpluz.web;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.clinicpluz.model.Customer;

public class LoginValidator implements Validator {

	
	@Override
	public boolean supports(Class clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}


	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required","emailId is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passId", "passId.required","passId is required");
	}
}
