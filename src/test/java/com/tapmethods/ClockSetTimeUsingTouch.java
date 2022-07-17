package com.tapmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.BaseSetup;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.windows.PressesKeyCode;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ClockSetTimeUsingTouch extends BaseSetup {
	
	
	@Test
	public void f() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform(); // tab on Views Link or option

		try {
			
			

			driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
			driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
			driver.findElementByXPath("//*[@content-desc='9']").click();
			WebElement touchSource= driver.findElement(By.xpath("//*[@content-desc='15']"));
			WebElement touchDesti=driver.findElementByXPath("//*[@content-desc='45']");
			
//			touchSource.click();		//to click.. 
			//if you want to long press and then move to another element..
			touch.longPress(LongPressOptions.longPressOptions().withElement(element(touchSource)).withDuration(Duration.ofSeconds(2)))
			.moveTo(element(touchDesti)).release().perform();
			
//			http://code2test.com/appium-tutorial/touchaction-tap-and-longpress-in-appium/
//			http://code2test.com/appium-tutorial/vertical-and-horizontal-swipe-scroll-in-appium/
//			http://code2test.com/appium-tutorial/findelement-findelements-command-in-appium/
//			https://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-simple/
//			http://code2test.com/appium-tutorial/appium-mobile-device-commands/
			
			//https://appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
			
//			driver.hideKeyboard();
//			driver.getKeyboard();
			
			

		} catch (Exception oexp) {
			oexp.printStackTrace();
		}
		Thread.sleep(3000);
	}

	public static void print(String txt) {
		System.out.println(txt);
	}
}
