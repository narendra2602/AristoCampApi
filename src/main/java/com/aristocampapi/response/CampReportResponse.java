package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampReportResponse {
	private int campeventId;
	private String campName;
	private String dateOfPlanning;
	private String dateOfExecution;
	private int depoCode;
	private String cmpCity;
	private int campcreationId;
	private int doctorPcode;
	private String name;
	private String qualification;
	private String terName;
	private String campStatus;
	private String remark;
	private String psrRemark;
	private int terEmpcode;
	private String terEmpname;
	private  int line1Empcode;
	private String line1Empname;
	private  int line2Empcode;
	private String line2Empname;
	private  int line3Empcode;
	private String line3Empname;
	
	
	
	
	

}
