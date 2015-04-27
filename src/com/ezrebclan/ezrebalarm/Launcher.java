package com.ezrebclan.ezrebalarm;

public class Launcher {

	static Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			boolean t = true;
			while(t) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					t = false;
				}
			}
		}
	});
	public static void main(String[] args) {
		Main.start(args);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			
		}
		Main.stop();
	}
	public static void stop() {
		thread.interrupt();
	}

}
