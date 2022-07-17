package com.firstapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

public class ScreenerAppScript {
	public AndroidDriver<AndroidElement> driver;
	DesiredCapabilities cap = null;

	@BeforeTest
	public void beforeTest() {
		try {
			cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API33");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
			cap.setCapability("appPackage", "com.scrnr.screener");
			cap.setCapability("appActivity", "com.scrnr.screener.MainActivity");
			
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
			

			
			System.out.println("Navigated to url");
			
			Thread.sleep(3000);
			
			
			
			
			
			
			
			
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
