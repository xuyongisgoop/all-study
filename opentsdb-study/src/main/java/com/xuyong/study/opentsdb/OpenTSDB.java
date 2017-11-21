package com.xuyong.study.opentsdb;

import java.io.IOException;
import java.util.Map;

import net.opentsdb.core.TSDB;
import net.opentsdb.utils.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenTSDB {
  private static final Logger LOG = LoggerFactory.getLogger(OpenTSDB.class);
  private TSDB tsdb = null;
  private static OpenTSDB openTSDB = null;
  private static Map<String,String> paramMap = null;

  private OpenTSDB(){}

  public static OpenTSDB getInstance(){
    if(openTSDB==null||openTSDB.getTsdb()==null){
      synchronized (OpenTSDB.class){
        if(openTSDB==null||openTSDB.getTsdb()==null){
          openTSDB = new OpenTSDB();
          LOG.info("openTSDB paramMap is :{}",paramMap);
          if(paramMap!=null){
            openTSDB.init(paramMap);
          }else {
            LOG.error("openTSDB address is null");
          }
        }
      }
    }
    return openTSDB;
  }

  private void init(Map<String,String> paramMap)  {
    Config config = null;
    try {
      config = new Config(false);
    } catch (IOException e) {
      LOG.error("openTSDB init config error.", e);
    }
    for(String key : paramMap.keySet()){
      config.overrideConfig(key, paramMap.get(key));
    }

    config.setAutoMetric(true);
    config.setFixDuplicates(true);
    tsdb=new TSDB(config);
  }

  public static void setParamMap(Map<String, String> paramMap) {
    OpenTSDB.paramMap = paramMap;
  }

  public TSDB getTsdb() {
    return tsdb;
  }

  public void shutdown(){
    if(tsdb!=null){
      tsdb.shutdown();
      tsdb = null;
      openTSDB = null;
    }
  }
}
