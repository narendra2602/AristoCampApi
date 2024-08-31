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
	private String Camp_date;
	private String Camp_name;
	private String Location_name;
	private String Line1_manager;
	private int line2;
	private String line2approval;
	private int line3;
	private String line3approval;
	private int doctorCode;
	private String doctorName;
	private String campStatus;
	private String remark;

}
