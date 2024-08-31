package com.aristocampapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristocampapi.dto.ComboDataDto;
import com.aristocampapi.dto.MktDataDto;

public interface ComboDataDao extends JpaRepository<MktDataDto, Integer> {

	
	@Query(value = "select div_code code,div_name name from crm.divmast where div_code in (select div_code from userdiv where user_id=:userId and user_status='Y' order by div_code) ", nativeQuery = true)
	List<ComboDataDto> getDivList(@Param("userId") int userId);

	
	@Query(value = "select depo_code code,depo_name name from aristo_web.branch_comp order by depo_name ", nativeQuery = true)
	List<ComboDataDto> getBranchList();

//	@Query(value = "select camp_id code,camp_name name from campmaster where div_code in (select div_code from userdiv where user_id=:userId and user_status='Y' order by div_code) ", nativeQuery = true)
//	List<ComboDataDto> getCampList(@Param("userId") int userId);

	
	@Query(value = "select camp_id code,camp_name name from campmaster where div_code=:divCode ", nativeQuery = true)
	List<ComboDataDto> getCampList(@Param("divCode") int divCode);

}
