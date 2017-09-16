package com.appium;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServer {

	/**
	 * @param args
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(service.getUrl(),cap);
		driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/conversations_row_contact_name' and @text='Nandu']").click();
//		driver.findElementByName("Nandu").click();   ////*[@resource-id='com.whatsapp:id/contact_row_container' and @index='2']
//		driver.findElementById("com.whatsapp:id/entry").click();
		List<WebElement> tabList = driver.findElementsByClassName("android.widget.ImageButton");
		int n = tabList.size();
		for(int i=0;i<=n;i++)
		{
		tabList.get(1).click();
		driver.findElementById("com.whatsapp:id/pickfiletype_gallery").click();
		driver.findElementByName("Camera photos").click();
		List<WebElement> images=driver.findElementsByClassName("android.view.View");
		images.get(1).click();
		driver.findElementById("com.whatsapp:id/send").click();
		Thread.sleep(3000);
		break;
		}
		driver.closeApp();
		service.stop();
		
	}

}
