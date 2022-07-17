package com.realdevice;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.remote.MobileCapabilityType;

public class FirstTestOnRealDevice {
	DesiredCapabilities cap = new DesiredCapabilities();

	@Test
	public void test() {
		try {
			File f = new File(System.getProperty("user.dir") + "\\apks\\ApiDemos-debug.apk"); // C:\Users\gopve\eclipse-workspace\mobileautomation
			if (f.exists()) {
				System.out.println(f.isFile());
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "2f42cae7");
				cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
				AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				
			}
		} catch (Exception oExp) {
			oExp.printStackTrace();
		}
	}
}
