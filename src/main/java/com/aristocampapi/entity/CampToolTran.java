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
@Table(name="camptooltran")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampToolTran {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int camptooltranId;
	private int campeventId;
	private int camptoolId;
	private int qtyReceived;
	private int qtyIssued;
	private int createdBy;
}
