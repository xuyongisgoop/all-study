package com.vip.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

public class PersistBolt extends BaseBasicBolt{
	

	public void execute(Tuple input, BasicOutputCollector collector) {
		String content = input.getString(0);
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
	}

}
