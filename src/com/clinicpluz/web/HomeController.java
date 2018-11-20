package com.clinicpluz.web;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clinicpluz.service.HomeManager;

@Controller
@RequestMapping("/index.htm")
public class HomeController {
    private static Logger slf4jLogger = LoggerFactory.getLogger(HomeController.class);
    
    
    private HomeManager homeManager; 

    public void setHomeManager(HomeManager homeManager) {
		this.homeManager = homeManager;
	}

    @RequestMapping(method=RequestMethod.GET)
	protected ModelAndView home(Model model,HttpServletRequest request,HttpSession session) throws Exception {
    	slf4jLogger.info("This first controller after long");
    	
		//index is home page 
		return new ModelAndView("index");
	}
	
	
}
