package com.Uber;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestingUtils {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList <Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:\\Users\\dell\\eclipse-workspace\\TestNG\\src\\com\\testdata\\DataProvide.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (int rownum=2; rownum<=reader.getRowCount("RegTestData"); rownum++)
		{
			String firstName = reader.getCellData("RegTestData", "firstname", rownum);
			System.out.println(firstName);
			
			String lastname= reader.getCellData("RegTestData", "lastname", rownum);
			System.out.println(lastname);
			
			String email= reader.getCellData("RegTestData", "email", rownum);
			System.out.println(email);
			
			String password= reader.getCellData("RegTestData", "password", rownum);
			System.out.println(password);
			
			Object[] obj = {firstName, lastname, email, password };
			mydata.add(obj);
			
	}
		return mydata;
	}		
}
