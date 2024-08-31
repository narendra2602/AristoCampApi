package com.aristocampapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.entity.CampPhotoFile;
import com.aristocampapi.request.CampPhotoFileRequest;
import com.aristocampapi.response.CampPhotoFileResponse;
import com.aristocampapi.service.CampPhotoFileService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampPhotoFileController {

	Logger logger = LoggerFactory.getLogger(CampPhotoFileController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@Autowired
	private CampPhotoFileService campPhotoFileService;
	
	@PostMapping("${mrc_campphotofile_entry_path}")
	public ResponseEntity<CampPhotoFile> saveCampPhotoFile(@RequestBody CampPhotoFileRequest campPhotoFileRequest,HttpServletRequest request)
	{
		System.out.println(campPhotoFileRequest.toString());
		
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 int createdBy=loginName==0?loginId:loginName;
		 campPhotoFileRequest.setUploadedBy(createdBy);
		return new ResponseEntity<CampPhotoFile>(campPhotoFileService.saveCampPhotoFile(campPhotoFileRequest),HttpStatus.CREATED);
		
	}
	
	@GetMapping("${mrc_campphotodetail_path}")
	public ResponseEntity<List<CampPhotoFileResponse>> getCampPhotoList(@PathVariable("campEventId") int campEventId)
	{
		System.out.println("campevent id "+campEventId);
		
		return new ResponseEntity<List<CampPhotoFileResponse>>(campPhotoFileService.getCampPhotoList(campEventId), HttpStatus.OK);
	 
	}

	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }


	
}
