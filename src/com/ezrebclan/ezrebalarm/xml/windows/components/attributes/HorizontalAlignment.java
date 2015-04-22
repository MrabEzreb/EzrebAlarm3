package com.ezrebclan.ezrebalarm.xml.windows.components.attributes;

import javax.swing.SwingConstants;

public enum HorizontalAlignment {

	LEFT(SwingConstants.LEFT),
	CENTER(SwingConstants.CENTER),
	RIGHT(SwingConstants.RIGHT),
	LEADING(SwingConstants.LEADING),
	TRAILING(SwingConstants.TRAILING);
	
	private int value;
	
	private HorizontalAlignment(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
