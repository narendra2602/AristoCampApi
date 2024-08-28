package com.aristocampapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampToolMasterDao;
import com.aristocampapi.dao.CampToolTranDao;
import com.aristocampapi.dto.CampToolTranDto;
import com.aristocampapi.entity.CampToolMaster;
import com.aristocampapi.entity.CampToolTran;
import com.aristocampapi.request.CampToolMasterRequest;
import com.aristocampapi.request.CampToolTranRequest;
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
			res.setToolName(data.getTool_name());
			res.setQtyReceived(data.getQty_received());
			res.setQtyIssued(data.getQty_issued());
			responseList.add(res);
		});
		
		return responseList;
	}
	@Override
	public CampToolTran saveCampToolTran(CampToolTranRequest camptooltranreq) {
		CampToolTran camptooltran=new CampToolTran();
		camptooltran.setCamptooltranId(camptooltranreq.getCamptooltranId());
		camptooltran.setCampeventId(camptooltranreq.getCampeventId());
		camptooltran.setCamptoolId(camptooltranreq.getCamptoolId());
		camptooltran.setQtyReceived(camptooltranreq.getQtyReceived());
		camptooltran.setQtyIssued(camptooltranreq.getQtyIssued());
		camptooltran.setCreatedBy(camptooltranreq.getCreatedBy());

		return campToolTranDao.save(camptooltran);
		
		
	}

}
