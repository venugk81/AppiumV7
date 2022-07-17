package com.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebAppFacebook {
	public AndroidDriver<AndroidElement> driver;
	DesiredCapabilities cap = null;

	@BeforeTest
	public void beforeTest() {
		try {
			cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API32");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");			
			cap.setCapability(MobileCapabilityType.VERSION, "12");
			cap.setCapability("–session-override",true);
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	
	
	public void executeScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(script);
	}

	@Test
	public void testMethod() {
		try {
			driver.get("https://rahulshettyacademy.com/angularpractice/");
//			driver.get("https://www.flipkart.com/");
//			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Testing laptop");
			
			
			System.out.println("Navigated to url");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a[href*='shop']")).click();
			driver.findElement(By.cssSelector("a[class='list-group-item']")).click();
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys("testing");
			
			String txt = driver.findElement(By.xpath("//h5")).getText();
			System.out.println(txt);
			Thread.sleep(3000);
			
			System.out.println("Clicked on theme btn");
			
			
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}

	}
	
	@AfterTest
	public void afterTest() {
		try {
			
			driver.quit();
			System.out.println("Driver is quit..");
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}

	}
	
	
}