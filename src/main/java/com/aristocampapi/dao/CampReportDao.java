package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampReportDto;
import com.aristocampapi.dto.MktDataDto;

public interface CampReportDao extends JpaRepository<MktDataDto, Integer> {
	
	@Query(value="call CampReportById(:campcreationId);", nativeQuery=true)
	List<CampReportDto> getCampReportById(@Param("campcreationId") int campcreationId);
	

}
