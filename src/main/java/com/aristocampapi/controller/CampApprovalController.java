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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.response.CampApprovalResponse;
import com.aristocampapi.response.CampApprovalStatusResponse;
import com.aristocampapi.service.CampApprovalService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("/api/mis")
public class CampApprovalController {
	
Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	private CampApprovalService campApprovalService;
	
	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@GetMapping("${mrc_campapproval_path}")
	public ResponseEntity<List<CampApprovalResponse>> getApprovalStatusData(@PathVariable("myear") int myear,@PathVariable("campeventId") int campeventId,HttpServletRequest request)
	{

		System.out.println("myear "+myear+" id "+campeventId);
		return new ResponseEntity<List<CampApprovalResponse>>(campApprovalService.getApprovalStatusData(myear,campeventId), HttpStatus.OK);
	
	}

	
	@PutMapping("${mrc_saveapproval_path}")
	public ResponseEntity<CampApprovalStatusResponse> saveApprovalStatusData(@PathVariable("campeventId") int campeventId,@PathVariable("approvalStatus") String approvalStatus,HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);

		 int userType=tokenArray[1];
		System.out.println("user type "+userType);
		return new ResponseEntity<CampApprovalStatusResponse>(campApprovalService.saveApprovalStatusData(campeventId,userType,approvalStatus), HttpStatus.OK);
	
	}

	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }
}
