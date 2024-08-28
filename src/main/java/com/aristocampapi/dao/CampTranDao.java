package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.entity.CampTran;

public interface CampTranDao extends JpaRepository<CampTran, Integer>{
	
	@Query(value="CALL CampDashboardNewCamps(:myear,:emp_code,:utype);", nativeQuery=true)
	CampDashBoardNewCampDto getCampDashboardNewCamps(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);


}
