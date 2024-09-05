package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampDashBoardPanelApprovalDataResponse {
	
	private int id;
	private String campDate;
	private String divName;
	private String campName;
	private String location;
	private int line2;
	private String line2approvalStatus;
	private int line3;
	private String line3approvalStatus;
	

}
