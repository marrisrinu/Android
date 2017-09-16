package com.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WhasApp {
	
	static AppiumDriver<WebElement> driver;
	public static boolean findingDiffViews(String viewName){
		  List<WebElement> textViewColl = driver.findElementsById("com.whatsapp:id/conversations_row_contact_name");
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
	public static void swipeUp() {
		  Dimension size = driver.manage().window().getSize();   
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  int startx = size.width / 2;
		  driver.swipe(startx, starty, startx, endy, 3000);
		 }
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
		cap.setCapability("appActivity", ".HomeActivity");
		cap.setCapability("appPackage", "com.whatsapp");
		driver = new AndroidDriver<WebElement>(service.getUrl(),cap);
//		driver.findElementByName("Nandu").click();   ////*[@resource-id='com.whatsapp:id/contact_row_container' and @index='2']
		 while (!findingDiffViews("Bapatu Nagajyothi")){
			   swipeUp();
			  }
		/*driver.findElementById("com.whatsapp:id/entry").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementById("com.whatsapp:id/pickfiletype_gallery").click();
		driver.findElementById("com.whatsapp:id/entry").sendKeys("Mobile automation testing");
		driver.findElementById("com.whatsapp:id/send").click();*/
		
		
	}

}
