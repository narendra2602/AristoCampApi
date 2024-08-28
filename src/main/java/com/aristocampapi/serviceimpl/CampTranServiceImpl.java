package com.aristocampapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampTranDao;
import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.entity.CampTran;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.service.CampTranService;

@Service
public class CampTranServiceImpl implements CampTranService{

	@Autowired
	private CampTranDao campTranDao;
	
	@Override
	public CampTran saveCampTran(CampTranRequest campTranreq) {
		// TODO Auto-generated method stub
		

		
		CampTran camptran=new CampTran();
		
		camptran.setCampeventId(campTranreq.getCampeventId());
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
		camptran.setCreatedBy(campTranreq.getCreatedBy());

		return campTranDao.save(camptran);
	}

}
