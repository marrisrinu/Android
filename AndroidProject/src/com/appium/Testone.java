package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Testone {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");
		System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", ".HomeScreenActivity");
		cap.setCapability("appPackage", "io.selendroid.testapp");
		
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(service.getUrl(), cap);
		driver.findElementById("io.selendroid.testapp:id/touchTest").click();
//		driver.findElementById("io.selendroid.testapp:id/scale_factor_text_view");
		TouchAction act=new TouchAction(driver).tap(368,604).waitAction(1500);
		driver.performMultiTouchAction(new MultiTouchAction(driver).add(act).add(new TouchAction(driver).tap(368, 604).perform()));
		
//		driver.closeApp();
	}

}
