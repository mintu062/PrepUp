package com.prepup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prepup.vo.ClassDetailsVO;

@Repository
public class ClassDetailsDao {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 @Autowired
	 private DataSource dataSource;
	 
	 
	 public int createClass(ClassDetailsVO cdv) {
	    	    	
	    	    	String sql="INSERT INTO classdetails (ClassName, ClassDesc, TeacherId, ClassId,ClassPasskey) VALUES (?, ?, ?, ?, ?)";
	    	    	
	    	    	jdbcTemplate = new JdbcTemplate(dataSource);
	   
	    	    	Connection con = null;
	    	    	PreparedStatement st = null;
	    	    	try {
	    				con = dataSource.getConnection();
	    				st = con.prepareStatement(sql);
	    				st.setString(1,cdv.getClassName());
	    				st.setString(2,cdv.getClassDesc());
	    				st.setString(3,cdv.getTeacherId());
	    				st.setString(4,cdv.getClassId());
	    				st.setString(5,cdv.getClassPasskey());
	    			
	    				return st.executeUpdate();
	    			} catch (SQLException e) {
	    				// TODO: handle exception
	    				e.printStackTrace();
	    			}finally {
	    				try {
	    					con.close();
	    				} catch (SQLException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    				
	    			}
	    	    	return 0;

	    	
		 
	 }
}
