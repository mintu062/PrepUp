package com.prepup.service;

import java.util.UUID;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.prepup.dao.UserDetailsDao;
import com.prepup.model.ChangePassDetails;
import com.prepup.model.EmailId;
import com.prepup.model.User;
import com.prepup.model.UserDetails;
import com.prepup.model.UserUpdateDetails;
import com.prepup.rest.model.Status;
import com.prepup.vo.UserDetailsVO;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsDao userdetailsdao;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
    private JavaMailSender javaMailSender;
	
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
	    String uniqueIdstr=Integer.toString(uniqueIdint);
		String uniqueId=ch+Integer.toString(uniqueIdint).substring(uniqueIdstr.length()-4,uniqueIdstr.length());
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

public Status isEmailValid(EmailId email) {
	
	Status status=new Status();
	 if(userdetailsdao.isValidEmail(email.getEmailid())>0) {
		 
        String uuid = UUID.randomUUID().toString();
		String pass=(uuid.substring(26,36));
			if (userdetailsdao.resetPass(email.getEmailid(), pass)>0);
			{
				userDetailsService.sendEmail(email.getEmailid(), pass);
				status.setStatus_code(200);
		        status.setMessage("Your new password is send to your email id");
			}
        }        
        else {
        	status.setStatus_code(400);
	        status.setMessage("Your entered email is not registered");
        }
	 return status;

	
}

		public void sendEmail(String email,String pass) {
			
			SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo(email);
		
		    msg.setSubject("Reset Password");
		    msg.setText("Your new auto generated password is: "+pass);
		
		    javaMailSender.send(msg);
			
		} 

}
