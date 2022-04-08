package com.the.simone11.controller;

import java.lang.module.FindException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone11.error.exp.FingCheckExp;
import com.the.simone11.error.exp.FingerprintExc;
import com.the.simone11.fragment.request.GeneraFingerprintRequest;
import com.the.simone11.service.FingerprintService;

@RestController
@RequestMapping("fingerprint")
public class FingerprintController {
	
	@Autowired
	private FingerprintService fngServ;
	
	@PostMapping("genera")
	public String generaFing(@RequestBody GeneraFingerprintRequest request) throws FingerprintExc{
		
		return fngServ.generaFingerprint(request);
	}
	
	@PostMapping("checkExist")
	public String checkFingerprintEx(@RequestBody String fingerprint) throws FingCheckExp{
		
	boolean respB = fngServ.CheckFingerprint(fingerprint);
	String response = "";
	if(respB) {
		response = "Utente gia registrato, fp esistente";
	}else if(respB == false){
		response = "Utente non registrato, primo accesso consentito";
	}else {
		throw new FingCheckExp();
	}
	return response;
	

}
}
