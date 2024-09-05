package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.CampDashBoardCalendarResponse;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampDashBoardPanelApprovalDataResponse;
import com.aristocampapi.response.CampDashBoardPanelDataResponse;
import com.aristocampapi.response.CampDashBoardPanelResponse;
import com.aristocampapi.response.CampDashBoardRecentCampResponse;
import com.aristocampapi.response.YearDataResponse;

public interface CampDashBoardService {
	
	List<CampDashBoardPanelResponse> getDashBoardPanelData(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardCalendarResponse> getDashBoardCalendarData(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardNewCampResponse> getDashBoardNewCamps(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardRecentCampResponse> getDashBoardRecentCamps(CampDashboardRequest campDashboardRequest);
	
	List<CampDashBoardPanelDataResponse> getTotalCamps(int myear,int loginId,int userType);
	List<CampDashBoardPanelDataResponse> getTotalUpcomingCamps(int myear,int loginId,int userType);
	List<CampDashBoardPanelDataResponse> getTotalCurrentCamps(int myear,int loginId,int userType);
	List<CampDashBoardPanelApprovalDataResponse> getTotalPendingApprovalCamps(int myear,int loginId,int userType);
	ApiResponse<YearDataResponse> getDashboardYearCombo();
}
