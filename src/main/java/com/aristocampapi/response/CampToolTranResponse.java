package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampToolTranResponse {
	
	private int camptooltranId;
	private int camptoolId;
	private String toolName;
	private int qtyReceived;
	private int qtyIssued;
	private int qtyBalanced;
	private int createdBy;

}
