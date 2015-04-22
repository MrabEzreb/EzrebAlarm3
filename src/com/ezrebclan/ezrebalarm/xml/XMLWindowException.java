package com.ezrebclan.ezrebalarm.xml;

public class XMLWindowException extends Exception {

	private String error;
	public XMLWindowException(String error) {
		this.error = error;
	}
	@Override
	public String getMessage() {
		return error;
	}
}
