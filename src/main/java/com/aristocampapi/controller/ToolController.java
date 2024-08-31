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

import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
import com.aristocampapi.response.CampToolResponse;
import com.aristocampapi.response.CampToolTranResponse;
import com.aristocampapi.service.CampToolMasterService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class ToolController {

	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@Autowired
	private CampToolMasterService campToolMasterService;
	
	@PostMapping("${mrc_camptoolmaster_entry_path}")
	public ResponseEntity<CampToolMaster> saveCampToolMaster(@RequestBody CampToolMasterRequest camptoolmaster)
	{
		System.out.println(camptoolmaster.toString());
		
		return new ResponseEntity<CampToolMaster>(campToolMasterService.saveCampToolMaster(camptoolmaster),HttpStatus.CREATED);
		
	}
	
	@PostMapping("${mrc_camptooltran_entry_path}")
	public ResponseEntity<CampToolTranRequest> saveCampToolTran(@RequestBody List<CampToolTranRequest>  camptooltranList,HttpServletRequest request)
	{
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 int createdBy=loginName==0?loginId:loginName;

		//camptooltran.setCreatedBy(createdBy);
		return new ResponseEntity<CampToolTranRequest>(campToolMasterService.saveCampToolTran(camptooltranList),HttpStatus.CREATED);
		
	}

	
	@GetMapping("${mrc_camptooltran_path}")
	public ResponseEntity<List<CampToolTranResponse>> getToolTranData(@PathVariable("campeventId") int campeventId,HttpServletRequest request)
	{

		System.out.println(" id "+campeventId);
		return new ResponseEntity<List<CampToolTranResponse>>(campToolMasterService.getToolTranData(campeventId), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_camptoollist_path}")
	public ResponseEntity<List<CampToolResponse>> getToolList(HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);
		 int userType=tokenArray[1];

		return new ResponseEntity<List<CampToolResponse>>(campToolMasterService.getToolList(userType), HttpStatus.OK);
	
	}

	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }


}
