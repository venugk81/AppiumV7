package com.tapmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.BaseSetup;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AndroidUIAutomatorScrollIntoView extends BaseSetup {
	
	
	@Test
	public void f() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform(); // tab on Views Link or option

		try {

			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));"));
			Thread.sleep(1000);			
			driver.findElement(MobileBy.AccessibilityId("Visibility")).click();
//resoucrce id is id
			//accessibility id is different
			
			//http://code2test.com/appium-tutorial/how-to-use-uiselector-in-appium/
			//https://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-simple/
			
		} catch (Exception oexp) {
			oexp.printStackTrace();
		}
		Thread.sleep(3000);
	}

	public static void print(String txt) {
		System.out.println(txt);
	}
}
