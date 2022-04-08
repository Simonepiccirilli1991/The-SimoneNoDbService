package com.the.simone11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.the.simone11.fragment.request.EmailRequest;

@Service
public class InvioOtpMailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public String invioOtsMail(EmailRequest request) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getEmail());

        msg.setSubject("Testing OTP with Spring Boot");
        msg.setText("Hello "+request.getUsername()+" this is your OTP: "+request.getOtp());

        javaMailSender.send(msg);
        return "Ots inviato con successo";
    }
}
