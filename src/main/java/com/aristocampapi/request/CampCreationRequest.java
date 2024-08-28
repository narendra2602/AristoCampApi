package com.aristocampapi.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampCreationRequest {
	private int id;
	private int campId;
	private Date dateOfPlanning;
	private Date dateOfExecution;
	private int mktYear;
	private int createdBy;
	private List<CampBranchRightsRequest> branch;

}
