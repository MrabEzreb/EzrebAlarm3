package com.ezrebclan.ezrebalarm.xml.windows.components.attributes;

import javax.swing.SwingConstants;

public enum VerticalAlignment {

	TOP(SwingConstants.TOP),
	CENTER(SwingConstants.CENTER),
	BOTTOM(SwingConstants.BOTTOM);
	
	private int value;
	
	private VerticalAlignment(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
