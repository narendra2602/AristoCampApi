package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampPhotoFileDao;
import com.aristocampapi.dto.CampPhotoFileDto;
import com.aristocampapi.entity.CampPhotoFile;
import com.aristocampapi.request.CampPhotoFileRequest;
import com.aristocampapi.response.CampMasterResponse;
import com.aristocampapi.response.CampPhotoFileResponse;
import com.aristocampapi.service.CampPhotoFileService;

@Service
public class CampPhotoFileServiceImpl implements CampPhotoFileService {

	@Autowired
	private CampPhotoFileDao campPhotoFileDao;
	
	
	@Override
	public CampPhotoFile saveCampPhotoFile(CampPhotoFileRequest campPhotoFileRequest) {
		
		CampPhotoFile campPhotoFile=new CampPhotoFile();
		campPhotoFile.setId(campPhotoFileRequest.getId());
		campPhotoFile.setCampeventId(campPhotoFileRequest.getCampeventId());
		campPhotoFile.setFileName(campPhotoFileRequest.getFileName());
		campPhotoFile.setFileType(campPhotoFileRequest.getFileType());
		campPhotoFile.setUploadedBy(campPhotoFileRequest.getUploadedBy());
		
		return campPhotoFileDao.save(campPhotoFile);
	}


	@Override
	public List<CampPhotoFileResponse> getCampPhotoList(int campEventId) {
		List<CampPhotoFileDto> campPhotoList=campPhotoFileDao.getCampPhotoFile(campEventId); 
		int size=0;
		
		
		if(campPhotoList!=null)
			size=campPhotoList.size();
		
		List<CampPhotoFileResponse> responseList= new ArrayList<CampPhotoFileResponse>();
		// TODO Auto-generated method stub
		
		campPhotoList.forEach(data->{
			CampPhotoFileResponse res=new CampPhotoFileResponse();
			res.setId(data.getId());
			res.setCampeventId(data.getCampevent_id());
			res.setFileName(data.getFile_name());
			res.setFileType(data.getFile_type());
			res.setAddedOn(data.getAdded_on());
			responseList.add(res);
		});
		
		return responseList;
	}

}
