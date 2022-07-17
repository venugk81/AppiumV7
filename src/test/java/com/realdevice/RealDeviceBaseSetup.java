package com.realdevice;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.PrimitiveIterator.OfDouble;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class RealDeviceBaseSetup {
	public DesiredCapabilities cap = null;
	public AndroidDriver<AndroidElement> driver = null;

	public RealDeviceBaseSetup() {
		System.out.println("Base Device Setup in progress..");
	}

	@BeforeSuite
	public void setup() throws MalformedURLException {
		System.out.println("=================Before Suite=======================");
		cap = new DesiredCapabilities();
		File file = new File(System.getProperty("user.dir") + "/apks");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.getAbsolutePath());
		File file1 = new File(file, "ApiDemos-debug.apk");

		System.out.println(file1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API32");
		cap.setCapability(MobileCapabilityType.APP, file1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("=================After Suite=======================");

		driver.quit();
		System.out.println("Driver is closed.");
		System.out.println("=================Driver Closed=======================");
	}

	public void touch(WebElement ele, String strAction) {
		TouchAction touch = new TouchAction(driver);

//		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele))).perform();
//		or
		try {
			if (strAction.equalsIgnoreCase("touch"))
				touch.tap(tapOptions().withElement(element(ele))).perform();
			else if (strAction.equalsIgnoreCase("longpress")) {
				touch.longPress(LongPressOptions.longPressOptions().withElement(element(ele)).withDuration(Duration.ofSeconds(2)))
						.release().perform();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}

//		or simply click
//		ele.click();
	}

	
}
