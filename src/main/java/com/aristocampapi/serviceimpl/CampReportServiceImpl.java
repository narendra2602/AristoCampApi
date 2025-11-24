package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampReportDao;
import com.aristocampapi.dto.CampReportDto;
import com.aristocampapi.response.CampPlannerResponse;
import com.aristocampapi.response.CampReportResponse;
import com.aristocampapi.service.CampReportService;

@Service
public class CampReportServiceImpl implements CampReportService{
	
	@Autowired
	private CampReportDao campReportDao;

	@Override
	public List<CampReportResponse> getCampReportById(int campcreationId) {
		List<CampReportDto> campReportList=campReportDao.getCampReportById(campcreationId); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campReportList!=null)
			size=campReportList.size();

		List<CampReportResponse> responseList= new ArrayList<CampReportResponse>();
		
		campReportList.forEach(data->{
			CampReportResponse res=new CampReportResponse();
			res.setCampcreationId(data.getCampcreation_id());
			res.setCampeventId(data.getCampevent_id());
			
			res.setCampName(data.getCamp_name());
			res.setDateOfPlanning(data.getDate_of_planning());
			res.setDateOfExecution(data.getDate_of_execution());
			res.setDepoCode(data.getDepo_code());
			res.setCmpCity(data.getCmp_city());
			res.setCampcreationId(data.getCampcreation_id());
			res.setDoctorPcode(data.getDoctor_pcode());
			res.setName(data.getName());
			res.setQualification(data.getQualification());
			res.setTerName(data.getTer_name());
			res.setCampStatus(data.getCamp_status());
			res.setRemark(data.getRemark());
			res.setPsrRemark(data.getPsr_remark());
			res.setTerEmpcode(data.getTer_empcode());
			res.setTerEmpname(data.getTer_empname());
			res.setLine1Empcode(data.getLine1_empcode());
			res.setLine1Empname(data.getLine1_empname());
			res.setLine2Empcode(data.getLine2_empcode());
			res.setLine2Empname(data.getLine2_empname());
			res.setLine3Empcode(data.getLine3_empcode());
			res.setLine3Empname(data.getLine3_empname());
			

			
			responseList.add(res);
		});
		
		return responseList;

	}

}
