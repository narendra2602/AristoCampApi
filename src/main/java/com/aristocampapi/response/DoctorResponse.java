package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DoctorResponse {
	
	private String name;
	private String qualification;
	private String registrationNumber;
	private String address;
	private String city;
	private int pinCode;
	private long mobileNo;
	private String emailId;

}
