package com.appium;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwipeScreen {
	Dimension size;
	AppiumDriver<WebElement> driver;
	SwipeScreen(AppiumDriver<WebElement> d){
		driver=d;
		
	}
	public void seekbar(){
		
		  
		  driver.findElementByName("Views").click();
		  
		  while (!findingDiffViews("Seek Bar")){
		   swipeUp(driver);
		  }
		  
		  driver.performTouchAction(new TouchAction(driver).press(520, 190).perform());
		 }
		 
		 public boolean findingDiffViews(String viewName){
		  List<WebElement> textViewColl = driver.findElementsByClassName("android.widget.TextView");
		  boolean flag = false;
		  System.out.println(textViewColl.size());
		  for(int i=0; i<textViewColl.size(); i++){
		   if (textViewColl.get(i).getText().equals(viewName)){
		    textViewColl.get(i).click();
		    flag = true;
		    break;
		   }
		  }
		  return flag;
		 }
		public static void swipeUp(AppiumDriver<WebElement> driver) {
		  Dimension size = driver.manage().window().getSize();   
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  int startx = size.width / 2;
		  driver.swipe(startx, starty, startx, endy, 3000);
		 }
		 
		 public static void swipeDown(AppiumDriver<WebElement> driver) {
		  Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  int startx = size.width / 2;
		  driver.swipe(startx, endy, startx, starty, 3000);
		 }

	public static void main(String[] args) {
		
		
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
		
		SwipeScreen s=new SwipeScreen(driver);
		s.seekbar();
		
		

	}

}
