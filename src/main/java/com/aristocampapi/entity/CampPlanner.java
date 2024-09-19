package com.aristocampapi.entity;

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
@Table(name="campplanner")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampPlanner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int campplannerId;
	private int campcreationId;
	private int campeventId;
	private int doctorCode;
	private int psrCode;
	private int mktYear;
	private int createdBy;
	private int line2;
	private int line3;
	private String campStatus;


}
