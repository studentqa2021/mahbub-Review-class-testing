package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory1;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {
	
	public static void productHandle(){
		//1)	Go to https://www.costco.com/
				WebDriver driver =DriverManager.getBrowser("chrome");
				driver.manage().window().maximize();
				driver.navigate().to(Constants.COSTCO_URL);
				SeleniumWait.getImplicitWait(driver, 5);
				//Get the page name=>title>> getTitle()
				System.out.println("Home page title/name = "+ driver.getTitle());
				ScreenShot.getScreenShot(driver, "Costco home welcome page");
				//Check=validate current URL is matched or not==> getCurrentURL()
				System.out.println("Current page URl = "+driver.getCurrentUrl());
				//Expectation = Constants.COSTCO_URL , actual =driver.getCurrentUrl()
				SoftAssert sf = new SoftAssert();
				sf.assertEquals(driver.getCurrentUrl(),Constants.COSTCO_URL);
				//Go to sign in page  
				
				SeleniumPageFactory1 pf = new SeleniumPageFactory1(driver);
				SeleniumWait.getExplicitWait(driver, pf.getCostcoSignin().get(0), 5);
				HighLighter.getColor(driver, pf.getCostcoSignin().get(0), "red");
				pf.getCostcoSignin().get(0).click();
				// 5.Get the page name
				System.out.println("Login page title" + driver.getTitle());
				ScreenShot.getScreenShot(driver, "Costco signin page");
				
				// 6.Go back to the home page
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (true) {
					if (pf.getCostcoSignin().size() > 0) {
						break;
					} else {
						driver.navigate().back();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				// 7.Read all options and count options below the login button
				// pf.getCostcoManuBTN().size();
				System.out.println(" total count" + pf.getCostcoManuBTN().size());
				for (int i = 0; i < pf.getCostcoManuBTN().size(); i++) {
					HighLighter.getColor(driver, pf.getCostcoManuBTN().get(i), "white");
					System.out.println(pf.getCostcoManuBTN().get(i).getText());

				}
				// 8 >If the deal was there, then mouse over it and read all options
				// mouse hover= Actions class= moveToElement()

				for (int i = 0; i < pf.getCostcoManuBTN().size(); i++) {

					if (pf.getCostcoManuBTN().get(i).getText().contains("Deals")) {// true
						HighLighter.getColor(driver, pf.getCostcoManuBTN().get(i), "red");
						Actions ac = new Actions(driver);
						ac.moveToElement(pf.getCostcoManuBTN().get(i)).perform();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println("Deal options count = " + pf.getDealsOptions().size());
						// Read name of All deal options==> loop
						for (int j = 0; j < pf.getDealsOptions().size(); j++) {// 2nd loop
							HighLighter.getColor(driver, pf.getDealsOptions().get(j), "green");
							System.out.println(pf.getDealsOptions().get(j).getText());
						}
					}

				}

				
				
				

				
				
	}

	public static void main(String[] args) {
		CostcoAutomation.productHandle();
		
	}
}
