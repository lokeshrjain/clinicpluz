package com.clinicpluz.service;

import java.util.List;
import com.clinicpluz.model.Appointment;

public interface AppointmentManager {
	
	public int saveOrUpdateAppointment(Appointment appointment);
	
	public int deleteAppointment(String custId,String apptId);

	public List<Appointment> getAppointments();
	
	public Appointment getAppointmentById(String custId,String apptId);

}
