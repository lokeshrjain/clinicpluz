package com.clinicpluz.web;


import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.clinicpluz.model.Customer;
import com.clinicpluz.model.CustomerTO;
import com.clinicpluz.service.RegistrationManager;
 
@Controller
@RequestMapping("/registerpatient.htm")
public class RegisterationFormController {

	
	RegistrationManager registrationManager;
	
	private RegisterationValidator registrationValidator;
	 
	@Autowired
	public RegisterationFormController(RegisterationValidator registrationValidator){
		this.registrationValidator = registrationValidator;
	}
 
	@Autowired
	public void setRegistrationManager(RegistrationManager registrationManager) {
		this.registrationManager = registrationManager;
	}

	@RequestMapping(method=RequestMethod.GET)
	protected String ShowRegristraionForm(@ModelAttribute Customer customer) throws ServletException {
		return "registerpatient";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	protected String ProcessSubmit(@ModelAttribute("customer") Customer customer,
			BindingResult result, 
			SessionStatus status) throws ServletException {
		
		
		registrationValidator.validate(customer, result);
		
		if (result.hasErrors()) {
			//if validator failed
			return "registerpatient";
		}	else {
			//Clear Session
			status.setComplete();
			//Save customer
			registrationManager.saveOrUpdate(customer);
			return "redirect:/index.htm";
		}	

	}



 
	
}

