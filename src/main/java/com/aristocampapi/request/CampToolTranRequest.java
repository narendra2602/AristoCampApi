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
public class CampToolTranRequest {

	private int camptooltranId;
	private int campeventId;
	private int camptoolId;
	private int qtyReceived;
	private int qtyIssued;
	private int qtyBalanced;
	private int createdBy;
}
