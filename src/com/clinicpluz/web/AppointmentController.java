package com.clinicpluz.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.clinicpluz.model.Appointment;
import com.clinicpluz.model.CustomerTO;
import com.clinicpluz.service.AppointmentManager;

@Controller
public class AppointmentController {

	private AppointmentManager appointmentManager;
	
	private AppointmentValidator appointmentValidator;

	@Autowired
	public AppointmentController (AppointmentValidator appointmentValidator) {
		this.appointmentValidator=appointmentValidator;
	}
	
	@Autowired
	public void setAppointmentManager(AppointmentManager appointmentManager) {
		this.appointmentManager = appointmentManager;
	}

	@RequestMapping(value="createappointment.htm", method=RequestMethod.GET)
	public String showAppointmentForm(@ModelAttribute("appointment") Appointment appointment ) throws Exception {
			return "appointment";
	} 	

	@RequestMapping(value="appointmentList.htm", method=RequestMethod.GET)
	public String showAppointmentList(@RequestParam ("message") String message,@RequestParam ("apptId") String apptId,Model model,HttpSession session ) throws Exception {
		
		CustomerTO customerTO = (CustomerTO) session.getAttribute("customerTO");

//		System.out.println("--- Model data ---");
//		
//		Map modelMap = model.asMap();
//		
//		
//		for (Object modelKey : modelMap.keySet()) {
//		  Object modelValue = modelMap.get(modelKey);
//		  System.out.println(modelKey + " -- " + modelValue);
//		}

		List<Appointment> appointmentList= new ArrayList<Appointment>();
		Appointment appointment=appointmentManager.getAppointmentById(customerTO.getCustId(), apptId);
		
		if (appointment != null) { 
				appointmentList.add(appointment);
		}
		model.addAttribute("appointmentList", appointmentList);
		model.addAttribute("message", message);
		
		return "appointmentList";
	} 	

	
	@RequestMapping(value="editappointment.htm", method=RequestMethod.POST)
	public String editAppointmentForm(@ModelAttribute("appointment") Appointment appointment, Model model ) throws Exception {
		
		System.out.println("--- Model data ---");
		Map modelMap = model.asMap();

		for (Object modelKey : modelMap.keySet()) {
		  Object modelValue = modelMap.get(modelKey);
		  System.out.println(modelKey + " -- " + modelValue);
		}

		if (appointment != null) {
			System.out.println("1--" + appointment);
			appointment.load(appointmentManager.getAppointmentById(appointment.getCustId(),appointment.getApptId()));
			System.out.println("1" + appointment);
			return "appointment";
		} else {
			model.addAttribute("message", "Error while retrieving the appointment");
			return "appointmentList";
		}
		
	} 	

	@RequestMapping(value="saveappointment.htm",method=RequestMethod.POST)
	public String SaveAppointment(@ModelAttribute ("appointment") Appointment appointment,BindingResult result, HttpServletRequest request,Model model) {
		String msg= null;
			CustomerTO customerTO = (CustomerTO) request.getSession().getAttribute("customerTO");
			
			if (customerTO !=null) {
				appointment.setCustId(customerTO.getCustId());
			} else {
				msg = "Please login to take appointment";
				return "appointment";
			}
			appointmentValidator.validate(appointment, result);
		
			if(result.hasErrors()) {
				return "appointment";
				
			} else {
			
			appointmentManager.saveOrUpdateAppointment(appointment);		
			
			msg = "Appointment added successfully";
	
			model.addAttribute("apptId",appointment.getApptId());
			model.addAttribute("message","Appointment added successfully");
			return "redirect:appointmentList.htm";
			
			}
			
		//new ModelAndView(new RedirectView("appointmentList")).addObject("appointmentList", appointmentList);			
//		}else {		
//			//This is the place where we have to send error back to jsp. 			
//			System.out.println("Error Handling : ");
//			System.out.println("date =" + appointment.getRequestedDt());
//			msg = "Error occured while creating appointment";
//			return new ModelAndView("appointment", binder.getBindingResult().getModel());
//		}

	}

	@RequestMapping(value="deleteappointment.htm",method=RequestMethod.POST)
	public String delete(@ModelAttribute("appointment") Appointment appointment,Model model,HttpSession session) throws Exception {
		String msg;
		
		int result=appointmentManager.deleteAppointment(appointment.getCustId(),appointment.getApptId());
		if (result >0) {
			msg="Appointment deleted successfully";
			
		} else {
			msg="Error while deleting appointment";
		}
		
		model.addAttribute("message", msg);
		model.addAttribute("apptId", appointment.getApptId());
		
		return "redirect:appointmentList.htm";

	}

	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response,Appointment appointment) throws Exception {
		
		
		appointment =appointmentManager.getAppointmentById(appointment.getCustId(),appointment.getApptId());
		if (appointment != null) {
			return new ModelAndView("appointment", "message", "Appointment updated successfully").addObject("appointment", appointment);
		} else {
			return new ModelAndView("appointmentList", "message", "Error while retrieving the appointment");	
		}
	}
	
	public ModelAndView showAppointmentList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("List the appointment");
		List<Appointment> appointmentList=(ArrayList<Appointment>)request.getSession().getAttribute("appointmentList");	
		//appointmentManager.getAppointments();
//		List<Appointment> appointmentList= new ArrayList<Appointment>();
//		appointmentList.add(new Appointment());
		return new ModelAndView("appointmentList", "message", "List the appointment").addObject("appointmentList", appointmentList);
	}

}