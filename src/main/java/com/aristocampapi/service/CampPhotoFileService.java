package com.aristocampapi.service;

import java.util.List;

import com.aristocampapi.entity.CampPhotoFile;
import com.aristocampapi.request.CampPhotoFileRequest;
import com.aristocampapi.response.CampPhotoFileResponse;

public interface CampPhotoFileService {
	
	CampPhotoFile saveCampPhotoFile(CampPhotoFileRequest campPhotoFileRequest);
	List<CampPhotoFileResponse> getCampPhotoList(int campEventId);

}
