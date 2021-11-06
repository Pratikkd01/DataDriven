package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {
	
public static void main(String[] args)
	 {
	
	//webdriver setup //
	System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://auth.uber.com/login/?uber_client_name=riderSignUp&");

	//get data from excel//
	Xls_Reader reader = new Xls_Reader("C:\\Users\\dell\\eclipse-workspace\\TestN\\src\\com\\testdata\\DataProvide.xlsx");
	int rowcount= reader.getRowCount("RegTestData");
	
	reader.addColumn("RegTestData","status");
	
	//parameterization(data driven approach) - done by for loop
	for (int rownum=2; rownum<=rowcount; rownum++)
	{
		String firstName = reader.getCellData("RegTestData", "firstname", rownum);
		System.out.println(firstName);
		
		String lastname= reader.getCellData("RegTestData", "lastname", rownum);
		System.out.println(lastname);
		
		String email= reader.getCellData("RegTestData", "email", rownum);
		System.out.println(email);
		
		String password= reader.getCellData("RegTestData", "password", rownum);
		System.out.println(password);
		
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='addPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='addPassword']")).sendKeys(password);
		
		reader.setCellData("RegTestData", "status", rownum, "Pass");
	}
	
		

}
}
