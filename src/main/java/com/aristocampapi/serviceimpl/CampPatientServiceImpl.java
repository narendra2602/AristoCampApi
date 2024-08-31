package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampPatientDao;
import com.aristocampapi.dto.CampPatientDto;
import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.PatientCampRequest;
import com.aristocampapi.response.CampPatientResponse;
import com.aristocampapi.service.CampPatientService;

@Service
public class CampPatientServiceImpl implements CampPatientService{

	
	@Autowired
	private CampPatientDao campPatientDao;
	@Override
	public PatientCamp savePatientCamp(PatientCampRequest patientCampreq) {
		PatientCamp patientCamp=new PatientCamp();
		
		patientCamp.setCamppatientId(patientCampreq.getCamppatientId());
		patientCamp.setCampeventId(patientCampreq.getCampeventId());
		patientCamp.setPatientGender(patientCampreq.getPatientGender());
		patientCamp.setPatientAge(patientCampreq.getPatientAge());
		patientCamp.setPatientReading(patientCampreq.getPatientReading());
		patientCamp.setCreatedBy(patientCampreq.getCreatedBy());

		
		return campPatientDao.save(patientCamp);
	}
	@Override
	public List<CampPatientResponse> getCampPatientList(int campeventId) {
		
		List<CampPatientDto> camppatientList=campPatientDao.getPatientDetails(campeventId); 
		int size=0;
		
		
		if(camppatientList!=null)
			size=camppatientList.size();
		
		List<CampPatientResponse> responseList= new ArrayList<CampPatientResponse>();
		// TODO Auto-generated method stub
		
		camppatientList.forEach(data->{
			CampPatientResponse res=new CampPatientResponse();
			res.setCamppatientId(data.getCamppatient_id());
			res.setPatientGender(data.getPatient_gender());
			res.setPatientAge(data.getPatient_age());
			res.setPatientReading(data.getPatient_reading());
			responseList.add(res);
		});
		
		return responseList;

	}

}
