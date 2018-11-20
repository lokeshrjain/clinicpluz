package com.clinicpluz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.clinicpluz.model.Article;
import com.clinicpluz.model.Customer;

public class JDBCHomeDAO implements HomeDAO {
    private static Logger slf4jLogger = LoggerFactory.getLogger(JDBCHomeDAO.class);
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
    }

	@Override
	public List<Article> getArticles() {
		ArrayList<Article> articleList = new ArrayList<Article>();
		ResultSet rs =null;
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try{
			con = getConnection();
			String ssql = "Select articleId,title,bodytext,articleStatus,articleDate FROM Article ORDER BY articleDate DESC LIMIT 10";
			pStmt = con.prepareStatement(ssql);
			slf4jLogger.info("Query: " + pStmt.toString());

			rs  = pStmt.executeQuery();
			
			//take this code to CommonDAO and get the list of specific list type .
			while (rs.next()) {
				Article article = new Article();
		
				article.setArticleId(rs.getString("articleId"));
				article.setTitle(rs.getString("title"));
				article.setBodyText(rs.getString("bodytext"));
				article.setArticleStatus(rs.getString("articleStatus"));
				article.setArticleDate(rs.getDate("articleDate"));
				articleList.add(article);
			}
		} catch(SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally {
			closeAll(con, pStmt,rs);
		}
		return articleList;
	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginCheck(Customer customer) {

			ResultSet rs = null;
			Connection con = null;
			PreparedStatement pStmt = null;
			boolean result=false;
			
			try {
				
				con = getConnection();
				String strQuery = "Select custId,Address,Note,FName,LName,emailId,gender,Postcode from Customer Where emailId=? And password=?";
			
				pStmt = con.prepareStatement(strQuery);	
			
				pStmt.setString(1, customer.getEmailId());
				pStmt.setString(2, customer.getPassId());
				
				slf4jLogger.info("Query: " + pStmt.toString());
				
				rs = pStmt.executeQuery();
				

				if (rs.next()) {
				
					customer.setCustId(rs.getString("custId"));
					customer.setAddress(rs.getString("address"));
					customer.setNote(rs.getString("note"));
					customer.setEmailId(rs.getString("emailId"));
					customer.setFirstName(rs.getString("FName"));
					customer.setLastName(rs.getString("LName"));
					customer.setGender(rs.getString("gender"));
					customer.setPostcode(rs.getString("postcode"));
					
					result=true;
					
				} else {
					
					result=false;
				}

			} catch(SQLException se)  {
				System.out.println(se.getMessage());
			}
			finally {
				closeAll(con, pStmt,rs);
			}
			return result;
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

}
