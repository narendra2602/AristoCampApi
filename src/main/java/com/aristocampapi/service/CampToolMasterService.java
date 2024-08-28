package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.entity.CampToolTran;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
import com.aristocampapi.response.CampToolTranResponse;

public interface CampToolMasterService {
	
	CampToolMaster saveCampToolMaster(CampToolMasterRequest camptoolmaster);
	List<CampToolTranResponse> getToolTranData(int campeventId);
	CampToolTran saveCampToolTran(CampToolTranRequest camptooltran);

}
