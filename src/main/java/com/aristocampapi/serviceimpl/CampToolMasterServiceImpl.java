package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampToolMasterDao;
import com.aristocampapi.dao.CampToolTranDao;
import com.aristocampapi.dto.CampToolMasterDto;
import com.aristocampapi.dto.CampToolTranDto;
import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.entity.CampToolTran;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
import com.aristocampapi.response.CampToolResponse;
import com.aristocampapi.response.CampToolTranResponse;
import com.aristocampapi.service.CampToolMasterService;

@Service
public class CampToolMasterServiceImpl implements CampToolMasterService{

	
	@Autowired
	private CampToolMasterDao campToolMasterDao;
	
	@Autowired
	private CampToolTranDao campToolTranDao;
	
	@Override
	public CampToolMaster saveCampToolMaster(CampToolMasterRequest camptoolmasterreq) {
		// TODO Auto-generated method stub
		CampToolMaster camptoolmaster=new CampToolMaster();
		camptoolmaster.setCamptoolId(camptoolmasterreq.getCamptoolId());
		camptoolmaster.setCampId(camptoolmasterreq.getCampId());
		camptoolmaster.setToolName(camptoolmasterreq.getToolName());
		camptoolmaster.setToolType(camptoolmasterreq.getToolType());
		

		return campToolMasterDao.save(camptoolmaster);
	}
	@Override
	public List<CampToolTranResponse> getToolTranData(int campeventId) {
		List<CampToolTranDto> campToolList=campToolTranDao.getCampToolDetail(campeventId); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampToolTranResponse> responseList= new ArrayList<CampToolTranResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampToolTranResponse res=new CampToolTranResponse();
			res.setCamptooltranId(data.getCamptool_id());
			res.setCamptoolId(data.getCamptool_id());
			res.setToolName(data.getTool_name());
			res.setQtyReceived(data.getQty_received());
			res.setQtyIssued(data.getQty_issued());
			res.setCreatedBy(data.getCreated_by());
			responseList.add(res);
		});
		
		return responseList;
	}
	@Override
	public CampToolTranRequest saveCampToolTran(List<CampToolTranRequest> camptooltranList) {
		
		List<CampToolTran> dataList= new ArrayList<CampToolTran>();
		// TODO Auto-generated method stub
		CampToolTran camptooltranSave=new CampToolTran();
		camptooltranList.forEach(data->{
			CampToolTran camptooltran=new CampToolTran();
			camptooltran.setCamptooltranId(data.getCamptooltranId());
			camptooltran.setCampeventId(data.getCampeventId());
			camptooltran.setCamptoolId(data.getCamptoolId());
			camptooltran.setQtyReceived(data.getQtyReceived());
			camptooltran.setQtyIssued(data.getQtyIssued());
			camptooltran.setCreatedBy(data.getCreatedBy());
			campToolTranDao.save(camptooltran);
			//dataList.add(camptooltran);
		});
		
		    
		
		//List<CampToolTran> camptooltran = campToolTranDao.saveAll(dataList);
				
		return camptooltranList.get(0);
		
		
	}
	@Override
	public List<CampToolResponse> getToolList(int userType) {
		List<CampToolMasterDto> campToolList=campToolTranDao.getCampToolList(userType); 
		int size=0;
		
		System.out.println("size of list "+size);
		if(campToolList!=null)
			size=campToolList.size();
		
		List<CampToolResponse> responseList= new ArrayList<CampToolResponse>();
		// TODO Auto-generated method stub
		
		campToolList.forEach(data->{
			CampToolResponse res=new CampToolResponse();
			res.setCamptoolId(data.getCamptool_id());
			res.setCampId(data.getCamp_id());
			res.setCampName(data.getCamp_name());
			res.setToolName(data.getTool_name());
			res.setToolType(data.getTool_type());
			responseList.add(res);
		});
		
		return responseList;
	}

}
