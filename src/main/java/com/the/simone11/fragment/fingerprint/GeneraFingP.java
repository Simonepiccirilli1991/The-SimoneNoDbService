package com.the.simone11.fragment.fingerprint;

import org.springframework.stereotype.Service;

import com.the.simone11.fragment.request.GeneraFingerprintRequest;

@Service
public class GeneraFingP {
	
	
	public String generaFingP(GeneraFingerprintRequest request) {
		
		String var1 = request.getNome();
		String vae2 = request.getCognome();
		String var3 = request.getComune();
		
		String response = replaceSt(var1)+replaceSt(vae2)+replaceSt(var3);
		
		return response;
		
	}
	
	
	public String replaceSt(String request) {
		
	String response =	request.replace("a", "3")
			.replace("e", "4")
			.replace("i", "5")
			.replace("o", "1")
			.replace("u", "2");
		
		
		return response;
	}

}
