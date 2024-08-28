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
public class PatientCampRequest {
	
	private int camppatientId;
	private int campeventId;
	private String patientGender;
	private int patientAge;
	private String patientReading;
	private int createdBy;

}
