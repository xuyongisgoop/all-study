package com.xuyong.study.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MyFrame extends Frame{

	public void launchFrame() {
		setSize(500, 500);
		setLocation(100,200);
		setVisible(true);
		
		new PaintThread().start();  //启动重画线程
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	class PaintThread extends Thread {
		@Override
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(40); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
	}
}
