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

import com.aristocampapi.entity.CampMaster;
import com.aristocampapi.entity.CampTran;
import com.aristocampapi.entity.PatientCamp;
import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.request.CampMasterRequest;
import com.aristocampapi.request.CampTranRequest;
import com.aristocampapi.request.PatientCampRequest;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.CampComboDataResponse;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampMasterResponse;
import com.aristocampapi.response.CampPatientResponse;
import com.aristocampapi.response.CampTranResponse;
import com.aristocampapi.service.CampComboService;
import com.aristocampapi.service.CampMasterService;
import com.aristocampapi.service.CampPatientService;
import com.aristocampapi.service.CampTranService;
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
	private CampTranService campTranService;
	

	@Autowired
	private CampPatientService campPatientService;

	
	@PostMapping("${mrc_campmaster_entry_path}")
	public ResponseEntity<CampMaster> saveCampMaster(@RequestBody CampMasterRequest campmaster)
	{
		System.out.println(campmaster.toString());
		
		return new ResponseEntity<CampMaster>(campMasterService.saveCampMaster(campmaster),HttpStatus.CREATED);
		
	}
	
	

	@PostMapping("${mrc_camptran_entry_path}")
	public ResponseEntity<CampTran> saveCampTran(@RequestBody CampTranRequest camptran,HttpServletRequest request)
	{
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 camptran.setCreatedBy(loginName==0?loginId:loginName);
		 camptran.setUserType(userType);
		 int updateType=camptran.getCampeventId()>0?2:1;
		
		return new ResponseEntity<CampTran>(campTranService.saveCampTran(camptran,updateType),HttpStatus.CREATED);
		
	}
	@PostMapping("${mrc_campstatus_entry_path}")
	public ResponseEntity<CampTran> saveCampStatus(@RequestBody CampTranRequest camptran,HttpServletRequest request)
	{
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 camptran.setCreatedBy(loginName==0?loginId:loginName);
		 camptran.setUserType(userType);
		 int updateType=3;
		
		return new ResponseEntity<CampTran>(campTranService.saveCampTran(camptran,updateType),HttpStatus.CREATED);
		
	}
	
	@PostMapping("${mrc_patientcamp_entry_path}")
	public ResponseEntity<PatientCamp> savePatientCamp(@RequestBody PatientCampRequest patientcamp,HttpServletRequest request)
	{
		System.out.println(patientcamp.toString());
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
		 patientcamp.setCreatedBy(loginName==0?loginId:loginName);

		 System.out.println(patientcamp.toString());
		return new ResponseEntity<PatientCamp>(campPatientService.savePatientCamp(patientcamp),HttpStatus.CREATED);
		
	}

	@GetMapping("${mrc_CampPatientList_path}")
	public ResponseEntity<List<CampPatientResponse>> getCampPatientList(@PathVariable("campeventId") int campeventId,HttpServletRequest request)
	{

		return new ResponseEntity<List<CampPatientResponse>>(campPatientService.getCampPatientList(campeventId), HttpStatus.OK);

	
	}


	
	@GetMapping("${mrc_DivCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getDivisionList(HttpServletRequest request)
	{

//		logger.info(AristoWebLogMsgConstant.DASH_BOARD_CONTROLLER,"getDivisionList");
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0]; 
		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getDivisionList(loginId), HttpStatus.OK);

	
	}

	@GetMapping("${mrc_BranchCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getBranchList(HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getBranchList(), HttpStatus.OK);

	
	}

	@GetMapping("${mrc_CampCombo_path}")
	public ResponseEntity<ApiResponse<CampComboDataResponse>> getCampList(@PathVariable("divCode") int divCode,HttpServletRequest request)
	{

		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];

//		 int loginid=(loginName==0?loginId:loginName);

		return new ResponseEntity<ApiResponse<CampComboDataResponse>>(campComboService.getCampList(divCode), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_CampTransaction_path}")
	public ResponseEntity<CampTranResponse> getCampTransactionDetails(@PathVariable("campcreationId") int campcreationId,HttpServletRequest request)
	{

		return new ResponseEntity<CampTranResponse>(campTranService.getCampTransactionDetails(campcreationId), HttpStatus.OK);
	
	}
	@GetMapping("${mrc_CampTransactionById_path}")
	public ResponseEntity<CampDashBoardNewCampResponse> getCampCreationDetailById(@PathVariable("myear") int myear,@PathVariable("campcreationId") int campcreationId,HttpServletRequest request)
	{
		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		 int loginName=tokenArray[2];
 
		
		return new ResponseEntity<CampDashBoardNewCampResponse>(campTranService.getCampCreationDetailById(myear,loginName,userType,campcreationId), HttpStatus.OK);
	
	}

	
	@GetMapping("${mrc_CampList_path}")
	public ResponseEntity<List<CampMasterResponse>> getCampListNew(HttpServletRequest request)
	{


		int tokenArray[] = getLoginIdFromToken(request);
		 int loginId=tokenArray[0];
		 int userType=tokenArray[1];
		return new ResponseEntity<List<CampMasterResponse>>(campMasterService.getCampList(userType), HttpStatus.OK);

	
	}

	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }

}
