package com.xuyong.study.opentsdb;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.opentsdb.core.TSDB;

public class OpenTSDBWriter implements Runnable{
    private TSDB tsdb = null;

    public OpenTSDBWriter(Map<String, String> paramMap){
        super();
        System.out.println("get tsdb");
        OpenTSDB.setParamMap(paramMap);
        tsdb = OpenTSDB.getInstance().getTsdb();
        System.out.println("get tsdb success");
    }

	public void run() {
		Date now = new Date();
		Map<String,String> tagMap = new HashMap<String,String>();
		tagMap.put("test_tag","test");
		System.out.println("begin add point.....");
		tsdb.addPoint("xuyong.simpletest", now.getTime(), 100 * Math.random(), tagMap);
		System.out.println("end add point.....");
	}

}
