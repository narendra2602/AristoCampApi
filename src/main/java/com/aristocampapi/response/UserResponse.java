package com.aristocampapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
	private int loginId;
	private String fname;
	private String loginName;
	private String userType;
	private int utype;
	private String lastLoginDate;
	private String userStatus;
	
}
