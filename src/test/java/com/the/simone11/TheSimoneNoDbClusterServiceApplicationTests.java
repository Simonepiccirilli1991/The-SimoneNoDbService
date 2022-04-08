package com.the.simone11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import com.the.simone11.error.exp.FingerprintExc;
import com.the.simone11.error.exp.MorraExc;
import com.the.simone11.fragment.fingerprint.GeneraFingP;
import com.the.simone11.fragment.request.GeneraFingerprintRequest;
import com.the.simone11.service.FingerprintService;
import com.the.simone11.service.MorraService;
import com.the.simone11.service.MorraService.Controllo;

@SpringBootTest
@AutoConfigureMockMvc
class TheSimoneNoDbClusterServiceApplicationTests {
	
	@InjectMocks
	MorraService morraService;
	@InjectMocks
	FingerprintService fingerprintService;
	@Mock
	GeneraFingP generaFingP;
	@Mock
	GeneraFingerprintRequest fprequest;
	@Mock
	MorraExc morraexc;
	@Mock
	Controllo daoC;
	
	private static final String stringT1 = "sasso";

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void callFingerprint_thenOK() {
		
		fprequest.setCognome("ajeje");
		fprequest.setNome("brazof");
		fprequest.setComune("milazzo");
		String response = "ascafa";
		
		when(generaFingP.generaFingP(ArgumentMatchers.any(GeneraFingerprintRequest.class))).thenReturn(response);
		
		String response2 = fingerprintService.generaFingerprint(fprequest);
		
		assertThat(response2).isSameAs("ascafa");
	}
	
	@Test
	public void callFingerprint_thenKO() {
		
		when(generaFingP.generaFingP(ArgumentMatchers.any(GeneraFingerprintRequest.class))).thenThrow(FingerprintExc.class);


		Assertions.assertThrows(FingerprintExc.class, () -> fingerprintService.generaFingerprint(fprequest));

	}
	
	@Test
	public void morraCinese_thenOK() {
		
		String val1 = "sasso";
		String val2 = "forbice";
		
		String response = " giocatore 1 vince";
		
		//when(morraService.controllo(ArgumentMatchers.any(String.class), ArgumentMatchers.any(String.class))).thenReturn(daoC);
		
		when(morraService.vincitore((val1), val2)).thenReturn(response);
				
		String response2 = morraService.vincitore(val1, val2);
		
		assertThat(response2).isSameAs("Giocatore 1 vince");
		
	}
//	@Test
//	public void morraCineseTest_thenKO() {
//		
////		when(morraService.vincitore(ArgumentMatchers.any(String.class),ArgumentMatchers.any(String.class))).thenThrow(MorraExc.class);
//
//	//	when(morraService.controllo(ArgumentMatchers.any(String.class),ArgumentMatchers.any(String.class))).thenThrow(MorraExc.class);
//		
//		when(morraService.calcoloVinc(ArgumentMatchers.any(String.class),ArgumentMatchers.any(String.class))).thenThrow(MorraExc.class);
////		
//		morraService.vincitore("ciao", "forza");
//		Assertions.assertThrows(MorraExc.class, () -> morraService.calcoloVinc("ciao","forza"));
//
//		
//	}

}
