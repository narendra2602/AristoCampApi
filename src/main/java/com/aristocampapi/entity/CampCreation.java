package com.aristocampapi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
@Table(name="campcreation")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CampCreation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int campId;
	private Date dateOfPlanning;
	private Date dateOfExecution;
	private int mktYear;
	private int createdBy;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="campcreation_id", referencedColumnName="id")
	List<CampBranchRights> branch = new ArrayList<>();
}
