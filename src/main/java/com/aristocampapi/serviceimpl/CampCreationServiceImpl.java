package com.aristocampapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.CampCreationDao;
import com.aristocampapi.entity.CampCreation;
import com.aristocampapi.service.CampCreationService;

@Service
public class CampCreationServiceImpl implements CampCreationService{

	
	@Autowired
	private CampCreationDao campCreationDao;
	@Override
	public CampCreation saveCampCreation(CampCreation campCreation) {
		// TODO Auto-generated method stub
		return campCreationDao.save(campCreation);
	}

}
