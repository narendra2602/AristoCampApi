package com.aristocampapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.DoctorCampDto;
import com.aristocampapi.entity.DoctorCamp;

public interface CampDoctorDao extends JpaRepository<DoctorCamp, Integer> {
	
	
	@Query(value="CALL CampDoctorDetail(:doctor_code);", nativeQuery=true)
	DoctorCampDto getCampDoctorDetail(@Param("doctor_code") int doctor_code);
	
	@Query(value="CALL DoctorMaster(:doctor_code);", nativeQuery=true)
	DoctorCampDto getDoctorDetail(@Param("doctor_code") int doctor_code);


}
