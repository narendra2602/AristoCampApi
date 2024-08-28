package com.aristocampapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aristocampapi.entity.PatientCamp;

public interface PatientCampDao extends JpaRepository<PatientCamp, Integer>{

}
