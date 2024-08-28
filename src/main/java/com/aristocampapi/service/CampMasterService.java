package com.aristocampapi.service;

import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.request.CampMasterRequest;

public interface CampMasterService {

	
	CampMaster saveCampMaster(CampMasterRequest campmaster);
}
