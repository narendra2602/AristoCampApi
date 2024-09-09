package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampPlannerResponse {

	
	private int campplannerId;
	private int campcreationId;
	private int campId;
	private String campName;
	private int campeventId;
	private int doctorCode;
	private String doctorName;
	private int psrCode;
	private String psrName;

}
