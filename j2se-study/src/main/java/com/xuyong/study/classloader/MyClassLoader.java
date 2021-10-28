package com.xuyong.study.classloader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	
	@Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> result = null;
		try {
			String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
			InputStream is = getClass().getResourceAsStream(fileName);
			if (is == null) {
				return super.loadClass(name);
			}
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			result = defineClass(name, bytes, 0, bytes.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Demo demo = new Demo();
		demo.inc();
		return result;
    }
    	
}
