package com.xuyong.study.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static Image getImage(String path) {
		URL resource = ImageUtil.class.getClassLoader().getResource(path);
		BufferedImage read = null;
		try {
			read = ImageIO.read(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read;
	}
	
}
