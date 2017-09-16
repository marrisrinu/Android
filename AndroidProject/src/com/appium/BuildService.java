package com.appium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BuildService {

	public static void main(String[] args) {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
		.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
		.withLogFile(new File("D:\\Log.txt"))
		.withIPAddress("127.0.0.1")
		.usingPort(4777));  //4723 appium default port number
		service.start();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		WebDriver driver = new AndroidDriver<WebElement>(service.getUrl(), cap);
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("marrisrinu1987@gmail.com");
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("9494679594");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		
		
	}

}
