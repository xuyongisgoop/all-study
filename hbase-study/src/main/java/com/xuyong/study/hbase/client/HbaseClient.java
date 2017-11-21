package com.xuyong.study.hbase.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HbaseClient {
    // ������̬����
    private static Configuration conf = null;
    private static HBaseAdmin hAdmin = null;
 
    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "10.199.196.41,10.199.196.42,10.199.196.43");
        conf.set("hbase.zookeeper.property.clientPort", "2183");
        try {
			hAdmin = new HBaseAdmin(conf);
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
    //�жϱ��Ƿ����
    private static boolean isExist(String tableName) throws IOException {
        return hAdmin.tableExists(tableName);
    }
 
    // �������ݿ��
    @SuppressWarnings("deprecation")
	public static void createTable(String tableName, String[] columnFamilys)
            throws Exception {
        // �½�һ�����ݿ����Ա
        if (hAdmin.tableExists(tableName)) {
            System.out.println("�� "+tableName+" �Ѵ��ڣ�");
            System.exit(0);
        } else {
            // �½�һ��students�������
            HTableDescriptor tableDesc = new HTableDescriptor(tableName);
            // ���������������
            for (String columnFamily : columnFamilys) {
                tableDesc.addFamily(new HColumnDescriptor(columnFamily));
            }
            // �������úõ���������
            hAdmin.createTable(tableDesc);
            System.out.println("������ "+tableName+" �ɹ�!");
        }
    }
 
    // ɾ�����ݿ��
    public static void deleteTable(String tableName) throws Exception {
        // �½�һ�����ݿ����Ա
        if (hAdmin.tableExists(tableName)) {
            // �ر�һ����
            hAdmin.disableTable(tableName);
            hAdmin.deleteTable(tableName);
            System.out.println("ɾ���� "+tableName+" �ɹ���");
        } else {
            System.out.println("ɾ���ı� "+tableName+" �����ڣ�");
            System.exit(0);
        }
    }
 
    // ���һ������
    public static void addRow(String tableName, String row,
            String columnFamily, String column, String value) throws Exception {
        HTable table = new HTable(conf, tableName);
        Put put = new Put(Bytes.toBytes(row));// ָ����
        // �����ֱ�:���塢�С�ֵ
        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column),
                Bytes.toBytes(value));
        table.put(put);
    }
 
    // ɾ��һ��(��)����
    public static void delRow(String tableName, String row) throws Exception {
        HTable table = new HTable(conf, tableName);
        Delete del = new Delete(Bytes.toBytes(row));
        table.delete(del);
    }
 
    // ɾ����������
    public static void delMultiRows(String tableName, String[] rows)
            throws Exception {
        HTable table = new HTable(conf, tableName);
        List<Delete> delList = new ArrayList<Delete>();
        for (String row : rows) {
            Delete del = new Delete(Bytes.toBytes(row));
            delList.add(del);
        }
        table.delete(delList);
    }
 
    // ��ȡһ������
    public static void getRow(String tableName, String row) throws Exception {
        HTable table = new HTable(conf, tableName);
        Get get = new Get(Bytes.toBytes(row));
        Result result = table.get(get);
        // ������,raw������������keyvalue����
        for (KeyValue rowKV : result.raw()) {
            System.out.print("����:" + new String(rowKV.getRow()) + " ");
            System.out.print("ʱ���:" + rowKV.getTimestamp() + " ");
            System.out.print("������:" + new String(rowKV.getFamily()) + " ");
            System.out.print("����:" + new String(rowKV.getQualifier()) + " ");
            System.out.println("ֵ:" + new String(rowKV.getValue()));
        }
    }
 
    // ��ȡ��������
    public static void getAllRows(String tableName) throws Exception {
        HTable table = new HTable(conf, tableName);
        Scan scan = new Scan();
        ResultScanner results = table.getScanner(scan);
        // ������
        for (Result result : results) {
            for (KeyValue rowKV : result.raw()) {
                System.out.print("����:" + new String(rowKV.getRow()) + " ");
                System.out.print("ʱ���:" + rowKV.getTimestamp() + " ");
                System.out.print("������:" + new String(rowKV.getFamily()) + " ");
                System.out
                        .print("����:" + new String(rowKV.getQualifier()) + " ");
                System.out.println("ֵ:" + new String(rowKV.getValue()));
            }
        }
    }
 
    // ������
    public static void main(String[] args) {
        try {
        	for (TableName tn : hAdmin.listTableNames()) {
        		System.out.println("<<<<<<<<<<<<<<<<<<<");
        		System.out.println(tn.getNameAsString());
        		System.out.println("<<<<<<<<<<<<<<<<<<<");
        	}
            //String tableName = "abner-opz_base";
        	String tableName = "trace-index";
            //HbaseClient.getAllRows(tableName);
            // ��һ�����������ݿ����student��
            String[] columnFamilys = { "info", "course" };
            HbaseClient.createTable(tableName, columnFamilys);
            // �ڶ����������ݱ���������
            // ��ӵ�һ������
            if (isExist(tableName)) {
                HbaseClient.addRow(tableName, "zpc", "info", "age", "20");
                HbaseClient.addRow(tableName, "zpc", "info", "sex", "boy");
                HbaseClient.addRow(tableName, "zpc", "course", "china", "97");
                HbaseClient.addRow(tableName, "zpc", "course", "math", "128");
                HbaseClient.addRow(tableName, "zpc", "course", "english", "85");
                // ��ӵڶ�������
                HbaseClient.addRow(tableName, "henjun", "info", "age", "19");
                HbaseClient.addRow(tableName, "henjun", "info", "sex", "boy");
                HbaseClient.addRow(tableName, "henjun", "course", "china","90");
                HbaseClient.addRow(tableName, "henjun", "course", "math","120");
                HbaseClient.addRow(tableName, "henjun", "course", "english","90");
                // ��ӵ���������
                HbaseClient.addRow(tableName, "niaopeng", "info", "age", "18");
                HbaseClient.addRow(tableName, "niaopeng", "info", "sex","girl");
                HbaseClient.addRow(tableName, "niaopeng", "course", "china","100");
                HbaseClient.addRow(tableName, "niaopeng", "course", "math","100");
                HbaseClient.addRow(tableName, "niaopeng", "course", "english","99");
                // ����������ȡһ������
                System.out.println("**************��ȡһ��(zpc)����*************");
                HbaseClient.getRow(tableName, "zpc");
                // ���Ĳ�����ȡ��������
                System.out.println("**************��ȡ��������***************");
                HbaseClient.getAllRows(tableName);
 
                // ���岽��ɾ��һ������
                System.out.println("************ɾ��һ��(zpc)����************");
                HbaseClient.delRow(tableName, "zpc");
                HbaseClient.getAllRows(tableName);
                // ��������ɾ����������
                System.out.println("**************ɾ����������***************");
                String rows[] = new String[] { "qingqing","xiaoxue" };
                HbaseClient.delMultiRows(tableName, rows);
                HbaseClient.getAllRows(tableName);
                // ���߲���ɾ�����ݿ�
                System.out.println("***************ɾ�����ݿ��**************");
                HbaseClient.deleteTable(tableName);
                System.out.println("��"+tableName+"������"+isExist(tableName));
            } else {
                System.out.println(tableName + "�����ݿ�����ڣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
