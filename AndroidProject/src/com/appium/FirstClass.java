package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		driver.findElementById("io.selendroid.testapp:id/my_text_field").sendKeys("Appium");
		driver.findElementById("io.selendroid.testapp:id/waitingButtonTest").click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.selendroid.testapp:id/inputUsername")));
		driver.findElementById("io.selendroid.testapp:id/inputUsername").sendKeys("Srinu");
		driver.findElementById("io.selendroid.testapp:id/inputEmail").sendKeys("a@b.com");
		driver.findElementById("io.selendroid.testapp:id/inputPassword").sendKeys("123456");
		WebElement name=driver.findElementById("io.selendroid.testapp:id/inputName");
		name.clear();
		name.sendKeys("Srinu");
		driver.hideKeyboard();
		driver.findElementById("io.selendroid.testapp:id/input_preferedProgrammingLanguage").click();
		driver.findElementByName("Java").click();
		driver.findElementById("io.selendroid.testapp:id/input_adds").click();
		driver.findElementById("io.selendroid.testapp:id/btnRegisterUser").click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElementById("io.selendroid.testapp:id/buttonRegisterUser").click();
		
	}

}