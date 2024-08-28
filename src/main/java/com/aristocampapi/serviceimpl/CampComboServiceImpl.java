package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.ComboDataDao;
import com.aristocampapi.dto.ComboDataDto;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.CampComboDataResponse;
import com.aristocampapi.service.CampComboService;

@Service
public class CampComboServiceImpl implements CampComboService{

	@Autowired
	private ComboDataDao comboDataDao; 

	
	@Override
	public ApiResponse<CampComboDataResponse> getDivisionList(int loginId) {
		List<ComboDataDto> dataList=comboDataDao.getDivList(loginId);
		List<CampComboDataResponse> divlist = getResponseData(dataList);
		int size=dataList.size();
		ApiResponse<CampComboDataResponse> apiResponse = new ApiResponse<>("Division",size,divlist);
		return apiResponse;
	}

	
	private List<CampComboDataResponse> getResponseData(List<ComboDataDto> dataList)
	{
		List<CampComboDataResponse> saleList = new ArrayList<CampComboDataResponse>();
		int size = dataList.size();
		
		CampComboDataResponse response=null;
		
		
		for(int i=0; i<size;i++)
		{

			ComboDataDto data = dataList.get(i);
			response= new CampComboDataResponse();
			response.setName(data.getName());
			response.setValue(data.getCode());
			saleList.add(response);
		}
		return saleList;

	}


	@Override
	public ApiResponse<CampComboDataResponse> getCampList(int loginId) {
		List<ComboDataDto> dataList=comboDataDao.getCampList(loginId);
		List<CampComboDataResponse> camplist = getResponseData(dataList);
		int size=dataList.size();
		ApiResponse<CampComboDataResponse> apiResponse = new ApiResponse<>("Camp",size,camplist);
		return apiResponse;

	}


	@Override
	public ApiResponse<CampComboDataResponse> getBranchList(int loginId) {
		List<ComboDataDto> dataList=comboDataDao.getBranchList(loginId);
		List<CampComboDataResponse> branchlist = getResponseData(dataList);
		int size=dataList.size();
		ApiResponse<CampComboDataResponse> apiResponse = new ApiResponse<>("Branch",size,branchlist);
		return apiResponse;
	}

}
