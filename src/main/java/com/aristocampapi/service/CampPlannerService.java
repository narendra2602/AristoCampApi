package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.request.CampPlannerRequest;
import com.aristocampapi.response.CampPlannerResponse;
import com.aristocampapi.response.UserApiResponse;

public interface CampPlannerService {

	UserApiResponse saveCampPlanner(List<CampPlannerRequest> campplanner,int loginId);
	List<CampPlannerResponse> getCampPlannerData(int myear,int campplannerId);
	

	List<CampPlannerResponse> getCampPlannerList(int myear,int loginId,int userType);
	List<CampPlannerResponse> getCampPlannerGroup(int myear,int campcreationId,int psrCode);

	
}
