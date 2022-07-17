package com.web;

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

public class mfacebookWeb {
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
			driver.get("https://m.facebook.com");			
			System.out.println("Navigated to url");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Testing email");
			driver.findElement(By.cssSelector("input[id='m_login_password']")).sendKeys("Testing password");	
			String txt = driver.findElement(By.xpath("//button[@name='login']")).getAttribute("class");
			System.out.println(txt);
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
