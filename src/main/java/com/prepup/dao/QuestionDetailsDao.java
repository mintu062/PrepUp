package com.prepup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prepup.vo.QuestionDetailsVO;

@Repository
public class QuestionDetailsDao {

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	 @Autowired
	 private DataSource dataSource;
	 
	 public int addQuestion(QuestionDetailsVO qdv) {
	    	
	    	String sql="INSERT INTO questiondetails (ecode, question, optionA, optionB,optionC,optionD,answer) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);

	    	Connection con = null;
	    	PreparedStatement st = null;
	    	try {
				con = dataSource.getConnection();
				st = con.prepareStatement(sql);
				st.setString(1,qdv.geteCode());
				st.setString(2,qdv.getQuestion());
				st.setString(3,qdv.getOptionA());
				st.setString(4,qdv.getOptionB());
				st.setString(5,qdv.getOptionC());
				st.setString(6,qdv.getOptionD());
				st.setString(7,qdv.getAnswer());
				
			
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
