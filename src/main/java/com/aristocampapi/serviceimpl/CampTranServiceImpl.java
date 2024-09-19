package com.aristocampapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampTranDao;
import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.dto.CampTranDto;
import com.aristocampapi.entity.CampTran;
import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampTranResponse;
import com.aristocampapi.service.CampTranService;

@Service
public class CampTranServiceImpl implements CampTranService{

	@Autowired
	private CampTranDao campTranDao;
	
	@Override
	public CampTran saveCampTran(CampTranRequest campTranreq,int updateType) {
		// TODO Auto-generated method stub
		

		
		CampTran camptran=new CampTran();
		if(updateType==1)
		{
			camptran.setCampeventId(campTranreq.getCampeventId());
			camptran.setDivCode(campTranreq.getDivCode());
			camptran.setDepoCode(campTranreq.getDepoCode());
			camptran.setCampcreationId(campTranreq.getCampcreationId());
			camptran.setDoctorPcode(campTranreq.getDoctorPcode());
			camptran.setLine2approvalBy(campTranreq.getLine2approvalBy());
			camptran.setLine2approvalStatus(campTranreq.getLine2approvalStatus());
			camptran.setLine3approvalBy(campTranreq.getLine3approvalBy());
			camptran.setLine3approvalStatus(campTranreq.getLine3approvalStatus());
			camptran.setLocationName(campTranreq.getLocationName());
			camptran.setCampDate(campTranreq.getCampDate());
			camptran.setCampStartTime(campTranreq.getCampStartTime());
			camptran.setCampEndTime(campTranreq.getCampEndTime());
			camptran.setCampStatus(campTranreq.getCampStatus());
			camptran.setMktYear(campTranreq.getMktYear());
			camptran.setRemark(campTranreq.getRemark());
			camptran.setCreatedBy(campTranreq.getCreatedBy());
			camptran.setPsrCode(campTranreq.getPsrCode());
		}
		else if(updateType==2)
		{
			camptran=campTranDao.findById(campTranreq.getCampeventId()).get();
			camptran.setDoctorPcode(campTranreq.getDoctorPcode());
			camptran.setRemark(campTranreq.getRemark());
			camptran.setPsrCode(campTranreq.getPsrCode());
			camptran.setCampDate(campTranreq.getCampDate());
			camptran.setCampStartTime(campTranreq.getCampStartTime());
			camptran.setCampEndTime(campTranreq.getCampEndTime());

			
		}
		else if(updateType==3)
		{
			camptran=campTranDao.findById(campTranreq.getCampeventId()).get();
			camptran.setCampStatus(campTranreq.getCampStatus());
			camptran.setRemark(campTranreq.getRemark());
			
		}

		return campTranDao.save(camptran);
	}

	@Override
	public CampTranResponse getCampTransactionDetails(int campcreationId) {
		CampTranDto data=campTranDao.getCampTransactionDetail(campcreationId); 
		int size=0;
		
		CampTranResponse res=new CampTranResponse();
			res.setCampeventId(data.getCampevent_id());
			res.setCamp_date(data.getCamp_date());
			res.setCamp_name(data.getCamp_name());
			res.setLocation_name(data.getLocation_name());
			res.setLine1_manager(data.getLine1_manager());
			res.setLocation_name(data.getLocation_name());
			res.setLine2(data.getLine2());
			res.setLine2approval(data.getLine2approval());
			res.setLine3(data.getLine3());
			res.setLine3approval(data.getLine3approval());
			res.setDoctorCode(data.getDoctor_code());
			res.setDoctorName(data.getDoctor_name());
			res.setCampStatus(data.getCamp_status());
			res.setRemark(data.getCamp_remark());
		return res;
	}

	@Override
	public CampDashBoardNewCampResponse getCampCreationDetailById(int myear,int loginName,int userType,int campcreationId) {

		CampDashBoardNewCampDto data = campTranDao.getCampCreationDetailByIdData(myear,loginName,userType,campcreationId);
		
		
		
		// TODO Auto-generated method stub
		
			CampDashBoardNewCampResponse res=new CampDashBoardNewCampResponse();
			res.setCampcreationId(data.getCampcreation_id());
			res.setDepoCode(data.getDepo_code());
			res.setCampDate(data.getDate_of_execution());
			res.setCampName(data.getCamp_name());
			res.setCampLocation(data.getLocation_name());
			res.setLine2Manager(data.getLine2emp_code());
			res.setLine3Manager(data.getLine3emp_code());
			res.setDivCode(data.getDiv_Code());
			
			return res;
	}

}
