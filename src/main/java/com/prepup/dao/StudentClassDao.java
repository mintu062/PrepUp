package com.prepup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prepup.model.JoinClassData;
import com.prepup.model.StudentClassTeacher;
import com.prepup.model.StudentId;
import com.prepup.vo.ClassDetailsVO;

@Repository
public class StudentClassDao {

	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 @Autowired
	 private DataSource dataSource;
	 
	 
	 public int checkJoinStatus(String studentId,String classId) {
			String sql="select count(*) from studentclass where studentId=? AND classId=?";
		    return jdbcTemplate
		            .queryForObject(sql,new Object[] {studentId,classId},Integer.class);
		}
	 
	 
	 
	 public int joinClass(String studentId,String classId) {
	    	
	    	String sql="INSERT INTO studentclass (studentId, classId) VALUES (?, ?)";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);

	    	Connection con = null;
	    	PreparedStatement st = null;
	    	try {
				con = dataSource.getConnection();
				st = con.prepareStatement(sql);
				st.setString(1,studentId);
				st.setString(2,classId);
			
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



	public List<StudentClassTeacher> findClassesByStudentId(StudentId studentId) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "Select classid,studentid,classname,classdesc,teacherid,fname,mname,lname,emailid\r\n" + 
        		"from (SELECT * FROM studentclass natural JOIN classdetails where studentid=?) as sp \r\n" + 
        		"inner join userdetails on sp.teacherid=userdetails.userid";
        
        return jdbcTemplate.query(sql, new Object[]{studentId.getStudentId()}, BeanPropertyRowMapper.newInstance(StudentClassTeacher.class));
	}
}
