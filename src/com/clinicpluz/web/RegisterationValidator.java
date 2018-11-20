package com.clinicpluz.web;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.clinicpluz.model.Customer;

public class RegisterationValidator implements Validator {

	
	@Override
	public boolean supports(Class clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}


	public void validate(Object obj, Errors errors) {
		Customer cust = (Customer) obj; 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required","First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required","Last Name is Required");
		ValidationUtils.rejectIfEmpty(errors, "address", "address.required","Address is requried");
		ValidationUtils.rejectIfEmpty(errors, "postcode", "postcode.required","Postcode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required","EmailId is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passId", "passId.required","Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passIdConfirm", "passIdConfirm.required","Confirm Password is required");
		
		if (!cust.getPassId().equals(cust.getPassIdConfirm())) {
			errors.rejectValue("passIdConfirm", "passIdConfirm.mismatch","Confirm password doesn't match with password");
		} 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required","Gender is required");
		
	}
}
