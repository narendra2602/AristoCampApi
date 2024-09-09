package com.aristocampapi.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampPlannerRequest {
	
	private int campplannerId;
	private int campcreationId;
	private int campeventId;
	private int doctorCode;
	private int psrCode;
	private int mktYear;
	private int createdBy;
	private int line2;
	private int line3;

}
