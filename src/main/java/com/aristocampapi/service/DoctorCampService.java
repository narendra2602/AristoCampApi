package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.DoctorCamp;
import com.aristocampapi.request.DoctorCampRequest;
import com.aristocampapi.response.DoctorResponse;

public interface DoctorCampService {
	
	DoctorCamp saveDoctorCamp(DoctorCampRequest doctorCamp);
	DoctorResponse getDoctorDetails(int doctorCode);

}
