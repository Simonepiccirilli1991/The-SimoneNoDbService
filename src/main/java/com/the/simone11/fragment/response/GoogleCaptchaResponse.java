package com.the.simone11.fragment.response;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleCaptchaResponse {
	
	private String hostname;
	private boolean success;
	@JsonProperty("challenge_ts")
	private Timestamp challengeTs;
	@JsonProperty("error-codes")
	private String[] error;
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Timestamp getChallengeTs() {
		return challengeTs;
	}
	public void setChallengeTs(Timestamp challengeTs) {
		this.challengeTs = challengeTs;
	}
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	
	

}
