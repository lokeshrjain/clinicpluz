package com.clinicpluz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.dao.HomeDAO;
import com.clinicpluz.model.Article;
import com.clinicpluz.model.Customer;

public class SimpleHomeManager implements HomeManager {
	private HomeDAO homeDAO;
	
	@Autowired
	public void setHomeDAO(HomeDAO homeDAO) {
		this.homeDAO = homeDAO;
	}

	@Override
	public boolean loginCheck(Customer customer) {
		return homeDAO.loginCheck(customer);
	}

	@Override
	public List<Article> getArticles() {
		return homeDAO.getArticles();
	}

	@Override
	public Customer getCustomerById(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
