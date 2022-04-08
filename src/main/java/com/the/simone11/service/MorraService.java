package com.the.simone11.service;



import org.springframework.stereotype.Service;

import com.the.simone11.error.exp.MorraExc;


@Service
public class MorraService {

	public String vincitore(String val1, String val2) throws MorraExc{
		
		String vinc ="";
		Controllo cont = controllo(val1, val2);
		if(!cont.isControllo())
			vinc=cont.getErrore();
		else {
			vinc= calcoloVinc(val1, val2);
		}
		return vinc;
		
	}

	public String calcoloVinc(String val1, String val2) throws MorraExc{

		String vincitore ="";
		try {
		val1.toLowerCase().trim();
		val2.toLowerCase().trim();
		}catch(Exception e) {
			throw new MorraExc();
		}
		switch (val1+"/"+val2) {

		case "sasso/forbice":
			vincitore =  "Giocatore 1 vince";
			break;

		case "forbice/carta":
			vincitore =  "Giocatore 1 vince";
			break;

		case "carta/sasso":
			vincitore =  "Giocatore 1 vince";
			break;

		case "sasso/sasso":
			vincitore =  "pareggio";
			break;

		case "carta/carta":
			vincitore =  "pareggio";
			break;

		case "forbice/forbice":
			vincitore =  "pareggio";
			break;

		case "forbice/sasso":
			vincitore = "Giocatore 2";
			break;

		case "sasso/carta":
			vincitore ="GIocatore 2";
			break;
		case "carta/forbice":
			vincitore = "Giocatore2";
			break;
		}

		return vincitore;
	}


	public Controllo controllo(String val1 , String val2) throws MorraExc{

		Controllo response = new Controllo();
		try {
		val1.trim();
		val2.trim();
		}catch(Exception e) {
			throw new MorraExc();
		}
		if(val1.equalsIgnoreCase("forbice") || val1.equalsIgnoreCase("carta") || val1.equalsIgnoreCase("sasso")) {
			if(val2.equalsIgnoreCase("forbice") || val2.equalsIgnoreCase("carta") || val2.equalsIgnoreCase("sasso")) {
				response.setControllo(true);
			}else {
				response.setErrore("giocatore 2 ha inserito dei valori non corretti: " + val2); 
				response.setControllo(false);
			}
		}else {
			response.setErrore("giocatore 1 ha inserito dei valori non corretti: " + val1); 
			response.setControllo(false);
		}
		return response;
	}

	public class Controllo{
		private boolean controllo;
		private String errore;

		public String getErrore() {
			return errore;
		}
		public void setErrore(String errore) {
			this.errore = errore;
		}
		public boolean isControllo() {
			return controllo;
		}
		public void setControllo(boolean controllo) {
			this.controllo = controllo;
		}



	}

}
