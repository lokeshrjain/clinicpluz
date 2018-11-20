package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clinicpluz.model.Customer;


public class ClinicDAO {
        private static ClinicDAO clinicDAO = new ClinicDAO();
        private static Logger slf4jLogger = LoggerFactory.getLogger(ClinicDAO.class);
		private static DataSource ds;

        private ClinicDAO() {

        }

        public static ClinicDAO getInstance() {
                return clinicDAO;
        }       
        
        public static Connection getConnection(Connection con) throws SQLException {
        		try {
        			Context ctx = new InitialContext();
        			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ClinicDB");
        				
        		  } catch (NamingException e) {
        			e.printStackTrace();
        		  }

        		return ds.getConnection();
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
        
        /**
         * 
         * @param CustTo
         * @return boolean
         * true - success, false - failure 
         */
        public boolean loginCheck(Customer CustTO) {
        		slf4jLogger.debug("params: " + CustTO);
                Connection con = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                boolean flag = false;
                
                String sql =    "SELECT userid " +
                                                " FROM board_user " +
                                                " WHERE userid = ? AND userpass = ?";
                
                slf4jLogger.debug("SQL: " + sql);
                
                String userid = CustTO.getCustId();
                String userpass = CustTO.getPassId();
                try {
                        pstmt = getConnection(con).prepareStatement(sql);
                        pstmt.setString(1, userid);
                        pstmt.setString(2, userpass);
                        rs = pstmt.executeQuery();
                        if(rs.next()) {
                                flag = true;
                        }
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } finally {
                        closeAll(con, pstmt, rs);
                }
                return flag;
        }
        
        public int addUserInfo(Customer CustTO) {
        		slf4jLogger.debug("params: " + CustTO);
                Connection con = null;
                PreparedStatement pstmt = null;
                int result = 0;
                
                String sql =    "INSERT INTO board_user(userid, userpass, username, useraddr) " +
                                                " VALUES(?, ?, ?, ?)";
                slf4jLogger.debug("SQL: " + sql);
                
                try {
                        pstmt = getConnection(con).prepareStatement(sql);
                        pstmt.setString(1,      CustTO.getCustId());
                        pstmt.setString(2,      CustTO.getPassId());
                        pstmt.setString(3,      CustTO.getFirstName());
                        pstmt.setString(4,      CustTO.getAddress());
                        result = pstmt.executeUpdate(); 
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        closeAll(con, pstmt);
                }
                return result;
        }
        
}