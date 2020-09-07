package com.prepup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prepup.model.User;
import com.prepup.vo.UserDetailsVO;

@Repository
public class UserDetailsDao{
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    
	    public int count() {
	        return jdbcTemplate
	                .queryForObject("select count(*) from userdetails", Integer.class);
	    }
	    public int isValidUser(UserDetailsVO user) {
	    	String sql="select count(*) from userdetails where emailid=? and password=?";
	        return jdbcTemplate
	                .queryForObject(sql,new Object[] {user.getEmailid(),user.getPassword()},Integer.class
	                		);
	    }
	    
	    public UserDetailsVO findUser(UserDetailsVO user) {
	    	String sql="select * from userdetails where emailid=? and password=?";
	        return jdbcTemplate
	                .queryForObject(sql,new Object[] {user.getEmailid(),user.getPassword()},
	                		(rs,rowNum)->new UserDetailsVO(
	                				rs.getString("fname"),
	                				rs.getString("mname"),
	                				rs.getString("lname"),
	                				rs.getString("phnumber"),
	                				rs.getString("emailid"),
	                				rs.getString("instname"),
	                				rs.getInt("userid"),
	                				rs.getString("role")
	                				)
	                		);
	    }

}
