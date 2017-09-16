package com.appium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IRCTCApp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");
		System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", "cris.org.in.ima.activities.IRCTCConnectActivity");
		cap.setCapability("appPackage", "cris.org.in.prs.ima");
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(service.getUrl(),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("cris.org.in.prs.ima:id/book_ticket").click();
		driver.findElementById("cris.org.in.prs.ima:id/et_valid_pin").sendKeys("****");
		driver.findElementById("cris.org.in.prs.ima:id/tv_login").click();
		driver.findElementById("cris.org.in.prs.ima:id/from").click();
		driver.findElementById("cris.org.in.prs.ima:id/tv_search_text").sendKeys("sap");
		driver.findElementByXPath("//*[@resource-id='cris.org.in.prs.ima:id/tv_station_name' and @text='SATTENAPALLE']").click();
		/*List<WebElement> fromstations=driver.findElementsById("cris.org.in.prs.ima:id/rv_station_list");
		fromstations.get(0).click();*/
		driver.findElementByName("To").click();
		driver.findElementById("cris.org.in.prs.ima:id/tv_search_text").sendKeys("sc");
		driver.findElementByXPath("//*[@resource-id='cris.org.in.prs.ima:id/tv_station_name' and @text='SECUNDERABAD JN']").click();
		Thread.sleep(2000);
		driver.findElementByName("Journey Date").click();
		driver.findElementByName("30").click();
		driver.findElementById("android:id/button1").click();
		driver.findElementByName("Search Train").click();
		Thread.sleep(2000);
		driver.closeApp();
		service.stop();
	}

}
