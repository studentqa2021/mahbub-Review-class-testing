package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory1;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
		
		

		public void getLogin(){
			//open a browser
			WebDriver driver = DriverManager.getBrowser("chrome");
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			SeleniumWait.getImplicitWait(driver, 3);
			// go to URL
			driver.navigate().to(Constants.URL);
			ScreenShot.getScreenShot(driver, "HOME PAGE");
			//explicit wait=WebDriver wait
			SeleniumPageFactory1 pf = new SeleniumPageFactory1(driver);
			SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
			//click sign in
			HighLighter.getColor(driver, pf.getSigninBtn().get(0));
			pf.getSigninBtn().get(0).click();
			ScreenShot.getScreenShot(driver, "LOGIN PAGE");
			//put user
			HighLighter.getColor(driver, pf.getEmail());
			pf.getEmail().click();
			pf.getEmail().sendKeys(Constants.user);
			//put pass
			HighLighter.getColor(driver, pf.getPassword());
			pf.getPassword().click();
			pf.getPassword().sendKeys(Constants.password);
			//click second sign in
			HighLighter.getColor(driver, pf.getSecondSigninBtn());
			pf.getSecondSigninBtn().click();
			ScreenShot.getScreenShot(driver, "Validation page");
			//validation	
			
			boolean status =pf.getWelcome().get(0).isDisplayed();
			//Assertion = Hard & soft
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(status);//condition =true or false
			
			sa.assertAll();//validation
					
	}
	

}
