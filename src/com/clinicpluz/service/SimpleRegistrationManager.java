package com.clinicpluz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.dao.RegistrationDAO;
import com.clinicpluz.model.Customer;

public class SimpleRegistrationManager implements RegistrationManager {
	
	
	private RegistrationDAO registrationDAO; 
	
	@Autowired
	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}
	
	@Override
	public int saveOrUpdate(Customer customer) {
		int result = 0;
	
		if (customer.getCustId() ==null || customer.getCustId() =="") {
			customer.setCustId("uniquekey");
			result =registrationDAO.insert(customer);
		} else {
			result =registrationDAO.update(customer);
		}
		
		return result;
	}

	@Override
	public int delete(String custId) {
		return registrationDAO.delete(custId);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = null;
		
		customerList = registrationDAO.getAllCustomers();
		//check for the error
		return customerList;
	}

	@Override
	public Customer getCustomerById(String custId) {
		return registrationDAO.getCustomerById(custId);
	}
	
}
