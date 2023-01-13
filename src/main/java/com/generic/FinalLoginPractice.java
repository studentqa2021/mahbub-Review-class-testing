package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory1;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;

public class FinalLoginPractice {
	
	public static void getFinalLogin(){
		
	

		
		//Login ==>https://magento.softwaretestingboard.com/
		//open browser
		WebDriver driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// got to Application
		driver.navigate().to(Constants.URL);
		//Home page
		ScreenShot.getScreenShot(driver, "Home Page");
		//click sign in button
		SeleniumPageFactory1 pf = new SeleniumPageFactory1(driver);
		HighLighter.getColor(driver, pf.getSigninBtn().get(0), "red");
		pf.getSigninBtn().get(0).click();
		//Login page
		ScreenShot.getScreenShot(driver, "Login Page");
		//put email
		HighLighter.getColor(driver, pf.getEmail(), "green");
		pf.getEmail().sendKeys(Constants.user);
		//put password
		HighLighter.getColor(driver, pf.getPassword(), "blue");
		pf.getPassword().sendKeys(Constants.password);
		//click 2nd sign in
		HighLighter.getColor(driver, pf.getSecondSigninBtn(), "yellow");
		pf.getSecondSigninBtn().click();
		//login validation
		ScreenShot.getScreenShot(driver, "Login validation");
		//validate = welcome sarower =xpath ==> is displayed = true = passed
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(pf.getWelcome().get(0).isDisplayed());
		sf.assertAll();
		driver.quit();
		
		

	}
	
	
	public static void main(String[] args) {
		getFinalLogin();
	}
	}

