package com.xuyong.study.model;

import java.awt.Graphics;
import java.awt.Image;

import com.xuyong.study.util.ImageUtil;

public class Star {

	private int x = 0;
	private int y = 0;

	public void draw(Graphics g) {
		Image img = ImageUtil.getImage("images/sun.jpg");
		g.drawImage(img, x, y, null);
		x += 1;
		y += 1;
	}
	
}
