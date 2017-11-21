package com.xuyong.study.kafka.old;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.alibaba.fastjson.JSONObject;
import com.vip.metric.persistent.bean.MetricProto.MetricMessage;
import com.vip.metric.persistent.bean.MetricProto.MetricMessage.Builder;
import com.vip.metric.persistent.bean.MetricProto.Tag;

public class ProducerClientPB implements Runnable {
	private String topic;
	private Producer<String, byte[]> producer;
	private Properties props = new Properties();
	
	public ProducerClientPB(String brokerAdrress, String topic) {
		this.topic = topic;
		props.put("serializer.class", "kafka.serializer.DefaultEncoder");
		props.put("metadata.broker.list", brokerAdrress);
		producer = new Producer<String, byte[]>(new ProducerConfig(props));
	}

	public void run() {
		while(true) {
			sendExcel("data_pb.xlsx");
			
			try {
				Random random = new Random();
				int value = random.nextInt(1000);
				System.out.println("==============================");
				System.out.println(value);
				System.out.println("==============================");
				Thread.sleep(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void sendExcel(String file_name) {
		Workbook book = null;
		FileInputStream target_file_stream = null;
		try {
			URL target_url = this.getClass().getClassLoader().getResource(file_name);
			File target_file = new File(target_url.getFile());
			target_file_stream = new FileInputStream(target_file);
			book = WorkbookFactory.create(target_file_stream);
			// 获得第一个工作表对象
			Sheet sheet = book.getSheetAt(0);
			Date date = new Date();
			int count = sheet.getLastRowNum();
			for (int i = 1; i <= count; i++) {
				Row row = sheet.getRow(i);
				JSONObject info = new JSONObject();
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					String content = cell.toString();
					String key = sheet.getRow(0).getCell(j).toString();
					if(key.equals("age")){
						info.put("age", Integer.valueOf(content));
					}else if(key.equals("city")){
						info.put("city", content);
					}else if(key.equals("amount")){
						info.put("amount", Double.valueOf(content));
					}
				}
				date = new Date();
				info.put("event_time", date.getTime());
				Builder metircMessageBuilder = MetricMessage.newBuilder();
				metircMessageBuilder.setName("metric.pb.city." + info.getString("city"));
				metircMessageBuilder.setValue(info.getString("amount"));
				metircMessageBuilder.setValueType(1);
				metircMessageBuilder.setTimestamp(new Date().getTime());
				com.vip.metric.persistent.bean.MetricProto.Tag.Builder tagBuilder = Tag.newBuilder();
				tagBuilder.setName("age");
				tagBuilder.setValue(info.getString("age"));
				metircMessageBuilder.addTags(tagBuilder);
				MetricMessage message = metircMessageBuilder.build();
				System.out.println(message);
				producer.send(new KeyedMessage<String,byte[]>(topic, message.toByteArray()));
				System.out.println(message.toByteArray().length);
				System.out.println(MetricMessage.PARSER.parseFrom(message.toByteArray()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (target_file_stream != null) {
				try {
					target_file_stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
