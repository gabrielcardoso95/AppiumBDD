package br.com.rsinet.hub_bdd.utils;

import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll {
	
	public static void scrollAndClick(AndroidDriver<?> driver, String visibleText) {
		driver.hideKeyboard();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}
	
	public static void scroll(AndroidDriver<?> driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	@SuppressWarnings("rawtypes")
	public static void swipe(int fromX, int fromY, int toX, int toY, AndroidDriver<?> driver) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(fromX, fromY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))) 
				.moveTo(PointOption.point(toX, toY)).release().perform();
	}

}