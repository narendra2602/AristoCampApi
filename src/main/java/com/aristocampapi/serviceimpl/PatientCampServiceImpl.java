package com.aristocampapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.PatientCampDao;
import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.PatientCampRequest;
import com.aristocampapi.service.PatientCampService;

@Service
public class PatientCampServiceImpl implements PatientCampService{

	
	@Autowired
	private PatientCampDao patientCampDao;
	@Override
	public PatientCamp savePatientCamp(PatientCampRequest patientCampreq) {
		PatientCamp patientCamp=new PatientCamp();
		
		patientCamp.setCamppatientId(patientCampreq.getCamppatientId());
		patientCamp.setCampeventId(patientCampreq.getCampeventId());
		patientCamp.setPatientGender(patientCampreq.getPatientGender());
		patientCamp.setPatientAge(patientCampreq.getPatientAge());
		patientCamp.setPatientReading(patientCampreq.getPatientReading());


		
		return patientCampDao.save(patientCamp);
	}

}
