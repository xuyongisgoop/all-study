package com.xuyong.study.poi;

import com.google.common.collect.Lists;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuyong on 2018/4/26.
 */
public class TestPoi {

    public static void main(String[] args) {
        TestPoi poi = new TestPoi();
        poi.generateFile();
    }

    public void generateFile() {
        //URL resource = this.getClass().getResource("/xlsx/electronic_billing.xlsx");
        FileOutputStream out = null;
        XSSFWorkbook workbook = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            out = new FileOutputStream("electronic_billing_temp.xlsx");

            InputStream elecBillingTemp = this.getClass().getResourceAsStream("/xlsx/electronic_billing.xlsx");
            //FileInputStream elecBillingTemp = new FileInputStream(resource.getFile());
            workbook = new XSSFWorkbook(elecBillingTemp);
            XSSFSheet sheetAt1 = workbook.getSheetAt(0);

            PoiPoint generalInfo = new PoiPoint(2, 2, " 尊敬的许勇客户，您好：\n" +
                    "\n" +
                    " 感谢您使用蜂鸟开放平台，以下是贵公司12月产生的配送费用对账单\n" +
                    "\n" +
                    " 账单周期：2018/12/1-2018/12/31");
            PoiPoint deliveryCount = new PoiPoint(5, 3, "20");
            PoiPoint deliveryFee = new PoiPoint(5, 5, "30");
            PoiPoint timeFee = new PoiPoint(6, 5, "10");
            PoiPoint sumFee = new PoiPoint(8, 5, "40");
            Lists.newArrayList(generalInfo, deliveryCount, deliveryFee, timeFee, sumFee).forEach((item) -> {
                XSSFRow row = sheetAt1.getRow(item.getRow());
                XSSFCell cell = row.getCell(item.getCell());
                cell.setCellValue(item.getValue());
            });

            sxssfWorkbook = new SXSSFWorkbook(workbook);
            SXSSFSheet sxssfSheet = sxssfWorkbook.getSheetAt(1);
            System.out.println(">>>>> sxss last row num " + sxssfSheet.getLastRowNum());
            SXSSFRow sxssfSheetRow = sxssfSheet.createRow(3);
            SXSSFCell sxssfSheetRowCell = sxssfSheetRow.createCell(2);
            sxssfSheetRowCell.setCellValue(3000000016107300000l);

            sxssfWorkbook.write(out);
            sxssfWorkbook.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (sxssfWorkbook != null) {
                    sxssfWorkbook.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PoiPoint {
        private int row;
        private int cell;
        private String value;

        public PoiPoint() {
        }

        public PoiPoint(int row, int cell, String value) {
            this.row = row;
            this.cell = cell;
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCell() {
            return cell;
        }

        public void setCell(int cell) {
            this.cell = cell;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
