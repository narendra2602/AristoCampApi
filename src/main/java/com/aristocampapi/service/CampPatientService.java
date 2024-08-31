package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.PatientCampRequest;
import com.aristocampapi.response.CampPatientResponse;

public interface CampPatientService {
	
	PatientCamp savePatientCamp(PatientCampRequest patientCamp);
	List<CampPatientResponse> getCampPatientList(int campeventId);
}
