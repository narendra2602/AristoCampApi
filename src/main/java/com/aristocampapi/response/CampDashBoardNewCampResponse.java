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
public class CampDashBoardNewCampResponse {
	
	private int campcreationId;
	private int depoCode;
	private String campDate;
	private String campName;
	private String campLocation;
	private int line2Manager;
	private int line3Manager;
	

}
