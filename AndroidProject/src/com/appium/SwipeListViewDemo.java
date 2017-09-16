package com.appium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SwipeListViewDemo {
	static AppiumDriver<WebElement> driver;
	static Dimension size;
    static String folder_name;
    static DateFormat df;
	public static void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format fot screenshot file name
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");
		System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", ".sample.activities.SwipeListViewExampleActivity");
		cap.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		driver = new AndroidDriver<WebElement>(service.getUrl(),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement andsys=driver.findElementByName("Android System");
		TouchAction action=new TouchAction(driver);
		/*int start=andsys.getLocation().getX();
		int end=andsys.getSize().getWidth();
		int y=andsys.getLocation().getY();
        action.press(start,y).moveTo(end,y).release().perform();*/
		driver.performTouchAction(new TouchAction(driver).longPress(354, 543).perform() );
		
		
		

	}

}
