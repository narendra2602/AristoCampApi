package com.aristocampapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampMasterDao;
import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.request.CampMasterRequest;
import com.aristocampapi.service.CampMasterService;

@Service
public class CampMasterServiceImpl implements CampMasterService {

	@Autowired
	private CampMasterDao campMasterDao;
	
	@Override
	public CampMaster saveCampMaster(CampMasterRequest campmasterreq) {
		// TODO Auto-generated method stub
		CampMaster campmaster=new CampMaster();
		campmaster.setCampId(campmasterreq.getCampId());
		campmaster.setCampName(campmasterreq.getCampName());
		campmaster.setDivCode(campmasterreq.getDivCode());
		return campMasterDao.save(campmaster);
	}

}
