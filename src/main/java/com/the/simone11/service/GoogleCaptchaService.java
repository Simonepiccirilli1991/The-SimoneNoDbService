package com.the.simone11.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone11.error.exp.CaptchaExc;
import com.the.simone11.fragment.request.GoogleCaptchaRequest;
import com.the.simone11.fragment.response.CaptchaResponse;
import com.the.simone11.fragment.response.GoogleCaptchaResponse;

@Service
public class GoogleCaptchaService {
	
	
	RestTemplate restT = new RestTemplate();
	
	public CaptchaResponse controlloCaptcha(GoogleCaptchaRequest request) throws CaptchaExc{
		
		GoogleCaptchaResponse iResponse = new GoogleCaptchaResponse();
		CaptchaResponse response = new CaptchaResponse();
		String uri = "";
		try {
			iResponse = restT.postForObject(uri, request, GoogleCaptchaResponse.class);
		}catch(Exception e) {
			throw new CaptchaExc();
		}
		
		if(!iResponse.isSuccess())
			response.setError(true);
			response.setErrDesc("captcha non corretto");
			response.setErrId("1");
			
		return response;
	}

}
