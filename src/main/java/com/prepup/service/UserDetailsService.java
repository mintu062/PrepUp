package com.prepup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.UserDetailsDao;
import com.prepup.model.User;
import com.prepup.model.UserDetails;
import com.prepup.vo.UserDetailsVO;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsDao userdetailsdao;
	
	public Boolean isValidUser(User user) {
		UserDetailsVO userDetailsVO= new UserDetailsVO();
		userDetailsVO.setEmailid(user.getEmail());
		userDetailsVO.setPassword(user.getPassword());
		
		Boolean isSuccess=Boolean.FALSE;
		 if(userdetailsdao.isValidUser(userDetailsVO)>0) {
	        isSuccess=Boolean.TRUE;
	        }        
	        else {
	        	System.out.println("login failed");
	        }
		 return isSuccess;
	}
	public UserDetailsVO findUser(User user) {
		UserDetailsVO userDetailsVO= new UserDetailsVO();
		userDetailsVO.setEmailid(user.getEmail());
		userDetailsVO.setPassword(user.getPassword());
		
		return userdetailsdao.findUser(userDetailsVO);
	}
	
public Boolean createUser(UserDetails userdetails) {
		
		
		UserDetailsVO userDetailsVO= new UserDetailsVO();
		userDetailsVO.setFname(userdetails.getFname());
		userDetailsVO.setMname(userdetails.getMname());
		userDetailsVO.setLname(userdetails.getLname());
		userDetailsVO.setPhnumber(userdetails.getPhone());
		userDetailsVO.setEmailid(userdetails.getEmail());
		userDetailsVO.setPassword(userdetails.getPassword());
		userDetailsVO.setInstname(userdetails.getInstitute());
		//userDetailsVO.setUserid(2);
		userDetailsVO.setRole(userdetails.getRole());
		

		
		Boolean isSuccess=Boolean.FALSE;
		 if(userdetailsdao.createUser(userDetailsVO)>0) {
	        isSuccess=Boolean.TRUE;
	        }        
	        else {
	        	System.out.println("Registration failed");
	        }
		 return isSuccess;

		
	}

}
