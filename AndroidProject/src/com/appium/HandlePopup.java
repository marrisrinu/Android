package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlePopup {

	public static void main(String[] args) throws MalformedURLException {
File file=new File("D:\\Softwares\\Android\\selendriodapk\\selendroid-test-app-0.17.0.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", ".HomeScreenActivity");
		cap.setCapability("appPackage", "io.selendroid.testapp");
		
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.findElementById("io.selendroid.testapp:id/showPopupWindowButton").click();
		driver.findElementById("io.selendroid.testapp:id/showPopupWindowButton").click();
		driver.findElementById("io.selendroid.testapp:id/exceptionTestButton").click();
		driver.findElementById("android:id/button1").click();
		driver.closeApp();
		driver.launchApp();

	}

}
