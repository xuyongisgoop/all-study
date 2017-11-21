package com.xuyong.study.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by howard.li on 2016/4/27.
 */
public class PartitionGetter {

    public static final Logger LOG = LoggerFactory.getLogger(PartitionGetter.class);

    private String _zkPath;
    private String _topic;
    private CuratorFramework _curator;

    private static final String DEFAULT_ZK_PATH = "/brokers";

    public PartitionGetter(String topic,String zkStr){
        this(topic,zkStr,DEFAULT_ZK_PATH);
    }

    public PartitionGetter(String topic,String zkStr,String zkPath){
        _zkPath = zkPath;
        _topic = topic;
        try {
            _curator = CuratorFrameworkFactory.newClient(
                    zkStr,
                    20000,//Utils.getInt(conf.get(Config.STORM_ZOOKEEPER_SESSION_TIMEOUT)),
                    15000,//Utils.getInt(conf.get(Config.STORM_ZOOKEEPER_CONNECTION_TIMEOUT)),
                    new RetryNTimes(5,//Utils.getInt(conf.get(Config.STORM_ZOOKEEPER_RETRY_TIMES)),
                            1000));//Utils.getInt(conf.get(Config.STORM_ZOOKEEPER_RETRY_INTERVAL))));
            _curator.start();
        } catch (Exception ex) {
            LOG.error("Couldn't connect to zookeeper", ex);
        }
    }

    public String partitionPath() {
        return _zkPath + "/topics/" + _topic + "/partitions";
    }

    public int getNumPartitions() {
        try {
            String topicBrokersPath = partitionPath();
            List<String> children = _curator.getChildren().forPath(topicBrokersPath);
            return children.size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
