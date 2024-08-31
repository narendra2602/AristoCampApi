package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampToolResponse {

	private  int camptoolId;
	private int CampId;
	private String campName;
	private String ToolName;
	private int toolType;
}
	

