package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampPatientDto;
import com.aristocampapi.entity.PatientCamp;

public interface CampPatientDao extends JpaRepository<PatientCamp, Integer>{
	
	@Query(value="CALL getPatientDetails(:campeventId);", nativeQuery=true)
	List<CampPatientDto> getPatientDetails(@Param("campeventId") int campeventId);

}
