package com.purchase.utils;

public class ApiResult {
//	public static final int OK=200;
//	public static final int validateError=500;
	
	
	
	
	//private int code;
	private boolean success;
	private String message;
	private Object data;
	
	
	
	
	
	public ApiResult(boolean success,String message) {
		
		this.success = success;
		this.message=message;
	}
	

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public ApiResult setMessage(String message) {
		this.message = message;
		return this;
	}
	public Object getData() {
		return data;
	}
	public ApiResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	
	
	
}
