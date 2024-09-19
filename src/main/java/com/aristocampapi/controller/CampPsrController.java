package com.aristocampapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.response.PsrResponse;
import com.aristocampapi.service.CampPsrService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampPsrController {

	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	@Autowired
	private CampPsrService campPsrService;
	
	
	@GetMapping("${mrc_psrlist_path}")
	public ResponseEntity<List<PsrResponse>> getPsrList(@PathVariable("myear") int myear,HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 
		 int login=(loginName==0?loginId:loginName);
		return new ResponseEntity<List<PsrResponse>>(campPsrService.getPsrList(myear,login), HttpStatus.OK);
	
	}
	 private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }

}
