package com.aristocampapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.dto.CampTranDto;
import com.aristocampapi.entity.CampTran;

public interface CampTranDao extends JpaRepository<CampTran, Integer>{
	
	@Query(value="CALL CampDashboardNewCamps(:myear,:emp_code,:utype);", nativeQuery=true)
	CampDashBoardNewCampDto getCampDashboardNewCamps(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	@Query(value="CALL getCampTransactionDetail(:campcreationId);", nativeQuery=true)
	CampTranDto getCampTransactionDetail(@Param("campcreationId") int campcreationId);
	
	// new camps
	@Query(value="CALL getCampCreationDetailById(:myear,:loginId,:userType,:campcreationId);", nativeQuery=true)
	CampDashBoardNewCampDto getCampCreationDetailByIdData(@Param("myear") int myear,@Param("loginId") int loginId,@Param("userType") int userType,@Param("campcreationId") int campcreationId);


}
