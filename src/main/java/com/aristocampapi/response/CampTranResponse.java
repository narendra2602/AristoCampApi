package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampTranResponse {
	
	private int campeventId;
	private String CampDate;
	private String CampName;
	private String LocationName;
	private String Line1Manager;
	private int line2;
	private String line2approval;
	private int line3;
	private String line3approval;
	private int doctorCode;
	private String doctorName;
	private String campStatus;
	private String remark;
	private String campStartTime;
	private String campEndTime;
	private String psrName;
	private String line2Remark;
	private String line3Remark;
	private String psrRemark;
	

}
