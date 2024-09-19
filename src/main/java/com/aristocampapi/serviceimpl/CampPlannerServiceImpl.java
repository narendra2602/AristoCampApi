package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampPlannerDao;
import com.aristocampapi.dto.CampPlannerDto;
import com.aristocampapi.entity.CampPlanner;
import com.aristocampapi.request.CampPlannerRequest;
import com.aristocampapi.response.CampPlannerResponse;
import com.aristocampapi.response.UserApiResponse;
import com.aristocampapi.service.CampPlannerService;

@Service
public class CampPlannerServiceImpl implements CampPlannerService{

	@Autowired
	private CampPlannerDao campPlannerDao;

	@Override
	public UserApiResponse saveCampPlanner(List<CampPlannerRequest> campplannerList,int loginId) {
		List<CampPlanner> dataList= new ArrayList<CampPlanner>();
		
		CampPlanner campplannerSave=new CampPlanner();
		campplannerList.forEach(data->{
			CampPlanner campPlanner=new CampPlanner();
			campPlanner.setCampplannerId(data.getCampplannerId());
			campPlanner.setCampcreationId(data.getCampcreationId());
			campPlanner.setCampeventId(data.getCampeventId());
			campPlanner.setDoctorCode(data.getDoctorCode());
			campPlanner.setPsrCode(data.getPsrCode());
			campPlanner.setCreatedBy(loginId);
			campPlanner.setLine2(data.getLine2());
			campPlanner.setLine3(data.getLine3());
			campPlanner.setMktYear(data.getMktYear());
			campPlanner.setCampStatus(data.getCampStatus());
			dataList.add(campPlanner);
		});
		List<CampPlanner> campPlaner = campPlannerDao.saveAll(dataList);
		int size=dataList.size();
		System.out.println("size of the data is *****"+size);

		UserApiResponse userResponse=new UserApiResponse();
        userResponse.setId(size);


        userResponse.setMessage("Camp Planner  Updated  Successfully");
        return userResponse; 
	}

	@Override
	public List<CampPlannerResponse> getCampPlannerData(int myear,int campplannerId) {
		
		List<CampPlannerDto> campToolList=campPlannerDao.getCampPlannerDetail(myear,campplannerId); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampPlannerResponse> responseList= new ArrayList<CampPlannerResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampPlannerResponse res=new CampPlannerResponse();
			res.setCampcreationId(data.getCampcreation_id());
			res.setCampplannerId(campplannerId);
			res.setCampId(data.getCamp_id());
			res.setCampName(data.getCamp_name());
			res.setCampeventId(data.getCampevent_id());
			res.setDoctorCode(data.getDoctor_code());
			res.setDoctorName(data.getDoctor_name());
			res.setPsrCode(data.getPsr_code());
			res.setPsrName(data.getPsr_name());
			
			responseList.add(res);
		});
		
		return responseList;

	}

	@Override
	public List<CampPlannerResponse> getCampPlannerList(int myear, int loginId, int userType) {
		List<CampPlannerDto> campToolList=campPlannerDao.getCampPlannerList(myear,loginId,userType); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampPlannerResponse> responseList= new ArrayList<CampPlannerResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampPlannerResponse res=new CampPlannerResponse();
			res.setCampplannerId(data.getCampplanner_id());
			res.setCampcreationId(data.getCampcreation_id());
			res.setCampId(data.getCamp_id());
			res.setCampName(data.getCamp_name());
			res.setCampeventId(data.getCampevent_id());
			res.setDoctorCode(data.getDoctor_code());
			res.setDoctorName(data.getDoctor_name());
			res.setPsrCode(data.getPsr_code());
			res.setPsrName(data.getPsr_name());
			
			responseList.add(res);
		});
		
		return responseList;
	}

	@Override
	public List<CampPlannerResponse> getCampPlannerGroup(int myear, int campcreationId, int psrCode) {
		List<CampPlannerDto> campToolList=campPlannerDao.getCampPlannerGroup(myear,campcreationId,psrCode); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampPlannerResponse> responseList= new ArrayList<CampPlannerResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampPlannerResponse res=new CampPlannerResponse();
			res.setCampplannerId(data.getCampplanner_id());
			res.setCampcreationId(data.getCampcreation_id());
			res.setCampId(data.getCamp_id());
			res.setCampName(data.getCamp_name());
			res.setCampeventId(data.getCampevent_id());
			res.setDoctorCode(data.getDoctor_code());
			res.setDoctorName(data.getDoctor_name());
			res.setPsrCode(data.getPsr_code());
			res.setPsrName(data.getPsr_name());
			
			responseList.add(res);
		});
		
		return responseList;
	}
	
	

}
