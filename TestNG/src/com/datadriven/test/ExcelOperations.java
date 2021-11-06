	package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args){
		
	Xls_Reader reader = new Xls_Reader("C:\\Users\\dell\\eclipse-workspace\\TestNG\\src\\com\\testdata\\DataProvide.xlsx");
	// to add sheet in excel//
	//	reader.addSheet("HomePage");
	
	if(!reader.isSheetExist("HomePage"))
	{
		reader.addSheet("HomePage");
	}
	
	int colcount= reader.getColumnCount("RegTestData");
	System.out.println("Total col present in sheet: "+ colcount);
	
	int cellnum = reader.getCellRowNum("RegTestData", "firstname", "Pratik");
	System.out.println(cellnum);
	
	int rownum = reader.getCellRowNum("RegTestData", "firstname", "Viraj");
	System.out.println(rownum);
 
 }
}