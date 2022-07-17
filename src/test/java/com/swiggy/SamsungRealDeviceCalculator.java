package com.swiggy;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.remote.MobileCapabilityType;

public class SamsungRealDeviceCalculator {
	DesiredCapabilities cap = new DesiredCapabilities();
	AndroidDriver driver = null;
	@Test
	public void test() {
		try {
				
				cap.setCapability("platformName", "Android");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "5200c2a9ec4454fb");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
				cap.setCapability("appPackage", "com.flipkart.android");
				cap.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
				cap.setCapability("fullReset", false);
				cap.setCapability("noReset", true);
				
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				isTextVisible(driver.findElement(By.xpath("//android.widget.TextView[@text='You’ll now find the basics at your fingertips here']")), 
//						"You’ll now find the basics at your fingertips here");
				Thread.sleep(4000);
//				driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Search for')]")).sendKeys("Macbook m1" + Keys.ENTER);
				driver.findElement(By.xpath("//android.widget.TextView[@text='Categories']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Notifications']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
				
				
				driver.findElement(By.xpath("//android.widget.TextView")).sendKeys("Laptops");
				Thread.sleep(4000);
				//https://applitools.com/blog/whats-new-appium-java-client-8/
				driver.quit();
				
			
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}
	}
	
	public boolean isTextVisible(WebElement ele, String text) {
		boolean flag=false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if(wait.until(ExpectedConditions.visibilityOf(ele))!=null) {
				if(ele.getText().equalsIgnoreCase(text)) {
					flag= true;
				}
			}			
		}catch(Exception oExp) {
		System.out.println("Element is not found...");	
		}
		return flag;
	}
}


/*
You can use same script for both android and iOS, provided your app is identical in both platforms.
You can initiate drivers as per above explanations. Let come to locator part. So in that case you can use page object model to make it work. let me give below example. For login screen in iOS and Android are same.

public LoginScreen extends AbstractScreen{
@iOSFindBy(xpath="")
@AndroidFindBy(uiautomator="")
private MobileElement userNameTextEdit;

public void fillUserName(){    
userNameTextEdit.sendKeys("bs");
    }
}
*/