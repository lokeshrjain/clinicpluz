package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.model.Customer;

public class JDBCRegistrationDAO implements RegistrationDAO {
    private static Logger slf4jLogger = LoggerFactory.getLogger(JDBCRegistrationDAO.class);
	
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
	public int insert(Customer customer) {
		
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();
			String strQuery = "insert into Customer(CustId,FName,LName,Address,PostCode,emailId,gender,Note,Password) values(?,?,?,?,?,?,?,?,?)";
			String UID= getNewUniqueKey();
			customer.setCustId(UID);
			

			pStmt = con.prepareStatement(strQuery);	
			
			pStmt.setString(1,customer.getCustId());
			pStmt.setString(2,customer.getFirstName());
			pStmt.setString(3,customer.getLastName());
			pStmt.setString(4,customer.getAddress());
			pStmt.setString(5,customer.getPostcode());
			pStmt.setString(6,customer.getEmailId());
			pStmt.setString(7,customer.getGender());
			pStmt.setString(8,customer.getNote());

			//Date dt = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(customer.getRegDate().toString());
			//pStmt.setDate(9,new java.sql.Date(dt.getTime()));

			pStmt.setString(9,customer.getPassId());
			
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
	public int update(Customer customer) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();
			String strQuery = "UPDATE Customer Set FName=?,LName=?,Address=?,PostCode=?,emailId=?,password=?,gender=?,Note=? WHERE CustId=?";

			pStmt = con.prepareStatement(strQuery);	
			
			pStmt.setString(1,customer.getFirstName());
			pStmt.setString(2,customer.getLastName());
			pStmt.setString(3,customer.getAddress());
			pStmt.setString(4,customer.getPostcode());
			pStmt.setString(5,customer.getEmailId());
			pStmt.setString(6,customer.getGender());
			pStmt.setString(7,customer.getNote());
			pStmt.setString(8,customer.getCustId());

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
	public int delete(String custId) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		int result=0;
		try {
			con = getConnection();

		String strQuery = "Delete from Customer where CustId=?";

		pStmt = con.prepareStatement(strQuery);	
		
		pStmt.setString(1,custId);
	
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
	public Customer getCustomerById(String custId) {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		Customer customer=null;
		try {
			
			con = getConnection();
			String strQuery = "Select CustId,FName,LName,Address,PostCode,emailId,regDate,gender,Note from Customer Where custId=?";
			
			pStmt = con.prepareStatement(strQuery);	
		
			pStmt.setString(1, custId);
			
			slf4jLogger.info("Query: " + pStmt.toString());
			
			rs = pStmt.executeQuery();
			

			if (rs.next()) {
				customer = new Customer();
				customer.setCustId(custId);
				customer.setAddress(rs.getString("address"));
				customer.setNote(rs.getString("Note"));
				customer.setEmailId(rs.getString("emailId"));
				customer.setFirstName(rs.getString("FName"));
				customer.setLastName(rs.getString("LName"));
				customer.setGender(rs.getString("gender"));
				customer.setPostcode(rs.getString("postcode"));
				customer.setRegDate(rs.getString("regDate"));
			} 

		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		Customer customer=null;
		List<Customer> customerList=new ArrayList<Customer>();
		try {
			
			con = getConnection();
			String strQuery = "Select CustId,FName,LName,Address,PostCode,emailId,regDate,gender,Note from Customer";
			
			pStmt = con.prepareStatement(strQuery);	
		
			slf4jLogger.info("Query: " + pStmt.toString());
			
			rs = pStmt.executeQuery();
			

			while (rs.next()) {
				customer = new Customer();
			
				customer.setCustId(rs.getString("CustId"));
				customer.setAddress(rs.getString("Address"));
				customer.setNote(rs.getString("Note"));
				customer.setEmailId(rs.getString("emailId"));
				customer.setFirstName(rs.getString("FName"));
				customer.setLastName(rs.getString("LName"));
				customer.setGender(rs.getString("gender"));
				customer.setPostcode(rs.getString("Postcode"));
				customer.setRegDate(rs.getString("regDate"));
				customerList.add(customer);
			} 

		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return customerList;
	}

}
