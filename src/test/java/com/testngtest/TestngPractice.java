package com.testngtest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPractice {
	@BeforeTest
	public void setup() {
		System.out.println("Before Test : All Setup code");
	}
	// method name >>alphabetic order= problem
	// priority => ignore alphabetic order
	@Test (priority = 0)
	public void getLogin() {//getLogin=getL=2nd
		System.out.println("First Test = Login");
	}
	
	@Test(priority = 1)
	public void getProduct() {//getProduct=getP=3rd
		System.out.println("Second Test= product");
	}
	
	@Test(priority = 2,enabled = false)
	public void getCartFunction() {//getCartFunction=getC =1st
		System.out.println("Thrid Test= Cart");
	}
	@AfterTest
	public void teardown() {
		System.out.println("After Test: close connection");
	}
}

