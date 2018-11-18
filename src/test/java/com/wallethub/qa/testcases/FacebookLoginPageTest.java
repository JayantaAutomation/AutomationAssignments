package com.wallethub.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookLoginPageTest {
	//Creating reference of Webdriver Interface
	WebDriver driver;

	//Declare Facebook Credentials
	//String user="Enter your Email or Phone number";
	String user="8073813879";
	//String pass="Enter your Password";
	String pass="Gopal$14";
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {

				//Creating an instance of chrome level class to disable browser level notifications
				ChromeOptions coptions = new ChromeOptions();
				coptions.addArguments("--disable-notifications");

				// Telling Selenium to find Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");

				// Initialize browser
				driver = new ChromeDriver(coptions);

				// Launch Facebook
				driver.get("http://facebook.com/");

				//Wait
				Thread.sleep(1000);

				//Maximize Window
				driver.manage().window().maximize();

				//Wait
				Thread.sleep(2000);
	}	
	@Test
	private void postReviewTest() throws InterruptedException {
		// TODO Auto-generated method stub
				//Enter Username
				WebElement userTextField = driver.findElement(By.id("email"));
				userTextField.sendKeys(user);

				//Wait
				Thread.sleep(2000);

				//Enter Password
				WebElement PassTextField = driver.findElement(By.id("pass"));
				PassTextField.sendKeys(pass);

				//Wait
				Thread.sleep(2000);

				//Click on Login button
				driver.findElement(By.id("loginbutton")).click();

				//Wait
				Thread.sleep(3000);

				//Find the Status Text Area and enter the status message as Hello World
				WebElement TextArea = driver.findElement(By.name("xhpc_message"));
				Thread.sleep(2000);
				TextArea.click();
				TextArea.sendKeys("Hello World");

				//Wait
				Thread.sleep(2000);

				//Click On Post Button
				WebElement PostBtn = driver.findElement(By.cssSelector
				("button[data-testid='react-composer-post-button']"));
				PostBtn.click();

				//Wait
				Thread.sleep(4000);		
			
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
