package com.aristocampapi.service;

import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.CampComboDataResponse;

public interface CampComboService {
	
	ApiResponse<CampComboDataResponse> getDivisionList(int loginId);
	ApiResponse<CampComboDataResponse> getCampList(int divCode);
	ApiResponse<CampComboDataResponse> getBranchList();

}
