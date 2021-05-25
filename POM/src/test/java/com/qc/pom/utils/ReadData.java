package com.qc.pom.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadData {

	public Object[][] getLoginData(String sheetNumber) throws IOException {
		
		FileInputStream fis = new FileInputStream("TestData/ReadData.xls");
		DataFormatter formatter = new DataFormatter();
		HSSFWorkbook book = new HSSFWorkbook(fis);
		HSSFSheet sheet = book.getSheet(sheetNumber);
		HSSFRow hrow = sheet.getRow(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = hrow.getLastCellNum();
		
		Object testData[][] = new Object[rows][columns];
		
		for(int i=0; i<rows; i++) {
			HSSFRow row = sheet.getRow(i + 1);
			for(int j =0; j<columns; j++) {
				if(row == null) {
					testData[i][j] = "";
				}else {
					HSSFCell cell = row.getCell(j);
					if(cell == null) {
						testData[i][j] = "";
					}else {
						String value = formatter.formatCellValue(cell);
						testData[i][j] = value;
					}
				}
			}
		}
		
		return testData;
		
	}
	
}
