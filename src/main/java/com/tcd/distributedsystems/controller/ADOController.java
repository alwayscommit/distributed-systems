package com.tcd.distributedsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.distributedsystems.entity.ADO;
import com.tcd.distributedsystems.entity.Athlete;
import com.tcd.distributedsystems.service.ADOService;

/*Used only by the administration*/
@RestController
@RequestMapping(path = "/ado")
public class ADOController {

	@Autowired
	private ADOService adoService;

	@PostMapping
	public ADO saveADO(@RequestBody ADO ado) {
		return adoService.saveADO(ado);
	}

}
