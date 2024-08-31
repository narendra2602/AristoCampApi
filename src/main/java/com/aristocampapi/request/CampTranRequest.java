package com.aristocampapi.request;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampTranRequest {

	private int campeventId;
	private int divCode;
	private int depoCode;
	private int campcreationId;
	private int doctorPcode;
	private int line2approvalBy;
	private String line2approvalStatus;
	private int line3approvalBy;
	private String line3approvalStatus;
	private String locationName;
	private Date campDate;
	private String campStartTime;
	private String campEndTime;
	private String campStatus;
	private int mktYear;
	private String remark;
	private int createdBy;

	private int loginId;
	private int userType;
}
