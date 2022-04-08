package com.the.simone11.fragment.response;

public class BaseResponse {
	
	private String errId;
	private boolean error = false;
	private String errDesc;
	
	public String getErrId() {
		return errId;
	}
	public void setErrId(String errId) {
		this.errId = errId;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	

}
