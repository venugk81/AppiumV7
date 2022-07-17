package com.swiggy;

import java.util.List;

import org.aspectj.asm.IProgramElement.Accessibility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.base.BaseSetup;


import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class FirstTapScriptOnSample extends RealDeviceBaseSetupSamsung {
	@Test
	public void f() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform();

		Actions act = new Actions(driver);

		WebElement ele1 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']"));
		WebElement ele2 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']"));
		act.clickAndHold(ele2).moveToElement(ele1).build().perform();

		touch(ele2, "touch");
		Thread.sleep(1000);
		ele2 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']"));
		
		/*
		 * //////////version 7+ in appium 8+, it is
		 * driver.findElement(AppiumBy.accessibilityId("Checkbox 2")).click();
		 */
		try {
		touch(ele2, "touch");
		ele2 = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));		// this touch is an attribute.. 
						////	we are not getting element by text like we do in selenium for web elements. so don't use @text()='something'
		touch(ele2, "longpress");

		boolean flag = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed();
		System.out.println("is Sample Menu popup item displayed: "+ flag);
				
		}catch(Exception oexp) {
			oexp.printStackTrace();
		}
		Thread.sleep(3000);
	}

	public static void print(String txt) {
		System.out.println(txt);
	}
}
