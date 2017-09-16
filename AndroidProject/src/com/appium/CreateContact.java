package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

import org.openqa.selenium.WebElement;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		UDF u=new UDF();
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
		.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
		.withLogFile(new File("D:\\Log.txt"))
		.withIPAddress("127.0.0.1")
		.usingPort(4777));  //4723 appium default port number
		service.start();
		u.userDefinedFunction("Appium", "52030400eee66379", "Android", "6.0", ".activities.PeopleActivity", "com.android.contacts");
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(service.getUrl(), u.cap);
		driver.findElementById("com.android.contacts:id/floating_action_button").click();
		driver.findElementByName("Name").sendKeys("Srinuvas Marri");
		driver.findElementByName("Phone number").sendKeys("12345678");
		driver.findElementByName("Email").sendKeys("a@b.com");
		driver.hideKeyboard();
		Thread.sleep(2000);
//		driver.findElementByName("Groups").click();
//		driver.findElementByName("Family").click();
//		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementByName("More").click();
		driver.findElementByName("Ringtone").click();
		driver.findElementByName("Basic Bell").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
//		driver.findElementByName("Save").click();
		
		
		

	}

}
