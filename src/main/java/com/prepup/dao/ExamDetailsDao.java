package com.prepup.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prepup.vo.ClassDetailsVO;
import com.prepup.vo.ExamDetailsVO;

@Repository
public class ExamDetailsDao {

	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
 @Autowired
 private DataSource dataSource;
 
 
 public int createExam(ExamDetailsVO edv) {
    	    	
    	    	String sql="INSERT INTO examdetails (ename, ecode, classid, date,duration,instruction) VALUES (?, ?, ?, ?, ?, ?)";
    	    	
    	    	jdbcTemplate = new JdbcTemplate(dataSource);
   
    	    	Connection con = null;
    	    	PreparedStatement st = null;
    	    	try {
    				con = dataSource.getConnection();
    				st = con.prepareStatement(sql);
    				st.setString(1,edv.geteName());
    				st.setString(2,edv.geteCode());
    				st.setString(3,edv.getClassId());
    				st.setDate(4,edv.getDate());
    				st.setInt(5, edv.getDuration());
    				st.setString(6, edv.getInstruction());
    			
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
