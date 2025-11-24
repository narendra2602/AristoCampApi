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

import com.aristocampapi.response.CampReportResponse;
import com.aristocampapi.service.CampReportService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampReportController {
	Logger logger = LoggerFactory.getLogger(CampReportController.class);
	
	
	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@Autowired
	private CampReportService campReportService;

	
	@GetMapping("${mrc_campreport_path}")
	public ResponseEntity<List<CampReportResponse>> getCampReportById(@PathVariable("campcreationId") int campcreationId,HttpServletRequest request)
	{

		System.out.println(" id "+campcreationId);
		return new ResponseEntity<List<CampReportResponse>>(campReportService.getCampReportById(campcreationId), HttpStatus.OK);
	
	}

	  private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }
}
