package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampBranchDto;
import com.aristocampapi.dto.CampCreationDto;
import com.aristocampapi.entity.CampCreation;

public interface CampCreationDao extends JpaRepository<CampCreation, Integer>{
	
	@Query(value="CALL getCampCreationList(:myear,:loginId,:userType);", nativeQuery=true)
	List<CampCreationDto> getCampCreationList(@Param("myear") int myear,@Param("loginId") int loginId,@Param("userType") int userType);

	
	@Query(value="CALL getCampBranch(:campeventId);", nativeQuery=true)
	List<CampBranchDto> getCampBranch(@Param("campeventId") int campeventId);
	
	@Query(value="CALL deleteCampCrreation(:campcreationId);", nativeQuery=true)
	int  deleteCampCreation(@Param("campcreationId") int campcreationId);


}
