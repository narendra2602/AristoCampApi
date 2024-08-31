package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampPhotoFileResponse {

	
	private int Id;
	private int campeventId;
	private String fileName;
	private String FileType;
	private String addedOn;
}
