package com.prepup.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.dao.ClassDetailsDao;
import com.prepup.model.ChangePassDetails;
import com.prepup.model.ClassId;
import com.prepup.model.CreateClassDetails;
import com.prepup.model.TeacherId;
import com.prepup.rest.model.Status;
import com.prepup.service.ClassDetailsService;
import com.prepup.vo.ClassDetailsVO;

@RestController
public class RestFindClassByClassId {
	
	@Autowired
	ClassDetailsService classDetailsService;
	
	@PostMapping("rest/findclassbyclassid")
	public ClassDetailsVO findClassByCid(@RequestBody ClassId cid) {
		
		return classDetailsService.findClassByCid(cid);
	}


}
