package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.response.CampDashBoardCalendarResponse;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampDashBoardPanelResponse;
import com.aristocampapi.response.CampDashBoardRecentCampResponse;

public interface CampDashBoardService {
	
	List<CampDashBoardPanelResponse> getDashBoardPanelData(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardCalendarResponse> getDashBoardCalendarData(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardNewCampResponse> getDashBoardNewCamps(CampDashboardRequest campDashboardRequest);
	List<CampDashBoardRecentCampResponse> getDashBoardRecentCamps(CampDashboardRequest campDashboardRequest);
}
