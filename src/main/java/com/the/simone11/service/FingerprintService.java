package com.the.simone11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.the.simone11.fragment.fingerprint.GeneraFingP;
import com.the.simone11.fragment.request.GeneraFingerprintRequest;

@Service
public class FingerprintService {
	
	@Autowired
	private GeneraFingP generaFing;
	
	RestTemplate restTemplate = new RestTemplate();
	
	public String generaFingerprint(@RequestBody GeneraFingerprintRequest request) {
		
		String response = generaFing.generaFingP(request);
		
		return response;
	}
	
	public boolean CheckFingerprint(String fingeprint) {
		
		
		//TODO finire di implementare , scegliere tipo response se piu complessa o meno
		// in caso fare altro metodo per match?
		String fooResourceUrl
		= "http://localhost:8083/db/checkfgp";
		 boolean  response
		= restTemplate.postForObject(fooResourceUrl , fingeprint, boolean.class);

		return response;

	}

}
