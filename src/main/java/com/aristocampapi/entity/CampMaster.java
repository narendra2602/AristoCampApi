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
@Table(name="campmaster")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int campId;
	private int divCode;
	private String campName;

}
