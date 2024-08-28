package com.aristocampapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
@Table(name="camptran")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampTran {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int campeventId;
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
	private int createdBy;
	
	
	

}
