package com.practo.movies.cms.models.response;

import java.io.Serializable;

public class SuccessResponseModel implements Serializable {
	private Integer statusCode;
	private String message;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
