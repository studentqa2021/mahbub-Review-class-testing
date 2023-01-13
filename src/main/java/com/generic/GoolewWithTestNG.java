package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.DriverManager;
import com.util.SeleniumWait;

public class GoolewWithTestNG {


	
	@BeforeTest
	public void setup() {
		WebDriver driver =DriverManager.getBrowser("chrome");
		driver.manage().window().fullscreen();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.navigate().to("https://www.google.com/");
		
	}
	@Test
	public void loginTest() {
		//Login test
	}
	@AfterTest
	public void teardown() {
		//close browser
	}

}
