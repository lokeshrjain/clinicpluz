package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.clinicpluz.model.Article;
import com.clinicpluz.model.Customer;


public interface HomeDAO {
		
	public List<Article> getArticles();

	public Customer getCustomer();

	public boolean loginCheck(Customer customer);

	public void closeAll(Connection con, PreparedStatement pstmt);
	
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs);

}
