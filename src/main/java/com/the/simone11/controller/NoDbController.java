package com.the.simone11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone11.error.exp.CaptchaExc;
import com.the.simone11.error.exp.CfExc;
import com.the.simone11.error.exp.MorraExc;
import com.the.simone11.fragment.request.EmailRequest;
import com.the.simone11.fragment.request.GoogleCaptchaRequest;
import com.the.simone11.fragment.response.CaptchaResponse;
import com.the.simone11.fragment.response.GoogleCaptchaResponse;
import com.the.simone11.model.request.CfRequest;
import com.the.simone11.service.CalcoloCfService;
import com.the.simone11.service.GoogleCaptchaService;
import com.the.simone11.service.InvioOtpMailService;
import com.the.simone11.service.MorraService;

@RestController
@RequestMapping("nodb")
public class NoDbController {
	
	@Autowired
	private MorraService morraService;
	@Autowired
	private CalcoloCfService cfService;
	@Autowired
	private GoogleCaptchaService googleS;
	@Autowired
	private InvioOtpMailService mailService;
	
	ApplicationContext context = new AnnotationConfigApplicationContext(MorraService.class);
	
	@RequestMapping(path = "/morra/{val1}/{val2}", method = RequestMethod.GET)
	public String decretaVinc(@PathVariable String val1,@PathVariable String val2) throws MorraExc{
		if(val1 == null || val2 == null) {
			throw new MorraExc();
		}
			
		return morraService.vincitore(val1, val2);
	}
	
	@PostMapping("calcolacf")
	public String calcolaCf(@RequestBody CfRequest request) throws CfExc{
		if(request == null) {
			throw new CfExc();
		}
		return cfService.calcoloCf(request);
		
	}
	
	@PostMapping("/v1/google/cap")
	public CaptchaResponse checkCap(@RequestBody GoogleCaptchaRequest request) throws CaptchaExc{
		
		return googleS.controlloCaptcha(request);
	}
	// invio mail generalizzato con gestione ad action
	
	@PostMapping("/mail")
	public String invioMail(@RequestBody EmailRequest request) {
		
		return mailService.invioOtsMail(request);
	}

}
