package com.cucumber.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory1;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef1 {
	WebDriver driver;
	SeleniumPageFactory1 pf;
	
	@Given("open the browser")
	public void open_the_browser() {
	 driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	}

	@Given("go to the application URL")
	public void go_to_the_application_URL() {
		driver.navigate().to(Constants.URL);
		//Home page
		ScreenShot.getScreenShot(driver, "Home Page");
	   
	}

	@When("click the signin button")
	public void click_the_signin_button() {
		 pf = new SeleniumPageFactory1(driver);
		HighLighter.getColor(driver, pf.getSigninBtn().get(0), "red");
		pf.getSigninBtn().get(0).click();
		//Login page
		ScreenShot.getScreenShot(driver, "Login Page");
	  
	   
	}

	@When("put the email")
	public void put_the_email() {
		//put email
				HighLighter.getColor(driver, pf.getEmail(), "green");
				pf.getEmail().sendKeys(Constants.user);

	   
	}

	@When("put the password")
	public void put_the_password() {
		//put password
				HighLighter.getColor(driver, pf.getPassword(), "blue");
				pf.getPassword().sendKeys(Constants.password);
	   
	}

	@When("click the second signin button")
	public void click_the_second_signin_button() {
		//click 2nd sign in
				HighLighter.getColor(driver, pf.getSecondSigninBtn(), "yellow");
				pf.getSecondSigninBtn().click();
	   
	}

	@Then("validate the login was susseccfull")
	public void validate_the_login_was_susseccfull() {
		//login validation
				ScreenShot.getScreenShot(driver, "Login validation");
				//validate = welcome sarower =xpath ==> is displayed = true = passed
				SoftAssert sf = new SoftAssert();
				sf.assertTrue(pf.getWelcome().get(0).isDisplayed());
				sf.assertAll();
				driver.quit();
	   
	}


	
}

