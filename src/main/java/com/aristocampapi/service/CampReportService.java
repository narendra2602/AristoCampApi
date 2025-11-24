package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.response.CampReportResponse;

public interface CampReportService {
	
	List<CampReportResponse> getCampReportById(int campcreationId);

}
