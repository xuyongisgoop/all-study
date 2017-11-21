package com.vip.storm.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	public static Properties load(String fileName) throws IOException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("storm_portal_config.properties"));
		}
		return prop;
	}

	public static Properties readFile(String filePath) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return prop;
	}
}