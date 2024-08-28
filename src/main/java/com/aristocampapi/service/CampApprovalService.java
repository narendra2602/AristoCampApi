package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.response.CampApprovalResponse;
import com.aristocampapi.response.CampApprovalStatusResponse;

public interface CampApprovalService {
	
	
	List<CampApprovalResponse> getApprovalStatusData(int myear,int campevent_id);
	CampApprovalStatusResponse saveApprovalStatusData(int campeventId,int userType,String approvalStatus);

}
