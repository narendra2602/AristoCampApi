package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.dto.CampDashBoardPanelDataDetailDto;
import com.aristocampapi.dto.CampDashBoardPanelDto;
import com.aristocampapi.dto.CampDashBoardRecentCampDto;
import com.aristocampapi.dto.CampDashboardCalendarDto;
import com.aristocampapi.dto.CampDashboardPanelApprovalDataDetailDto;
import com.aristocampapi.dto.YearDataDto;
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

	
	// Total camps details
	@Query(value="CALL TotalCampsDetails(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardPanelDataDetailDto> getTotalCampsDetails(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	// Total upcoming camps details
	@Query(value="CALL TotalUpcomingCampDetails(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardPanelDataDetailDto> getTotalUpcomingCampDetails(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	// Total current month camps details
	@Query(value="CALL TotalCurrentMonthsCampsDetails(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashBoardPanelDataDetailDto> getTotalCurrentMonthsCampsDetails(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);


	// Total pending approval camps details
	@Query(value="CALL TotalPendingApprovalDetails(:myear,:emp_code,:utype);", nativeQuery=true)
	List<CampDashboardPanelApprovalDataDetailDto> getTotalPendingApprovalDetails(@Param("myear") int myear,@Param("emp_code") int emp_code,@Param("utype") int utype);

	
	
	@Query(value="CALL getDashboardYearCombo();", nativeQuery=true)
	List<YearDataDto>  getDashboardYearCombo();

}
