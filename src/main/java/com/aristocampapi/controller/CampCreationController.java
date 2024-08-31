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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.entity.CampCreation;
import com.aristocampapi.response.CampBranchResponse;
import com.aristocampapi.response.CampCreationResponse;
import com.aristocampapi.service.CampCreationService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampCreationController {
	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	@Autowired
	private CampCreationService campCreationService;
	
	@PostMapping("${mrc_campcreation_entry_path}")
	public ResponseEntity<CampCreation> saveCampCreation(@RequestBody CampCreation campcreation,HttpServletRequest request)
	{
		System.out.println(campcreation.toString());
		
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 campcreation.setCreatedBy(loginName==0?loginId:loginName);
		return new ResponseEntity<CampCreation>(campCreationService.saveCampCreation(campcreation),HttpStatus.CREATED);
		
	}
	
	@GetMapping("${mrc_CampCreationList_path}")
	public ResponseEntity<List<CampCreationResponse>> getCampCreationList(@PathVariable("myear") int myear,HttpServletRequest request)
	{


		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 int createdBy=(loginName==0?loginId:loginName);
		return new ResponseEntity<List<CampCreationResponse>>(campCreationService.getCampCreationList(myear,createdBy,userType), HttpStatus.OK);

	
	}


	@GetMapping("${mrc_CampBranchList_path}")
	public ResponseEntity<List<CampBranchResponse>> getCampBranchList(@PathVariable("campeventId") int campeventId,HttpServletRequest request)
	{

		return new ResponseEntity<List<CampBranchResponse>>(campCreationService.getCampBranchList(campeventId), HttpStatus.OK);

	
	}

	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }

}
