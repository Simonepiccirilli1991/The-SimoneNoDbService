package com.the.simone11.error.model;

public class BaseError {
	
	private String errMsg;
	private String errId;
	private String errDesc;
	private boolean error;
	
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrId() {
		return errId;
	}
	public void setErrId(String errId) {
		this.errId = errId;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	

}
