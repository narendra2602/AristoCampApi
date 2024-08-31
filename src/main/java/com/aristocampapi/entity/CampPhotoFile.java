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
@Table(name="campphotofile")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampPhotoFile {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int campeventId;
	private String fileName;
	private String fileType;
//	private Date addedOn;
	private int uploadedBy;
}
