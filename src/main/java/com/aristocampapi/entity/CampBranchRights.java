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
@Table(name="campbranchrights")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampBranchRights {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int campbranchId;
	//private int campcreationId;
	private int depoCode;
	private String branchStatus;
	

}
