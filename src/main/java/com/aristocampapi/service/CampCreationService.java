package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.CampCreation;
import com.aristocampapi.response.CampBranchResponse;
import com.aristocampapi.response.CampCreationDeleteResponse;
import com.aristocampapi.response.CampCreationResponse;

public interface CampCreationService {
	CampCreation saveCampCreation(CampCreation campCreation);
	
	List<CampCreationResponse> getCampCreationList(int myear,int loginId,int userType);
	List<CampBranchResponse> getCampBranchList(int campeventId);
	CampCreationDeleteResponse deleteCampCreation(int campcreationId);

}
