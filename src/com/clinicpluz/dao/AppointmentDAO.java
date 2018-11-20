package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.clinicpluz.model.Appointment;


public interface AppointmentDAO {
		
	public int insert(Appointment appointment);

	public int update(Appointment appointment);
	
	public int delete(String custId, String apptId);

	public Appointment getAppointmentById(String custId, String apptId);

	public List<Appointment> getAllAppointments();

	public void closeAll(Connection con, PreparedStatement pstmt);
	
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs);

}
