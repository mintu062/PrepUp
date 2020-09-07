package com.prepup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.UserDetailsDao;
import com.prepup.model.User;
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

}
