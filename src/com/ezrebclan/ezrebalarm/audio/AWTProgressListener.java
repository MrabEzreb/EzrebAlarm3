package com.ezrebclan.ezrebalarm.audio;

import javazoom.jl.converter.Converter.ProgressListener;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.Obuffer;

public class AWTProgressListener implements ProgressListener {
	
	public AudioConversionProgressDisplay acpd;
	int total;
	
	public AWTProgressListener(AudioConversionProgressDisplay acpd, int total) {
		this.acpd = acpd;
		this.total = total;
	}

	@Override
	public void converterUpdate(int updateID, int param1, int param2) {
		if(updateID == UPDATE_FRAME_COUNT) {
		}
	}

	@Override
	public void parsedFrame(int frameNo, Header header) {
	}

	@Override
	public void readFrame(int frameNo, Header header) {
	}

	@Override
	public void decodedFrame(int frameNo, Header header, Obuffer o) {
	}

	@Override
	public boolean converterException(Throwable t) {
		return false;
	}

}
