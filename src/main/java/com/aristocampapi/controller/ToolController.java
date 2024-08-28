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
import com.aristocampapi.entity.CampToolTran;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
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
	public ResponseEntity<CampToolTran> saveCampToolTran(@RequestBody CampToolTranRequest camptooltran,HttpServletRequest request)
	{
		System.out.println(camptooltran.toString());
		int createdBy=getLoginIdFromToken(request)[0];
		camptooltran.setCreatedBy(createdBy);
		return new ResponseEntity<CampToolTran>(campToolMasterService.saveCampToolTran(camptooltran),HttpStatus.CREATED);
		
	}

	
	@GetMapping("${mrc_camptooltran_path}")
	public ResponseEntity<List<CampToolTranResponse>> getToolTranData(@PathVariable("campeventId") int campeventId,HttpServletRequest request)
	{

		System.out.println(" id "+campeventId);
		return new ResponseEntity<List<CampToolTranResponse>>(campToolMasterService.getToolTranData(campeventId), HttpStatus.OK);
	
	}

	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }


}
