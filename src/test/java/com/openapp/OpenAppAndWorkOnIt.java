package com.openapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class OpenAppAndWorkOnIt  {
	
	public DesiredCapabilities cap = null;
	public AndroidDriver driver=null;
		
  @Test
  public void f() throws MalformedURLException{
	  try {
		  	cap = new DesiredCapabilities();
//			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");		
//			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
////			cap.setCapability("chromeOptions" ImmutableMap.of("w3c", false));	
		  	
		  	
//			driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), cap);
//			driver.get("https://amazon.in");
		  	
		  	
//		  	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
//		  	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//		  	cap.setCapability("appPackage", "io.appium.android.apis");
//		  	cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		  	
		  	

		  	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability("appium:appPackage", "io.appium.android.apis");
			cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
			
			
			
		  	driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), cap);
		  	
			driver.close();
			driver.quit();
	  }catch(Exception oExp) {
		  oExp.printStackTrace();
	  }
	  
  }
}
