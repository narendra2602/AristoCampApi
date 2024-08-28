package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.CampApprovalStatusDto;
import com.aristocampapi.entity.CampTran;

public interface CampApprovalDao extends JpaRepository<CampTran, Integer> {

	@Query(value="CALL CampApprovalStatus(:myear,:campevent_id);", nativeQuery=true)
	List<CampApprovalStatusDto> getCampApproval(@Param("myear") int myear,@Param("campevent_id") int campevent_id);

}
