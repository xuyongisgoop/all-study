package com.xuyong.study.nimbus;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift7.TException;
import org.apache.thrift7.protocol.TBinaryProtocol;
import org.apache.thrift7.transport.TFramedTransport;
import org.apache.thrift7.transport.TSocket;
import org.apache.thrift7.transport.TTransportException;

import backtype.storm.generated.ClusterSummary;
import backtype.storm.generated.Nimbus.Client;

public class NimbusClientTest {
	public static void main(String[] args) {
		NimbusClientTest test = new NimbusClientTest();
		try {
			Client client = test.getClient("10.199.201.189", 6627);
			ClusterSummary clusterInfo = client.getClusterInfo();
			System.out.println(clusterInfo);
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
//		
//		Map conf = new HashMap();
//		try {
//			NimbusClient nimbusClient = new NimbusClient(conf, "10.199.201.189", 6627);
//			System.out.println(nimbusClient.getClient().getClusterInfo());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public Client getClient(String host, int port) throws TTransportException {
		Map<String,Object> clientInfos = new HashMap<String,Object>();
		TSocket socket = new TSocket(host, port);
		TFramedTransport tFramedTransport = new TFramedTransport(socket);
		TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(tFramedTransport);
		Client client = new Client(tBinaryProtocol);
		tFramedTransport.open();
		clientInfos.put("client",client);
		clientInfos.put("tFramedTransport",tFramedTransport);
		return (Client)clientInfos.get("client");
	}
}
