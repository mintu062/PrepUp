package com.prepup.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.UserDetailsDao;
import com.prepup.model.ChangePassDetails;
import com.prepup.model.User;
import com.prepup.model.UserDetails;
import com.prepup.model.UserUpdateDetails;
import com.prepup.vo.UserDetailsVO;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsDao userdetailsdao;
	
	public Boolean isValidUser(User user) {
		UserDetailsVO userDetailsVO= new UserDetailsVO();
		userDetailsVO.setEmailid(user.getEmail());
		userDetailsVO.setPassword(user.getPassword());
		//--------------------------------------------------------------
		//random code generation using UUID
//		String uuid = UUID.randomUUID().toString();
//		System.out.println("uuid = " + uuid);
//		System.out.println("uuid = " + uuid.substring(28,36));
		//-----------------------------------------------------------------
		
	//random integer id generator---------------------------------------------
//		char ch;
//		String role="Student";
//		if(role=="Teacher")
//			ch='T';
//		else
//			ch='S';
//		
//		Integer uniqueIdint = (int) (System.currentTimeMillis() & 0xfffffff);
//		String uniqueId=ch+Integer.toString(uniqueIdint).substring(4,9);
//		System.out.println(uniqueId);
	//-----------------------------------------------------------------------------------------------	
		
		
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
		
		userDetailsVO.setRole(userdetails.getRole());
		
		char ch;
		if(userdetails.getRole().equals("Teacher"))
			ch='T';
		else
			ch='S';
		Integer uniqueIdint = (int) (System.currentTimeMillis() & 0xfffffff);
		String uniqueId=ch+Integer.toString(uniqueIdint).substring(4,9);
		userDetailsVO.setUserid(uniqueId);

		
		Boolean isSuccess=Boolean.FALSE;
		 if(userdetailsdao.createUser(userDetailsVO)>0) {
	        isSuccess=Boolean.TRUE;
	        }        
	        else {
	        	System.out.println("Registration failed");
	        }
		 return isSuccess;

		
	}

public Boolean updateUser(UserUpdateDetails userUpdateDetails) {
	
	
	UserDetailsVO userDetailsVO= new UserDetailsVO();
	userDetailsVO.setFname(userUpdateDetails.getFname());
	userDetailsVO.setMname(userUpdateDetails.getMname());
	userDetailsVO.setLname(userUpdateDetails.getLname());
	userDetailsVO.setPhnumber(userUpdateDetails.getPhone());
	userDetailsVO.setEmailid(userUpdateDetails.getEmail());
	userDetailsVO.setInstname(userUpdateDetails.getInstitute());
	

	
	Boolean isSuccess=Boolean.FALSE;
	 if(userdetailsdao.updateUser(userDetailsVO)>0) {
        isSuccess=Boolean.TRUE;
        }        
        else {
        	System.out.println("Registration failed");
        }
	 return isSuccess;

	
}

public Boolean changePass(ChangePassDetails changePassDetails) {
	
	

	
	Boolean isSuccess=Boolean.FALSE;
	 if(userdetailsdao.changePass(changePassDetails)>0) {
        isSuccess=Boolean.TRUE;
        }        
        else {
        	System.out.println("Old Password is wrong");
        }
	 return isSuccess;

	
}

}
