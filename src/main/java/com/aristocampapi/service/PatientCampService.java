package com.aristocampapi.service;

import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.PatientCampRequest;

public interface PatientCampService {
	
	PatientCamp savePatientCamp(PatientCampRequest patientCamp);
}
