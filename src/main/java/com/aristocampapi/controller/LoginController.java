package com.aristocampapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.constant.AristoCampLogMsgConstant;
import com.aristocampapi.request.LoginRequest;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.DataUploadMessageResponse;
import com.aristocampapi.response.LoginResponse;
import com.aristocampapi.response.ReportTabResponse;
import com.aristocampapi.service.LoginService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("/api/mis")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	private LoginService loginService;

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest request)
	{
		logger.info(AristoCampLogMsgConstant.LOGIN_CONTROLLER,"authenticateUser");

		return new ResponseEntity<LoginResponse>(loginService.authenticateUser(request), HttpStatus.OK);
	
	}

	
	@GetMapping("/loginmenu")
	public ResponseEntity<ApiResponse<ReportTabResponse>> getMenuList(HttpServletRequest request)
	{
		
		String authHeader = request.getHeader("Authorization");
        String fname=appRequestParameterUtils.getRequestBodyFirstName(authHeader);
		int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
        int loginId=requestValues[0]; 

        logger.info(AristoCampLogMsgConstant.LOGIN_CONTROLLER,"authenticateUser");


        ApiResponse<ReportTabResponse> apiResponse = new ApiResponse<>(fname,0,"",loginService.getReportMenuList(loginId));


		return new ResponseEntity<ApiResponse<ReportTabResponse>>(apiResponse, HttpStatus.OK);

	
	}

	
	@GetMapping("/loginmessage")
	public ResponseEntity<DataUploadMessageResponse> getDataUploadMessage()
	{

		logger.info(AristoCampLogMsgConstant.LOGIN_CONTROLLER,"getMessage");

		return new ResponseEntity<DataUploadMessageResponse>(loginService.getMessage(), HttpStatus.OK);
	
	}

     private int getLoginIdFromToken(HttpServletRequest request)
     {
 		String authHeader = request.getHeader("Authorization");
 		int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
         int loginId=requestValues[0]; 
         return loginId;
     }
	
}
