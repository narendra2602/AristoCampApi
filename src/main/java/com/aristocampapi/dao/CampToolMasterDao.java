package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampToolTranDto;
import com.aristocampapi.entity.CampToolMaster;

public interface CampToolMasterDao extends JpaRepository<CampToolMaster, Integer>{

	

	
}
