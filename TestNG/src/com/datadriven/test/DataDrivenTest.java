package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
	
public static void main(String[] args)
 {
	//get data from excel//
	Xls_Reader reader = new Xls_Reader("C:\\Users\\dell\\eclipse-workspace\\TestNG\\src\\com\\testdata\\DataProvide.xlsx");
	
	String firstname= reader.getCellData("RegTestData", "firstname", 3);
	System.out.println(firstname);
	
	String lastname= reader.getCellData("RegTestData", "lastname", 3);
	System.out.println(lastname);
	
	String email= reader.getCellData("RegTestData", "email", 3);
	System.out.println(email);
	
	String password= reader.getCellData("RegTestData", "password", 3);
	System.out.println(password);
	
	//webdriver setup //
	System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://auth.uber.com/login/?uber_client_name=riderSignUp&");
	
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='addPassword']")).sendKeys(password);
	
	
 }
}
