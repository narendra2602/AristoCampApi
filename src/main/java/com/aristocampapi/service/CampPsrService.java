package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.response.PsrResponse;

public interface CampPsrService {
	
	List<PsrResponse> getPsrList(int myear,int loginId);

}
