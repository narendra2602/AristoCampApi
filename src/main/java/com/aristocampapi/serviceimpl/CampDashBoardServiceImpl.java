package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampDashBoardDao;
import com.aristocampapi.dto.CampDashBoardPanelDto;
import com.aristocampapi.dto.CampDashBoardRecentCampDto;
import com.aristocampapi.dto.CampDashboardCalendarDto;
import com.aristocampapi.dto.CampDashBoardNewCampDto;
import com.aristocampapi.request.CampDashboardRequest;
import com.aristocampapi.response.CampDashBoardCalendarResponse;
import com.aristocampapi.response.CampDashBoardNewCampResponse;
import com.aristocampapi.response.CampDashBoardPanelResponse;
import com.aristocampapi.response.CampDashBoardRecentCampResponse;
import com.aristocampapi.service.CampDashBoardService;
@Service
public class CampDashBoardServiceImpl implements CampDashBoardService {

	@Autowired
	CampDashBoardDao campDashBoardDao;
	@Override
	public List<CampDashBoardPanelResponse> getDashBoardPanelData(CampDashboardRequest campDashboardRequest) {
		
		List<CampDashBoardPanelDto> campDashBoardPanelList=campDashBoardDao.getDashBoardPanelData(campDashboardRequest.getMktYear(),campDashboardRequest.getLoginId(),campDashboardRequest.getUserType()); 
		int size=0;
		if(campDashBoardPanelList!=null)
			size=campDashBoardPanelList.size();
		
		List<CampDashBoardPanelResponse> responseList= new ArrayList<CampDashBoardPanelResponse>();
		// TODO Auto-generated method stub
		
		campDashBoardPanelList.forEach(data->{
			CampDashBoardPanelResponse res=new CampDashBoardPanelResponse();
			res.setCampDescription(data.getCamp());
			res.setCampCount(data.getVal());
			responseList.add(res);
		});
		
		return responseList;
	}

	@Override
	public List<CampDashBoardCalendarResponse> getDashBoardCalendarData(CampDashboardRequest campDashboardRequest) {
		// TODO Auto-generated method stub
		
		List<CampDashboardCalendarDto> CampDashboardCalendarList = campDashBoardDao.getDashBoardCalendarData(campDashboardRequest.getMktYear(),
				campDashboardRequest.getLoginId(),campDashboardRequest.getUserType(),campDashboardRequest.getMnth());
		
		
		List<CampDashBoardCalendarResponse> responseList= new ArrayList<CampDashBoardCalendarResponse>();
		// TODO Auto-generated method stub
		
		CampDashboardCalendarList.forEach(data->{
			CampDashBoardCalendarResponse res=new CampDashBoardCalendarResponse();
			res.setCampeventId(data.getCampevent_id());
			res.setCampDate(data.getCamp_date());
			res.setCampName(data.getCamp_name());
			res.setCampLocation(data.getLocation_name());
			responseList.add(res);
		});
		
		return responseList;
	}

	@Override
	public List<CampDashBoardNewCampResponse> getDashBoardNewCamps(CampDashboardRequest campDashboardRequest) {
		List<CampDashBoardNewCampDto> CampDashboardNewCampList = campDashBoardDao.getDashBoardNewCamps(campDashboardRequest.getMktYear(),campDashboardRequest.getLoginId(),campDashboardRequest.getUserType());
		
		
		List<CampDashBoardNewCampResponse> responseList= new ArrayList<CampDashBoardNewCampResponse>();
		// TODO Auto-generated method stub
		
		CampDashboardNewCampList.forEach(data->{
			CampDashBoardNewCampResponse res=new CampDashBoardNewCampResponse();
			res.setCampcreationId(data.getCampcreation_id());
			res.setDepoCode(data.getDepo_code());
			res.setCampDate(data.getDate_of_execution());
			res.setCampName(data.getCamp_name());
			res.setCampLocation(data.getLocation_name());
			res.setLine2Manager(data.getLine2emp_code());
			res.setLine3Manager(data.getLine3emp_code());
			
			responseList.add(res);
		});
		
		return responseList;
	}

	@Override
	public List<CampDashBoardRecentCampResponse> getDashBoardRecentCamps(CampDashboardRequest campDashboardRequest) {
		List<CampDashBoardRecentCampDto> CampDashboardRecentCampList = campDashBoardDao.getDashBoardRecentCamps(campDashboardRequest.getMktYear(),campDashboardRequest.getLoginId(),campDashboardRequest.getUserType());
		
		
		List<CampDashBoardRecentCampResponse> responseList= new ArrayList<CampDashBoardRecentCampResponse>();
		// TODO Auto-generated method stub
		
		CampDashboardRecentCampList.forEach(data->{
			CampDashBoardRecentCampResponse res=new CampDashBoardRecentCampResponse();
			res.setCampeventId(data.getCampcreation_id());
			res.setCampDate(data.getCamp_date());
			res.setCampName(data.getCamp_name());
			res.setCampLocation(data.getLocation_name());
			res.setLine1Manager(data.getLine1_manager());
			res.setApprovedStatus(data.getApproved_status());
			
			responseList.add(res);
		});
		
		return responseList;
	}

}
