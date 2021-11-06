package com.Uber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class DataDrivenUber {
	WebDriver driver; 
	
	@BeforeClass
	public void beforeclass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://auth.uber.com/login/?uber_client_name=riderSignUp&");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@BeforeMethod
	public void setup() {
		driver.manage().window().maximize();	
		System.out.println("Setup is ready");
		
	}
	@DataProvider
	public Iterator<Object[]> getdata() {
		ArrayList<Object[]> testdata = TestingUtils.getDataFromExcel();
		return testdata.iterator();
	} 
	
	@Test(dataProvider= "getdata", priority=1)
	public void Uber(String firstName, String lastname, String email, String password) {
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='addPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='addPassword']")).sendKeys(password);	
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.navigate().refresh();
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
	}
}
