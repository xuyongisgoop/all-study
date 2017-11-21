package com.vip.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@SuppressWarnings("serial")
public class CleanBolt extends BaseBasicBolt {
	
	public void execute(Tuple input, BasicOutputCollector collector) {
		String content = input.getString(0);
		JSONObject object = JSON.parseObject(content);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("parse message: " + object.toJSONString());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		object.put("clean_flag", true);
		collector.emit(new Values(JSON.toJSONString(object)));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("object"));
	}

}
