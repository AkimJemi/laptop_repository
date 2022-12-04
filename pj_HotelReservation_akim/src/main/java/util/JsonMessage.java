package com.sinnotech.hotel.util;

public class JsonMessage {

	private String id;
	private String name;
	private boolean result;
	private String message;
	

	/**
	 * @param id
	 * @param name
	 * @param result
	 * @param message
	 */
	public JsonMessage(String id, String name, boolean result, String message) {
		this.id = id;
		this.name = name;
		this.result = result;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
