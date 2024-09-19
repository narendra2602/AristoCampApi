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

import com.aristocampapi.request.CampPlannerRequest;
import com.aristocampapi.response.CampPlannerResponse;
import com.aristocampapi.response.UserApiResponse;
import com.aristocampapi.service.CampPlannerService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampPlannerController {
	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@Autowired
	private CampPlannerService campPlannerService;
	
	@PostMapping("${mrc_campplanner_entry_path}")
	public ResponseEntity<UserApiResponse> saveCampPlanner(@RequestBody List<CampPlannerRequest>  campplannerList,HttpServletRequest request)
	{
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 int createdBy=loginName==0?loginId:loginName;
		 
		//camptooltran.setCreatedBy(createdBy);
		return new ResponseEntity<UserApiResponse>(campPlannerService.saveCampPlanner(campplannerList,createdBy),HttpStatus.CREATED);
		
	}

	@GetMapping("${mrc_campplanner_path}")
	public ResponseEntity<List<CampPlannerResponse>> getCampPlannerData(@PathVariable("myear") int myear,@PathVariable("campplannerId") int campplannerId,HttpServletRequest request)
	{

		System.out.println(" id "+campplannerId);
		return new ResponseEntity<List<CampPlannerResponse>>(campPlannerService.getCampPlannerData(myear,campplannerId), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_campplannerlist_path}")
	public ResponseEntity<List<CampPlannerResponse>> getCampPlannerList(@PathVariable("myear") int myear,HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 int createdBy=loginName==0?loginId:loginName;

		return new ResponseEntity<List<CampPlannerResponse>>(campPlannerService.getCampPlannerList(myear,createdBy,userType), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_campplannergroup_path}")
	public ResponseEntity<List<CampPlannerResponse>> getCampPlannerGroup(@PathVariable("myear") int myear,@PathVariable("campcreationId") int campcreationId,@PathVariable("psrCode") int psrCode,HttpServletRequest request)
	{


		return new ResponseEntity<List<CampPlannerResponse>>(campPlannerService.getCampPlannerGroup(myear,campcreationId,psrCode), HttpStatus.OK);
	
	}

	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }


}
