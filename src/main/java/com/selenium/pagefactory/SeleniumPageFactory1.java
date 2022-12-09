package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory1 {
	

	WebDriver driver;
	public SeleniumPageFactory1 (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
		@FindBy(xpath="//*[@class='authorization-link']")
		private List<WebElement> Signin;
		@FindBy(xpath ="//*[@id='email']")
		private WebElement email;//findElement()
		@FindBy(xpath ="//*[@title='Password']")
		private WebElement password;
		@FindBy(xpath ="//*[@class='action login primary']")
		private WebElement secondSigninBtn;
		@FindBy(xpath ="//*[@class='greet welcome']")// 1 of 2
		private List<WebElement> welcome;// findElements()<== new
		
		@FindBy(xpath = "//*[text()='Sign In / Register']")
		private List<WebElement> CostcoSignin;
		
		@FindBy(xpath = "//*[@id='navigation-widget']//a")
		private List<WebElement> CostcoManuBTN;
		
		@FindBy(xpath = "//*[@class='sub-item']")
		private List<WebElement> DealsOptions;
		
		
			
			
		
		public List<WebElement> getDealsOptions() {
			return DealsOptions;
		}
		public List<WebElement> getCostcoManuBTN() {
			return CostcoManuBTN;
		}
		public WebDriver getDriver() {
			return driver;
		}
		public List<WebElement> getSignin() {
			return Signin;
		}
		public List<WebElement> getCostcoSignin() {
			return CostcoSignin;
		}
		public List<WebElement> getSigninBtn() {
			return Signin;
		}
		public WebElement getEmail() {
			return email;
		}
		public WebElement getPassword() {
			return password;
		}
		public WebElement getSecondSigninBtn() {
			return secondSigninBtn;
		}
		public List<WebElement> getWelcome() {
			return welcome;
		}
		public WebElement getCostcoSingInBtn() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
		
		


	
