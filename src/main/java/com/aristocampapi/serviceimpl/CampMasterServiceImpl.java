package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampMasterDao;
import com.aristocampapi.dto.CampMasterDto;
import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.request.CampMasterRequest;
import com.aristocampapi.response.CampMasterResponse;
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

	@Override
	public List<CampMasterResponse> getCampList(int userType) {
		List<CampMasterDto> campList=campMasterDao.getCampList(userType); 
		int size=0;
		
		
		if(campList!=null)
			size=campList.size();
		
		List<CampMasterResponse> responseList= new ArrayList<CampMasterResponse>();
		// TODO Auto-generated method stub
		
		campList.forEach(data->{
			CampMasterResponse res=new CampMasterResponse();
			res.setCampId(data.getCamp_id());
			res.setDivCode(data.getDiv_code());
			res.setDivName(data.getDiv_name());
			res.setCampName(data.getCamp_name());
			responseList.add(res);
		});
		
		return responseList;
	}

}
