package com.aristocampapi.service;

import com.aristocampapi.entity.CampTran;
import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampTranResponse;

public interface CampTranService {
	
	CampTran saveCampTran(CampTranRequest campTran,int updateType);
	CampTranResponse getCampTransactionDetails(int campcreationId);
	CampDashBoardNewCampResponse getCampCreationDetailById(int myear,int loginName,int userType,int campcreationId);
}
