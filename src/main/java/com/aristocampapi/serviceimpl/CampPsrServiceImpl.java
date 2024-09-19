package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampPsrDao;
import com.aristocampapi.dto.CampPsrDto;
import com.aristocampapi.response.PsrResponse;
import com.aristocampapi.service.CampPsrService;

@Service
public class CampPsrServiceImpl implements CampPsrService{
	
	@Autowired
	private CampPsrDao campPsrDao;

	@Override
	public List<PsrResponse> getPsrList(int myear, int loginId) {
		List<CampPsrDto> campPsrList=campPsrDao.getPsrList(myear,loginId); 
		int size=0;
		
		
		if(campPsrList!=null)
			size=campPsrList.size();
		
		List<PsrResponse> responseList= new ArrayList<PsrResponse>();
		// TODO Auto-generated method stub
		
		campPsrList.forEach(data->{
			PsrResponse res=new PsrResponse();
			res.setPsrCode(data.getPsr_code());
			res.setPsrName(data.getPsr_name());
			responseList.add(res);
		});
		
		return responseList;
	}


}
