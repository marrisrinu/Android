package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Bouncingballs {
	

	public static void main(String[] args) throws InterruptedException {
		Dimension size;
		System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");
		System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", ".ApiDemos");
		cap.setCapability("appPackage", "io.appium.android.apis");
		
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(service.getUrl(), cap);
//		driver.findElementByName("Animation").click();
//		driver.findElementByName("Bouncing Balls").click();
		TouchAction act=new TouchAction(driver).tap(354,173).waitAction(1500);
//		driver.performMultiTouchAction(new MultiTouchAction(driver).add(new TouchAction(driver).tap(347, 754)).add(new TouchAction(driver).tap(347, 754).perform()));
		driver.findElementByName("Views").click();
		Thread.sleep(2000);
		size = driver.manage().window().getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.80);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		  for(int i=0; i<size.getHeight(); i++){
		  driver.swipe(startx, starty, startx, endy, 3000);
		  if(driver.findElementsByName("Seek Bar").size()>0)
			  break;
		  }
		  driver.findElementByName("Seek Bar").click();
		  Thread.sleep(2000);
		  driver.performTouchAction(new TouchAction(driver).longPress(354, 173).moveTo(458, 176).release().perform() );
		  
		  
		
		
//		driver.closeApp();

	}

}
