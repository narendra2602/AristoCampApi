package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampDoctorDao;
import com.aristocampapi.dto.DoctorCampDto;
import com.aristocampapi.entity.DoctorCamp;
import com.aristocampapi.request.DoctorCampRequest;
import com.aristocampapi.response.DoctorResponse;
import com.aristocampapi.service.DoctorCampService;

@Service
public class DoctorCampServiceImpl implements DoctorCampService{

	
	@Autowired
	private CampDoctorDao doctorCampDao;
	
	@Override
	public DoctorCamp saveDoctorCamp(DoctorCampRequest doctorCampreq) {
		
		DoctorCamp doctorCamp=new DoctorCamp();
		doctorCamp.setId(doctorCampreq.getId());
		doctorCamp.setPcode(doctorCampreq.getPcode());
		doctorCamp.setName(doctorCampreq.getName());
		doctorCamp.setQualification(doctorCampreq.getQualification());
		doctorCamp.setRegistrationNumber(doctorCampreq.getRegistrationNumber());
		doctorCamp.setAddress(doctorCampreq.getAddress());
		doctorCamp.setCity(doctorCampreq.getCity());
		doctorCamp.setPinCode(doctorCampreq.getPinCode());
		doctorCamp.setMobileNo(doctorCampreq.getMobileNo());
		doctorCamp.setEmailId(doctorCampreq.getEmailId());

		
		
		return doctorCampDao.save(doctorCamp);
	}

	@Override
	public DoctorResponse getDoctorDetails(int doctorCode) {
		DoctorCampDto data=doctorCampDao.getCampDoctorDetail(doctorCode); 
		int size=0;
		
			DoctorResponse res=new DoctorResponse();
			res.setId(data.getId());
			res.setName(data.getName());
			res.setQualification(data.getQualification());
			res.setRegistrationNumber(data.getRegistration_number());
			res.setAddress(data.getAddress());
			res.setCity(data.getCity());
			res.setPinCode(data.getPin_code());
			res.setMobileNo(data.getMobile_no());
			res.setEmailId(data.getEmail_id());
			
		
		return res;
	}

	@Override
	public DoctorResponse getDoctorMaster(int doctorCode) {
		DoctorCampDto data=doctorCampDao.getDoctorDetail(doctorCode); 
		int size=0;
		
			DoctorResponse res=new DoctorResponse();
			res.setName(data.getName());
			res.setQualification(data.getQualification());
			res.setRegistrationNumber(data.getRegistration_number());
			res.setAddress(data.getAddress());
			res.setCity(data.getCity());
			res.setPinCode(data.getPin_code());
			res.setMobileNo(data.getMobile_no());
			res.setEmailId(data.getEmail_id());
			
		
		return res;
	}

}
