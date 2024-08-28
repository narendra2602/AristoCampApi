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
@Table(name="patient_camp")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PatientCamp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int camppatientId;
	private int campeventId;
	private String patientGender;
	private int patientAge;
	private String patientReading;
	private int createdBy;
}
