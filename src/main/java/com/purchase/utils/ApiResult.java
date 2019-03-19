package com.purchase.utils;

public class ApiResult {
	public static final int OK=200;
	
	
	
	
	
	private int code;
	private boolean success;
	private String message;
	private Object data;
	
	
	
	
	
	public ApiResult(int code, boolean success) {
		this.code = code;
		this.success = success;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
