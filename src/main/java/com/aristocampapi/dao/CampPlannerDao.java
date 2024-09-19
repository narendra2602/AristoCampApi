package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampPlannerDto;
import com.aristocampapi.entity.CampPlanner;

public interface CampPlannerDao extends JpaRepository<CampPlanner, Integer>{

	@Query(value="CALL CampPlannerDetailById(:myear,:campplannerId);", nativeQuery=true)
	List<CampPlannerDto> getCampPlannerDetail(@Param("myear") int myear,@Param("campplannerId") int campplannerId);
	
	
	@Query(value="CALL getCampPlannerList(:myear,:loginId,:userType);", nativeQuery=true)
	List<CampPlannerDto> getCampPlannerList(@Param("myear") int myear,@Param("loginId") int loginId,@Param("userType") int userType);

	
	@Query(value="CALL getCampPlannerGroup(:myear,:campcreationId,:psrCode);", nativeQuery=true)
	List<CampPlannerDto> getCampPlannerGroup(@Param("myear") int myear,@Param("campcreationId") int campcreationId,@Param("psrCode") int psrCode);

}
