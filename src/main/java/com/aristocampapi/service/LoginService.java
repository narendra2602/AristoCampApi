package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.request.LoginRequest;
import com.aristocampapi.response.DataUploadMessageResponse;
import com.aristocampapi.response.LoginResponse;
import com.aristocampapi.response.ReportTabResponse;

public interface LoginService {
	 
	LoginResponse authenticateUser(LoginRequest request);
	
	DataUploadMessageResponse getMessage();
	
	
	List<ReportTabResponse> getReportMenuList(int loginId);


	
}
