package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampMasterDto;
import com.aristocampapi.entity.CampMaster;

public interface CampMasterDao extends JpaRepository<CampMaster, Integer>{
	
	@Query(value="CALL getCampList(:userType);", nativeQuery=true)
	List<CampMasterDto> getCampList(@Param("userType") int userType);

}
