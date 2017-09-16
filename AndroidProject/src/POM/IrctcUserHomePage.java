package POM;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class IrctcUserHomePage {
	AppiumDriver<WebElement> driver;
	AppiumDriverLocalService service;
	IrctcLogin face;
  @Test
  public void f() throws InterruptedException, InvalidFormatException, IOException {
	  Utility excel=new Utility();
	  String pin=excel.getCellValue("C:\\Users\\Doyen12\\Desktop\\excelread.xlsx", "Sheet3", 1, 0);
	  String from=excel.getCellValue("C:\\Users\\Doyen12\\Desktop\\excelread.xlsx", "Sheet3", 1, 1);
	  String to=excel.getCellValue("C:\\Users\\Doyen12\\Desktop\\excelread.xlsx", "Sheet3", 1, 2);
	   face = new IrctcLogin(driver);
	   face.login(pin);
	   face.fromstations(from);
	   face.tostations(to);
	  
  }
  @Test
  public void ff() throws InterruptedException{
	  face.traveldate();
	  face.searchtrainslist();  
	  face.selectTrain();
	  face.classtype();
	  face.booknow();
	  face.passengerclick();
	  face.addPassengername();
	  face.addPassengerage();
	  face.passengerGender();
	  face.berthPreference();
	  face.berthType();
	  face.done();
	  face.bookticket();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");
		System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "52030400eee66379");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability("appActivity", "cris.org.in.ima.activities.IRCTCConnectActivity");
		cap.setCapability("appPackage", "cris.org.in.prs.ima");
		driver = new AndroidDriver<WebElement>(service.getUrl(), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  //driver.closeApp();
	  service.stop();
	  
  }

}
