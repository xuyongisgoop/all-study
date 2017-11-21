/*
 * ZookeeperTest.java
 */
package com.xuyong.study.zookeeper.zkclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * 由于原静态ZookeeperUtil不符合功能需求，新开发的操作zookeeper的工具类
 * @author jetty.xu
 *
 */
public class ZkUtil {
	private int SESSION_TIMEOUT = 30000;

	public Logger LOGGER = LoggerFactory.getLogger(ZkUtil.class);

	private Watcher watcher = new Watcher() {
		public void process(WatchedEvent event) {
			LOGGER.info("process : " + event.getType());
		}
	};

	private ZooKeeper zooKeeper;

	/**
	 * 连接zookeeper
	 * @param connectString
	 */
	public ZkUtil(String connectString) {
		if (zooKeeper == null) {// 线程不安全
			try {
				zooKeeper = new ZooKeeper(connectString, SESSION_TIMEOUT, watcher);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭连接
	 * @author jetty.xu
	 * 2016年3月7日
	 */
	public void close() {
		try {
			zooKeeper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取路径下面的子节点名
	 * @author jetty.xu
	 * @param path
	 * @return
	 * 2016年3月7日
	 */
	public List<String> getChildren(String path) {
		List<String> result = new ArrayList<String>();
		try {
			LOGGER.info("zooKeeper.getState().isConnected(): " + zooKeeper.getState().isConnected());
			LOGGER.info("zooKeeper.getState().isAlive(): " + zooKeeper.getState().isAlive());
			result = zooKeeper.getChildren(path,null);
		} catch (Exception e) {
			try {
				zooKeeper.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取某个具体节点的内容
	 * @author jetty.xu
	 * @param path
	 * @return
	 * 2016年3月7日
	 */
	public String getNodeData(String path) {
		String detail = null;
		try {
			byte[] bytes = zooKeeper.getData(path, null, null);
			detail = new String(bytes);
		} catch (Exception e) {
			try {
				zooKeeper.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return detail;
	}
	
	/**
	 * 判断是否存在指定路径节点
	 * @author jetty.xu
	 * @param path
	 * @return
	 * 2016年3月7日
	 */
	public boolean existsNode(String path) {
		Stat stat = null;
		try {
			stat = zooKeeper.exists(path, null);
		} catch (Exception e) {
			try {
				zooKeeper.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return stat != null;
	}
	
}
