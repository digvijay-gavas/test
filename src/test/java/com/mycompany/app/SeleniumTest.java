package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class SeleniumTest extends TestCase {

	
 	private WebDriver _driver;
 	@Before
 	@Override
 	protected void setUp() throws Exception {
 		// TODO Auto-generated method stub
 		
 		String service = "D:\\knowlege_sharing\\tools\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", service);
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		capabilities.setCapability("requireWindowFocus", true);
		
		
		  _driver = new InternetExplorerDriver(capabilities);
		  _driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  
		
 		
 		//System.setProperty("webdriver.firefox.driver","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
 		//System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
 		//FirefoxProfile firefoxProfile = new FirefoxProfile();
 		System.out.println("------++++0");
 		//_driver = new FirefoxDriver(firefoxProfile);
 		System.out.println("------++++1");
 	}
 	public void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
 		
 		System.out.println("---waiting "+ driver.getCurrentUrl());
 	    Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
 	    wait.until(driver1 -> String
 	            .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
 	            .equals("complete"));
 	    ;
 	   System.out.println("---loaded "+ driver.getCurrentUrl());
 	}
 	
 	
 	@Test
	public void testApp()
    {
 		
 		_driver.get("https://www.google.co.in/");
 		waitForPageLoadComplete(_driver, 10);
 				
 		assertEquals("Google", _driver.getTitle());
 		
 		_driver.findElement(By.id("lst-ib")).clear();
 		_driver.findElement(By.id("lst-ib")).sendKeys("selenium\n");
 		//_driver.findElement(By.name("btnK")).click();
 		waitForPageLoadComplete(_driver, 10);
 		_driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
 		waitForPageLoadComplete(_driver, 10);
 		//assertEquals(" ", _driver.getTitle());
 		assertEquals("Selenium - Web Browser Automation", _driver.getTitle());
    }
 	@After 
 	public void tearDown() throws Exception {
 		_driver.quit();
 	}
}
