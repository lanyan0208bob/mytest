package com.lanyan.dto;

public class ResponDTO<T> {

	private String code;
	private String message;
	private T data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResponDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ResponDTO() {
	}
}
