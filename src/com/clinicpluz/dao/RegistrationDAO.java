package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.clinicpluz.model.Customer;


public interface RegistrationDAO {
		
	public int insert(Customer customer);

	public int update(Customer customer);
	
	public int delete(String custId);

	public Customer getCustomerById(String custId);

	public List<Customer> getAllCustomers();

	public void closeAll(Connection con, PreparedStatement pstmt);
	
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs);

}
