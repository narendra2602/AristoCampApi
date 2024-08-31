package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampPhotoFileDto;
import com.aristocampapi.entity.CampPhotoFile;

public interface CampPhotoFileDao extends JpaRepository<CampPhotoFile, Integer>{

	
	@Query(value="CALL getCampPhotoFile(:campEventId);", nativeQuery=true)
	List<CampPhotoFileDto> getCampPhotoFile(@Param("campEventId") int campEventId);
}
