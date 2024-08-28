package com.aristocampapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.response.CampDashBoardCalendarResponse;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampDashBoardPanelResponse;
import com.aristocampapi.response.CampDashBoardRecentCampResponse;
import com.aristocampapi.service.CampDashBoardService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampDashBoardController {
	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	@Autowired
	private CampDashBoardService campDashBoardService;
	
	@PostMapping("${mrc_dashboard_path}")
	public ResponseEntity<List<CampDashBoardPanelResponse>> getDashBoardPanelData(@RequestBody CampDashboardRequest campDashboardRequest,HttpServletRequest request)
	{
		int loginId=getLoginIdFromToken(request)[0];
		int userType=getLoginIdFromToken(request)[1];

		campDashboardRequest.setLoginId(loginId);
		campDashboardRequest.setUserType(userType);
		
		
		return new ResponseEntity<List<CampDashBoardPanelResponse>>(campDashBoardService.getDashBoardPanelData(campDashboardRequest),HttpStatus.CREATED);
		
	}

	
	@PostMapping("${mrc_dashboard_calendar_path}")
	public ResponseEntity<List<CampDashBoardCalendarResponse>> getDashBoardCalendarData(@RequestBody CampDashboardRequest campDashboardRequest,HttpServletRequest request)
	{
		int loginId=getLoginIdFromToken(request)[0];
		int userType=getLoginIdFromToken(request)[1];

		campDashboardRequest.setLoginId(loginId);
		campDashboardRequest.setUserType(userType);
		
		
		return new ResponseEntity<List<CampDashBoardCalendarResponse>>(campDashBoardService.getDashBoardCalendarData(campDashboardRequest),HttpStatus.CREATED);
		
	}

	@PostMapping("${mrc_dashboard_newcamp_path}")
	public ResponseEntity<List<CampDashBoardNewCampResponse>> getDashBoardNewCamps(@RequestBody CampDashboardRequest campDashboardRequest,HttpServletRequest request)
	{
		int loginId=getLoginIdFromToken(request)[0];
		int userType=getLoginIdFromToken(request)[1];

		campDashboardRequest.setLoginId(loginId);
		campDashboardRequest.setUserType(userType);
		
		
		return new ResponseEntity<List<CampDashBoardNewCampResponse>>(campDashBoardService.getDashBoardNewCamps(campDashboardRequest),HttpStatus.CREATED);
		
	}

	@PostMapping("${mrc_dashboard_recentcamp_path}")
	public ResponseEntity<List<CampDashBoardRecentCampResponse>> getDashBoardRecentCamps(@RequestBody CampDashboardRequest campDashboardRequest,HttpServletRequest request)
	{
		int loginId=getLoginIdFromToken(request)[0];
		int userType=getLoginIdFromToken(request)[1];

		campDashboardRequest.setLoginId(loginId);
		campDashboardRequest.setUserType(userType);
		
		
		return new ResponseEntity<List<CampDashBoardRecentCampResponse>>(campDashBoardService.getDashBoardRecentCamps(campDashboardRequest),HttpStatus.CREATED);
		
	}
	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }


}
