package com.xuyong.study.jdependency;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

import org.vafer.jdependency.Clazz;
import org.vafer.jdependency.Clazzpath;

public class StormJarUtil {

	public static void main(String[] args) {
		URL resource = StormJarUtil.class.getClassLoader().getResource("vip.dataeye.dataeye-jobs.superbrand-uv-1.0-jar-with-dependencies.jar");
		File file = new File(resource.getPath());
		//File file = new File("D:\\sts_studyspace\\jdependency-study\\src\\main\\resources\\vip.dataeye.dataeye-jobs.superbrand-uv-1.0-jar-with-dependencies.jar");
		getJarVersion(file);
	}
	
	public static String getJarVersion(File jarFile) {
		System.out.println(jarFile.getParent() + "\\" +  getFileNameNoEx(jarFile.getName()));
		String version = "1.0";
		Clazzpath cp = new Clazzpath();
		try {
			cp.addClazzpathUnit(jarFile, jarFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Clazz> clazzSet = cp.getClazzes();
		for (Clazz clazz : clazzSet) {
			Set<Clazz> dependencies = clazz.getDependencies();
			for (Clazz dependency : dependencies) {
				String name = dependency.getName();
				if (name.startsWith("backtype.storm")) {
					System.out.println(clazz.getName() + " has import " + name);
					version = "0.9";
				}
			}
		}
		System.out.println(version);
		return version;
	}
	
	public static String getFileNameNoEx(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()))) {   
                return filename.substring(0, dot);   
            }   
        }   
        return filename;   
    }   

}
