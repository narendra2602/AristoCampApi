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
public class DoctorCampRequest {
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
