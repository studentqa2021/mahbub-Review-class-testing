package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory1;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	WebDriver driver;
	SeleniumPageFactory1 pf;
	@Given("open any browser")
	
	public void open_any_browser() {
		 driver = DriverManager.getBrowser("chrome");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		
	    }

	@Given("go to application")
	public void go_to_application() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "HOME PAGE");
		//explicit wait=WebDriver wait
		 pf = new SeleniumPageFactory1(driver);
	
		
		}

	@When("click sign butten")
	public void click_sign_butten() {
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
		pf.getSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "LOGIN PAGE");
		
	}

	@When("put email")
	public void put_email() {
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		
	    	}

	@When("put password")
	public void put_password() {		
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
		 
	}

	@When("click second signin button")
	public void click_second_signin_button() {
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		ScreenShot.getScreenShot(driver, "Validation page");
		
	}

	@Then("validate login was susseccfull")
	public void validate_login_was_susseccfull() {
		HighLighter.getColor(driver, pf.getWelcome().get(0));
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		
	}


}
