package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampDashBoardPanelDto;
import com.aristocampapi.dto.CampDashBoardRecentCampDto;
import com.aristocampapi.dto.CampDashboardCalendarDto;
import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.entity.CampCreation;

public interface CampDashBoardDao extends JpaRepository<CampCreation, Integer>{
	// panel 
	@Query(value="CALL CampDashboard(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardPanelDto> getDashBoardPanelData(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	// camp calendar
	@Query(value="CALL CampDashboardCalendar(:myear,:emp_code,:utype,:mnth);", nativeQuery=true)
	List<CampDashboardCalendarDto> getDashBoardCalendarData(@Param("myear") int myear,@Param("emp_code") int emp_code,
			@Param("utype") int utype,@Param("mnth") int mnth);

	
	// new camps
	@Query(value="CALL CampDashboardNewCamps(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardNewCampDto> getDashBoardNewCamps(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	// recent camps
	@Query(value="CALL CampDashboardRecentCamps(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardRecentCampDto> getDashBoardRecentCamps(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

}
