package com.tcd.distributedsystems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcd.distributedsystems.entity.ADO;
import com.tcd.distributedsystems.repository.ADORepository;
import com.tcd.distributedsystems.service.ADOService;

@Service
public class ADOServiceImpl implements ADOService {
	
	@Autowired
	private ADORepository adoRepo;

	@Override
	public ADO saveADO(ADO ado) {
		return adoRepo.save(ado);
	}

}

