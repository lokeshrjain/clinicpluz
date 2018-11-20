package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.model.Appointment;

public class JDBCAppointmentDAO implements AppointmentDAO {
    private static Logger slf4jLogger = LoggerFactory.getLogger(JDBCAppointmentDAO.class);
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
    }
    
	public void closeAll(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeAll(con, pstmt);
	}

	@Override
	public int insert(Appointment appointment) {
		
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();
			String strQuery = "insert into AppointmentDetail(ApptId,CustId,FName,LName,Address,PostCode,emailId,gender,AppointmentNote,IsNew,AdditionalNote,PhoneNo,MobileNo,requestedDt,requestedTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			String UID= getNewUniqueKey();
			
			appointment.setApptId(UID);
			pStmt = con.prepareStatement(strQuery);	
			pStmt.setString(1,appointment.getApptId());
			pStmt.setString(2,appointment.getCustId());
			pStmt.setString(3,appointment.getFirstName());
			pStmt.setString(4,appointment.getLastName());
			pStmt.setString(5,appointment.getAddress());
			pStmt.setString(6,appointment.getPostcode());
			pStmt.setString(7,appointment.getEmailId());
			pStmt.setString(8,appointment.getGender());
			pStmt.setString(9,appointment.getAppointmentNote());
			pStmt.setString(10,appointment.getIsNewAppt());
			pStmt.setString(11,appointment.getAdditionalNote());
			pStmt.setString(12,appointment.getPhoneNo());
			pStmt.setString(13,appointment.getMobileNo());
			pStmt.setDate(14,new java.sql.Date(appointment.getRequestedDt().getTime()));
			pStmt.setTime(15,new java.sql.Time(appointment.getRequestedDt().getTime()));
		
			slf4jLogger.info("Query: " + pStmt.toString());
						
			result = pStmt.executeUpdate();
			
		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return result;
	}

	private String getNewUniqueKey() {
		return new Date().toString().trim().substring(0,20).replace(" ", "0");
	}

	@Override
	public int update(Appointment appointment) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();
			String strQuery = "update AppointmentDetail set FName=?,LName=?,Address=?,PostCode=?,emailId=?,gender=?,AppointmentNote=?,IsNew=?,AdditionalNote=?,PhoneNo=?,MobileNo=?,requestedDt=?,requestedTime=? Where ApptId =? and CustId=?";
			pStmt = con.prepareStatement(strQuery);	
			pStmt.setString(1,appointment.getFirstName());
			pStmt.setString(2,appointment.getLastName());
			pStmt.setString(3,appointment.getAddress());
			pStmt.setString(4,appointment.getPostcode());
			pStmt.setString(5,appointment.getEmailId());
			pStmt.setString(6,appointment.getGender());
			pStmt.setString(7,appointment.getAppointmentNote());
			pStmt.setString(8,appointment.getIsNewAppt());
			pStmt.setString(9,appointment.getAdditionalNote());
			pStmt.setString(10,appointment.getPhoneNo());
			pStmt.setString(11,appointment.getMobileNo());
			pStmt.setDate(12,new java.sql.Date(appointment.getRequestedDt().getTime()));
			pStmt.setTime(13,new java.sql.Time(appointment.getRequestedDt().getTime()));
			pStmt.setString(14,appointment.getApptId());
			pStmt.setString(15,appointment.getCustId());

			slf4jLogger.info("Query: " + pStmt.toString());
						
			result = pStmt.executeUpdate();
			

		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return result;
	}

	@Override
	public int delete(String custId, String apptId) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();

		String strQuery = "Delete from AppointmentDetail where CustId=? and ApptId=?";

		pStmt = con.prepareStatement(strQuery);	
		
		pStmt.setString(1,custId);
		pStmt.setString(2,apptId);
	
		slf4jLogger.info("Query: " + pStmt.toString());
		
		
		result = pStmt.executeUpdate();
	
		
	} catch(SQLException se)  {
		System.out.println(se.getMessage());
	}
	finally {
		closeAll(con, pStmt,rs);
	}
	return result;
}

	@Override
	public Appointment getAppointmentById(String custId, String apptId) {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		Appointment appointment=null;
		
		try {
			con = getConnection();
			String strQuery = "Select CustId,ApptId,FName,LName,Address,PostCode,emailId,gender,AppointmentNote,IsNew,AdditionalNote,PhoneNo,MobileNo,RequestedDt,RequestedTime,ModifyDt from AppointmentDetail where ApptId =? AND CustId=?";

			pStmt = con.prepareStatement(strQuery);	
		
			pStmt.setString(1, apptId);
			pStmt.setString(2, custId);
			
			slf4jLogger.info("Query: " + pStmt.toString());
			
			rs = pStmt.executeQuery();
			

			if (rs.next()) {
				appointment = new Appointment();
				appointment.setCustId(rs.getString("CustId"));
				appointment.setApptId(rs.getString("ApptId"));
				appointment.setFirstName(rs.getString("FName"));
				appointment.setLastName(rs.getString("LName"));
				appointment.setAddress(rs.getString("Address"));
				appointment.setPostcode(rs.getString("PostCode"));
				appointment.setEmailId(rs.getString("emailId"));
				appointment.setGender(rs.getString("gender"));
				appointment.setAppointmentNote(rs.getString("AppointmentNote"));
				appointment.setIsNewAppt(rs.getString("IsNew"));
				appointment.setAdditionalNote(rs.getString("AdditionalNote"));
				appointment.setPhoneNo(rs.getString("PhoneNo"));
				appointment.setMobileNo(rs.getString("mobileNo"));
				appointment.setRequestedDt(rs.getDate("RequestedDt"));
				appointment.setRequestedTime(rs.getTime("RequestedTime"));
			} 

		} catch(ParseException pe)  {
			System.out.println(pe.getMessage());

		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		
		return appointment;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		Appointment appointment=null;
		List<Appointment> appointmentList=new ArrayList<Appointment>();
		try {
			
			con = getConnection();
			String strQuery = "Select ApptId,FName,LName,Address,PostCode,emailId,gender,AppointmentNote,IsNew,AdditionalNote,PhoneNo,MobileNo,RequestedDt,RequestedTime,ModifyDt from AppointmentDetail where RequestedTime > now() AND CustId=?";
			
			pStmt = con.prepareStatement(strQuery);	
		
			slf4jLogger.info("Query: " + pStmt.toString());
			
			rs = pStmt.executeQuery();

			while (rs.next()) {
				appointment = new Appointment();
				appointment.setApptId(rs.getString("ApptId"));
				appointment.setFirstName(rs.getString("FName"));
				appointment.setLastName(rs.getString("LName"));
				appointment.setAddress(rs.getString("Address"));
				appointment.setPostcode(rs.getString("PostCode"));
				appointment.setEmailId(rs.getString("emailId"));
				appointment.setGender(rs.getString("gender"));
				appointment.setAppointmentNote(rs.getString("AppointmentNote"));
				appointment.setIsNewAppt(rs.getString("IsNew"));
				appointment.setAdditionalNote(rs.getString("AdditionalNote"));
				appointment.setPhoneNo(rs.getString("PhoneNo"));
				appointment.setMobileNo(rs.getString("mobileNo"));
				appointment.setRequestedDt(rs.getDate("RequestedDt"));
				appointment.setRequestedTime(rs.getTime("RequestedTime"));
				//appointment.setModifiedDt(new SimpleDateFormat("dd/MM/yyyy hh:mm").format(rs.getDate("ModifyDt")));
				appointmentList.add(appointment);
			} 
		} catch(ParseException pe)  {
			System.out.println(pe.getMessage());
	
		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return null;
	}

}
