package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampToolMasterDto;
import com.aristocampapi.dto.CampToolTranDto;
import com.aristocampapi.entity.CampToolTran;

public interface CampToolTranDao extends JpaRepository<CampToolTran, Integer>{
	
	@Query(value="CALL CampToolDetail(:campeventId);", nativeQuery=true)
	List<CampToolTranDto> getCampToolDetail(@Param("campeventId") int campeventId);

	@Query(value="CALL getCampToolList(:userType);", nativeQuery=true)
	List<CampToolMasterDto> getCampToolList(@Param("userType") int userType);

	
}
