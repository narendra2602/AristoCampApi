package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampApprovalDao;
import com.aristocampapi.dto.CampApprovalStatusDto;
import com.aristocampapi.entity.CampTran;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.response.CampApprovalResponse;
import com.aristocampapi.response.CampApprovalStatusResponse;
import com.aristocampapi.service.CampApprovalService;

@Service
public class CampApprovalServiceImpl implements CampApprovalService{

	@Autowired
	CampApprovalDao campApprovalDao;
	@Override
	public List<CampApprovalResponse> getApprovalStatusData(int myear, int campevent_id) {
		List<CampApprovalStatusDto> campApprovalList=campApprovalDao.getCampApproval(myear,campevent_id); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campApprovalList!=null)
			size=campApprovalList.size();
		
		List<CampApprovalResponse> responseList= new ArrayList<CampApprovalResponse>();
		// TODO Auto-generated method stub
		
		campApprovalList.forEach(data->{
			CampApprovalResponse res=new CampApprovalResponse();
			res.setCampeventId(data.getCampevent_id());
			res.setLine1Manager(data.getLine1_manager());
			res.setCampDate(data.getCamp_Date());
			res.setCampName(data.getCamp_name());
			res.setLocationName(data.getLocation_name());
			res.setManager(data.getManager());
			res.setApprovalStatus(data.getApproval_status());
			res.setDoctorName(data.getDoctor_name());
			res.setUserType(data.getUser_type());
			responseList.add(res);
		});
		
		return responseList;

	}
	@Override
	public CampApprovalStatusResponse saveApprovalStatusData(CampTranRequest camptranrequest , int userType) {

		Optional<CampTran> campTranData = campApprovalDao.findById(camptranrequest.getCampeventId());
		CampTran camp = campTranData.get();
		String message=null;
		 message=camptranrequest.getLine2approvalStatus().equals("Y")?"Approved Successfully":"Not Approved";

		if(userType==30)
		{
			camp.setLine2approvalStatus(camptranrequest.getLine2approvalStatus());
			// as required on 18/12/2024
			camp.setLine3approvalStatus(camptranrequest.getLine2approvalStatus());
			camp.setLine2Remark(camptranrequest.getRemark());
			camp.setLine3Remark(camptranrequest.getRemark());
		}
		else if(userType==40)
		{
			camp.setLine3approvalStatus(camptranrequest.getLine3approvalStatus());
			camp.setLine2approvalStatus(camptranrequest.getLine3approvalStatus());
			camp.setLine3Remark(camptranrequest.getRemark());
			camp.setLine2Remark(camptranrequest.getRemark());
			
		}
			
		camp = campApprovalDao.save(camp);
		CampApprovalStatusResponse res=new CampApprovalStatusResponse();
		res.setId(camptranrequest.getCampeventId());
		res.setMessage(message);
		return res;
	}

}
