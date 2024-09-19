package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampPsrDto;
import com.aristocampapi.entity.CampTran;

public interface CampPsrDao  extends JpaRepository<CampTran, Integer>{

	@Query(value="CALL getPsrList(:myear,:loginId);", nativeQuery=true)
	List<CampPsrDto> getPsrList(@Param("myear") int myear,@Param("loginId") int loginId);

	
}
