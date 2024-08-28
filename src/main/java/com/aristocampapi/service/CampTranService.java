package com.aristocampapi.service;

import com.aristocampapi.entity.CampTran;
import com.aristocampapi.request.CampTranRequest;

public interface CampTranService {
	
	CampTran saveCampTran(CampTranRequest campTran);

}
