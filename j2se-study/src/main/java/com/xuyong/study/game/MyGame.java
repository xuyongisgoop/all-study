package com.xuyong.study.game;

import java.awt.Graphics;

import com.xuyong.study.model.Star;
import com.xuyong.study.util.MyFrame;

@SuppressWarnings("serial")
public class MyGame extends MyFrame {
	Star star = new Star();
	
	public static void main(String[] args) {
		MyGame my = new MyGame();
		my.launchFrame();
	}

	@Override
	public void paint(Graphics g) {
		star.draw(g);
	}

}
