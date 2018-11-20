package com.clinicpluz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.model.Customer;

public interface RegistrationManager {
	
	public int saveOrUpdate(Customer customer);
	
	public int delete(String custId);
//don't need it here...as it is service class here we should show showCustomers etc	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(String custId);

}
