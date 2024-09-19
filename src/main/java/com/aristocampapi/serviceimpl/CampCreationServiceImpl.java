package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampCreationDao;
import com.aristocampapi.dto.CampBranchDto;
import com.aristocampapi.dto.CampCreationDto;
import com.aristocampapi.entity.CampCreation;
import com.aristocampapi.response.CampBranchResponse;
import com.aristocampapi.response.CampCreationDeleteResponse;
import com.aristocampapi.response.CampCreationResponse;
import com.aristocampapi.service.CampCreationService;

@Service
public class CampCreationServiceImpl implements CampCreationService{

	
	@Autowired
	private CampCreationDao campCreationDao;
	@Transactional
	@Override
	public CampCreation saveCampCreation(CampCreation campCreation) {
		// TODO Auto-generated method stub
		return campCreationDao.save(campCreation);
	}
	@Override
	public List<CampCreationResponse> getCampCreationList(int myear, int loginId, int userType) {
		List<CampCreationDto> campToolList=campCreationDao.getCampCreationList(myear,loginId,userType); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampCreationResponse> responseList= new ArrayList<CampCreationResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampCreationResponse res=new CampCreationResponse();
			res.setCampcreationId(data.getCampcreation_id());
			res.setCampId(data.getCamp_id());
			res.setCampName(data.getCamp_name());
			res.setDateOfPlanning(data.getDate_of_planning());
			res.setDateOfExecution(data.getDate_of_execution());
			responseList.add(res);
		});
		
		return responseList;
	}
	@Override
	public List<CampBranchResponse> getCampBranchList(int campeventId) {
		List<CampBranchDto> campToolList=campCreationDao.getCampBranch(campeventId); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampBranchResponse> responseList= new ArrayList<CampBranchResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampBranchResponse res=new CampBranchResponse();
			res.setCampbranchId(data.getCampbranch_id());
			res.setDepoCode(data.getDepo_code());
			res.setDepoName(data.getDepo_name());
			res.setBranchStatus(data.getBranch_status());
			responseList.add(res);
		});
		return responseList;
	}
	@Override
	public CampCreationDeleteResponse deleteCampCreation(int campcreationId) {
		int size=0;
		size = campCreationDao.deleteCampCreation(campcreationId); 
		String wtxt="Deleted Sucessfully";
		if(size==9999)
		 wtxt="Record Not Found";
		else if(size>0)
			 wtxt="Can't Delete This Record";
		CampCreationDeleteResponse res=new CampCreationDeleteResponse();
		res.setCampcreationId(campcreationId);
		res.setMessage(wtxt);
		
		return res;
	}
	
}
