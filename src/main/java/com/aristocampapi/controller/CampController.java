package com.aristocampapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristocampapi.entity.CampCreation;
import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.entity.CampTran;
import com.aristocampapi.entity.DoctorCamp;
import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.CampMasterRequest;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.request.DoctorCampRequest;
import com.aristocampapi.request.PatientCampRequest;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.CampComboDataResponse;
import com.aristocampapi.service.CampComboService;
import com.aristocampapi.service.CampCreationService;
import com.aristocampapi.service.CampMasterService;
import com.aristocampapi.service.CampToolMasterService;
import com.aristocampapi.service.CampTranService;
import com.aristocampapi.service.DoctorCampService;
import com.aristocampapi.service.PatientCampService;
import com.aristocampapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")
public class CampController {
	
	Logger logger = LoggerFactory.getLogger(CampController.class);

	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	@Autowired
	private CampMasterService campMasterService;
	
	
	@Autowired
	private CampComboService campComboService;

	
	@Autowired
	private CampCreationService campCreationService;

	@Autowired
	private CampTranService campTranService;
	

	@Autowired
	private PatientCampService patientCampService;

	
	@PostMapping("${mrc_campmaster_entry_path}")
	public ResponseEntity<CampMaster> saveCampMaster(@RequestBody CampMasterRequest campmaster)
	{
		System.out.println(campmaster.toString());
		
		return new ResponseEntity<CampMaster>(campMasterService.saveCampMaster(campmaster),HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("${mrc_campcreation_entry_path}")
	public ResponseEntity<CampCreation> saveCampCreation(@RequestBody CampCreation campcreation,HttpServletRequest request)
	{
		System.out.println(campcreation.toString());
		 int loginId=getLoginIdFromToken(request)[0];
		 campcreation.setCreatedBy(loginId);
		 
//		 System.out.println(campcreation.toString());
		return new ResponseEntity<CampCreation>(campCreationService.saveCampCreation(campcreation),HttpStatus.CREATED);
		
	}

	@PostMapping("${mrc_camptran_entry_path}")
	public ResponseEntity<CampTran> saveCampTran(@RequestBody CampTranRequest camptran,HttpServletRequest request)
	{
		 int loginId=getLoginIdFromToken(request)[0];
		 int userType=getLoginIdFromToken(request)[1];
		 camptran.setCreatedBy(loginId);
		 camptran.setUserType(userType);
		
		return new ResponseEntity<CampTran>(campTranService.saveCampTran(camptran),HttpStatus.CREATED);
		
	}
	
	@PostMapping("${mrc_patientcamp_entry_path}")
	public ResponseEntity<PatientCamp> savePatientCamp(@RequestBody PatientCampRequest patientcamp,HttpServletRequest request)
	{
		System.out.println(patientcamp.toString());
		 int loginId=getLoginIdFromToken(request)[0];
		 patientcamp.setCreatedBy(loginId);
		 System.out.println(patientcamp.toString());
		return new ResponseEntity<PatientCamp>(patientCampService.savePatientCamp(patientcamp),HttpStatus.CREATED);
		
	}

	
	@GetMapping("${mrc_DivCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getDivisionList(HttpServletRequest request)
	{

        int loginId=getLoginIdFromToken(request)[0];
//		logger.info(AristoWebLogMsgConstant.DASH_BOARD_CONTROLLER,"getDivisionList");

		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getDivisionList(loginId), HttpStatus.OK);

	
	}

	@GetMapping("${mrc_BranchCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getBranchList(HttpServletRequest request)
	{

        int loginId=getLoginIdFromToken(request)[0];
//		logger.info(AristoWebLogMsgConstant.DASH_BOARD_CONTROLLER,"getDivisionList");

		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getBranchList(loginId), HttpStatus.OK);

	
	}

	@GetMapping("${mrc_CampCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getCampList(HttpServletRequest request)
	{

        int loginId=getLoginIdFromToken(request)[0];
//		logger.info(AristoWebLogMsgConstant.DASH_BOARD_CONTROLLER,"getDivisionList");

		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getCampList(loginId), HttpStatus.OK);

	
	}
	
	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }

}
