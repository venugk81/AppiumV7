package com.firstapp;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.remote.MobileCapabilityType;

public class SamsungRealDeviceFlipkart {
	DesiredCapabilities cap = new DesiredCapabilities();

	@Test
	public void test() {
		try {
				
				cap.setCapability("platformName", "Android");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "5200c2a9ec4454fb");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
				cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
				cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
				cap.setCapability("fullReset", false);
				cap.setCapability("noReset", true);
				AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				Thread.sleep(1000);
				
				//https://applitools.com/blog/whats-new-appium-java-client-8/
				driver.quit();
				
			
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}
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