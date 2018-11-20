package com.clinicpluz.service;

import java.util.List;

import com.clinicpluz.model.Article;
import com.clinicpluz.model.Customer;

public interface HomeManager {
	
	public boolean loginCheck(Customer customer);
	
	public List<Article> getArticles();
	
	public Customer getCustomerById(String custId);

}
