package com.the.simone11.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.the.simone11.error.exp.CaptchaExc;
import com.the.simone11.error.exp.CfExc;
import com.the.simone11.error.exp.FingCheckExp;
import com.the.simone11.error.exp.FingerprintExc;
import com.the.simone11.error.exp.MorraExc;
import com.the.simone11.error.model.BaseError;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(MorraExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(MorraExc ex) 
	{

		BaseError errorResponse = new BaseError();
	    errorResponse.setErrDesc("valori non inseriti");
	    errorResponse.setErrMsg("inserire i valori per giocare");
	    errorResponse.setErrId("1");
	    
	    return errorResponse;
	}
	
	@ExceptionHandler(CfExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(CfExc ex) 
	{

		BaseError errorResponse = new BaseError();
	    errorResponse.setErrDesc("bad request");
	    errorResponse.setErrMsg("campi non completi");
	    errorResponse.setErrId("1");
	    
	    return errorResponse;
	}
	
	@ExceptionHandler(FingerprintExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(FingerprintExc ex) 
	{

		BaseError errorResponse = new BaseError();
	    errorResponse.setErrDesc("fingerprint-generate error");
	    errorResponse.setErrMsg("errore durante generazione fingerprint");
	    errorResponse.setErrId("fngp-01");
	    
	    return errorResponse;
	}
	
	@ExceptionHandler(FingCheckExp.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(FingCheckExp ex) 
	{

		BaseError errorResponse = new BaseError();
	    errorResponse.setErrDesc("fingerprint-checkExt error");
	    errorResponse.setErrMsg("errore durante checkExist fingerprint");
	    errorResponse.setErrId("fngp-02");
	    
	    return errorResponse;
	}
	
	@ExceptionHandler(CaptchaExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(CaptchaExc ex) 
	{

		BaseError errorResponse = new BaseError();
	    errorResponse.setErrDesc("google-captcha error on call");
	    errorResponse.setErrMsg("errore durante la chiamata a  google");
	    errorResponse.setErrId("02");
	    
	    return errorResponse;
	}

}
