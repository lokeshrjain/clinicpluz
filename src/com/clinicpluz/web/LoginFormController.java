package com.clinicpluz.web;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.clinicpluz.model.Article;
import com.clinicpluz.model.Customer;
import com.clinicpluz.model.CustomerTO;
import com.clinicpluz.service.HomeManager;
 
@Controller
@RequestMapping("login.htm")
public class LoginFormController  {
	private HomeManager homeManager;
	private CustomerTO customerTO;

	public CustomerTO getCustomerTO() {
		return customerTO;
	}
	
	@Autowired
	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}
	
	
	@Autowired
	public void setHomeManager(HomeManager homeManager) {
		this.homeManager = homeManager;
	}
	
	@RequestMapping(method =RequestMethod.GET)
	protected ModelAndView ShowLoginForm(@ModelAttribute("customer") Customer customer)
    {
			return new ModelAndView("login","model",customer);
    }

	@RequestMapping(method=RequestMethod.POST)
	protected ModelAndView Login(@ModelAttribute("customer") Customer customer,  BindingResult result, SessionStatus status,HttpServletRequest request,HttpSession session)
    {
		
		ModelAndView mv;

		if (homeManager.loginCheck(customer)) {
			
			List<Article> articleList = homeManager.getArticles();
			Map<String,Object> myModel = new HashMap<String,Object>();
			myModel.put("customer",customer);
			mapCutomerTO(customer);
			myModel.put("customerTO",getCustomerTO());
			myModel.put("articleList",articleList);		
			request.getSession().setAttribute("articleList",articleList);			
			request.getSession().setAttribute("customerTO",getCustomerTO());			
	    	 
	    	 
	    	  System.out.println("*** Session data ***");
	    	  Enumeration<String> e = session.getAttributeNames();
	    	  while (e.hasMoreElements()){
	    	    String s = e.nextElement();
	    	    System.out.println(s);
	    	    System.out.println("**" + session.getAttribute(s));
	    	  }
	    	 
	    
			
			
			
			mv= new ModelAndView("index","model",myModel);
			
		} else {
			mv=new ModelAndView("login","model",null);
			mv.addObject("error", "Invalid Login and password");
			mv.addObject("customer",customer); 
		}
		
		return mv;
     
    }

	public void mapCutomerTO(Customer cust){
		getCustomerTO().setAddress(cust.getAddress());
		getCustomerTO().setCustId(cust.getCustId());
		getCustomerTO().setEmailId(cust.getEmailId());
		getCustomerTO().setFirstName(cust.getFirstName());
		getCustomerTO().setLastName(cust.getLastName());
		getCustomerTO().setGender(cust.getGender());
		getCustomerTO().setPostcode(cust.getPostcode());
	}

	
}

