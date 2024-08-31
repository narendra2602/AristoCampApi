package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.request.CampMasterRequest;
import com.aristocampapi.response.CampMasterResponse;

public interface CampMasterService {

	
	CampMaster saveCampMaster(CampMasterRequest campmaster);
	List<CampMasterResponse> getCampList(int userType);
}
