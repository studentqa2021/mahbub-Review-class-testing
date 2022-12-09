package com.util;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {

	public static void getColor(WebDriver driver,WebElement webElement){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement); 
	}
	
	public static void getColor(WebDriver driver,WebElement element,String color){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
	
		jsExecutor.executeScript("arguments[0].style.border='2px solid "+color+"'", element); 
		
		
}}
