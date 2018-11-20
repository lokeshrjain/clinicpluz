package com.clinicpluz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.dao.AppointmentDAO;
import com.clinicpluz.model.Appointment;

public class SimpleAppointmentManager implements AppointmentManager {
	
	private AppointmentDAO appointmentDAO;
	
	@Autowired
	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public int saveOrUpdateAppointment(Appointment appointment) {
		int result = 0;
		
		if (appointment.getApptId() ==null || appointment.getApptId() =="") {
			result =appointmentDAO.insert(appointment);
		} else {
			result =appointmentDAO.update(appointment);
		}
		
		return result;
	}

	@Override
	public List<Appointment> getAppointments() {
		List<Appointment> appointmentList = null;
		
		appointmentList = appointmentDAO.getAllAppointments();
		//check for the error
		return appointmentList;
	}

	@Override
	public Appointment getAppointmentById(String custId,String apptId) {
		return appointmentDAO.getAppointmentById(custId, apptId);
	}

	
	@Override
	public int deleteAppointment(String custId,String apptId) {
		return appointmentDAO.delete(custId, apptId);
		
	}
	
}
