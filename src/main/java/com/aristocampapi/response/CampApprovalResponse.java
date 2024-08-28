package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampApprovalResponse {
	
	private int campeventId;
	private String line1Manager;
	private String  locationName;
	private String campDate;
	private String campName;
	private String doctorName;
	private int manager;
	private String approvalStatus;
	private int userType;

}
