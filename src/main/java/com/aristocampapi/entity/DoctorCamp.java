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
@Table(name="doctor_camp")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DoctorCamp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int pcode;
	private String name;
	private String qualification;
	private String registrationNumber;
	private String address;
	private String city;
	private int pinCode;
	private long mobileNo;
	private String emailId;
	
	

}
