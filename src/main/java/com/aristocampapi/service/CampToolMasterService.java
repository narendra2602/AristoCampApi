package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
import com.aristocampapi.response.CampToolResponse;
import com.aristocampapi.response.CampToolTranResponse;
import com.aristocampapi.response.UserApiResponse;

public interface CampToolMasterService {
	
	CampToolMaster saveCampToolMaster(CampToolMasterRequest camptoolmaster);
	List<CampToolTranResponse> getToolTranData(int campeventId);
	UserApiResponse saveCampToolTran(List<CampToolTranRequest> camptooltran);
//	CampToolTranRequest saveCampToolTran(List<CampToolTranRequest> camptooltran);

	List<CampToolResponse> getToolList(int userType);
	

}
