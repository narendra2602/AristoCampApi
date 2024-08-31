package com.aristocampapi.controller;

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

import com.aristocampapi.entity.DoctorCamp;
import com.aristocampapi.request.DoctorCampRequest;
import com.aristocampapi.response.DoctorResponse;
import com.aristocampapi.service.DoctorCampService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class DoctorController {
	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	@Autowired
	private DoctorCampService doctorCampService;
	
	@PostMapping("${mrc_doctorcamp_entry_path}")
	public ResponseEntity<DoctorCamp> saveDoctorCamp(@RequestBody DoctorCampRequest doctorcamp,HttpServletRequest request)
	{
		System.out.println(doctorcamp.toString());
		 int loginId=getLoginIdFromToken(request)[0];
		 System.out.println(doctorcamp.toString());
		return new ResponseEntity<DoctorCamp>(doctorCampService.saveDoctorCamp(doctorcamp),HttpStatus.CREATED);
		
	}
	
	@GetMapping("${mrc_doctormaster_path}")
	public ResponseEntity<DoctorResponse> getDoctorMaster(@PathVariable("doctorCode") int doctorCode,HttpServletRequest request)
	{

		System.out.println(" code"+doctorCode);
		return new ResponseEntity<DoctorResponse>(doctorCampService.getDoctorMaster(doctorCode), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_doctordetail_path}")
	public ResponseEntity<DoctorResponse> getDoctorDetails(@PathVariable("doctorCode") int doctorCode,HttpServletRequest request)
	{

		System.out.println(" code"+doctorCode);
		return new ResponseEntity<DoctorResponse>(doctorCampService.getDoctorDetails(doctorCode), HttpStatus.OK);
	
	}

	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }

}
