package com.xuyong.study.opentsdb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OpenTSDBTest {
	public static void main(String[] args) {
		Map<String, String> openTsdbMap = new HashMap<String, String>();
		openTsdbMap.put("tsd.storage.hbase.zk_quorum", "10.199.196.41:2183,10.199.196.42:2183,10.199.196.43:2183");
		openTsdbMap.put("tsd.storage.hbase.zk_basedir", "/hbase");
		openTsdbMap.put("tsd.storage.hbase.data_table", "vrc:tsdb");
		openTsdbMap.put("tsd.storage.hbase.uid_table", "vrc:tsdb-uid");
		openTsdbMap.put("tsd.storage.hbase.tree_table", "vrc:tsdb-tree");
		openTsdbMap.put("tsd.storage.hbase.meta_table", "vrc:tsdb-meta");
		//Thread openTSDBThread = new Thread(new OpenTSDBWriter(openTsdbMap));
		//openTSDBThread.start();
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		service.scheduleAtFixedRate(new OpenTSDBWriter(openTsdbMap), 1, 1, TimeUnit.MINUTES);
	}
}
