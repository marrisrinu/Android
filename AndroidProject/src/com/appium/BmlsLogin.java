package com.appium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BmlsLogin {

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
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		WebDriver driver=new AndroidDriver<WebElement>(service.getUrl(), cap);
		driver.get("http://dev.v1.buyermls.com");									//sundeep:Gf3An9NiXU@
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("james@agent.com");
		driver.findElement(By.id("pswd")).sendKeys("*******");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//*[@id='headeruser-hamburger']")).click();
//		driver.findElement(By.xpath("//*[@id='headeruser-user']/a")).click();
//		driver.findElement(By.xpath("//*[@id='headeruser-user']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//a[contains(., 'Add')]")).click();
		driver.findElement(By.xpath("//a[contains(., 'Add Buyer')]")).click();
		Thread.sleep(1500);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("location")).sendKeys("33130");
		Thread.sleep(1000);
		List<WebElement> zip=driver.findElements(By.id("ui-id-1"));
		zip.get(0).click();
		driver.findElement(By.id("bedroom")).sendKeys("3+ Beds");
		driver.findElement(By.id("bathroom")).sendKeys("2+ Baths");
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[2]/div[1]/a")).click();
		driver.findElement(By.id("squareFootage")).sendKeys("600+ Square Feet");
		driver.findElement(By.id("floors")).sendKeys("2 Floor");
		driver.findElement(By.id("propertyAge")).sendKeys("New Construction");
		driver.findElement(By.id("parking")).sendKeys("min 1 car garage");
		driver.findElement(By.id("lotSize")).sendKeys("3/4+ acre");
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[2]/div[6]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[2]/div[7]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[2]/div[8]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.id("comment")).sendKeys("My Buyer");
		driver.findElement(By.xpath("//*[@id='prequalified0']")).click();
		driver.findElement(By.id("targetPrice")).sendKeys("150000");
		driver.findElement(By.id("maximumPrice")).sendKeys("250000");
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[4]/div[1]/a")).click();
		driver.findElement(By.id("downPayment")).sendKeys("60000");
		driver.findElement(By.id("monthlyPayment")).sendKeys("5000");
		driver.findElement(By.id("targetPurchaseDate")).click();
		WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
		  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
		  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		  
		  for (WebElement cell: columns){
		   //Select 13th Date 
		   if (cell.getText().equals("28")){
		   cell.findElement(By.linkText("28")).click();
		   break;
		   }
		  } 
		  Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='frmBuyer']/div[4]/div[6]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.xpath("//*[@id='frmBuyer']/div[4]/div[7]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.id("firstName")).sendKeys("Andrew");
		driver.findElement(By.id("lastName")).sendKeys("James");
		driver.findElement(By.id("primaryEmail")).sendKeys("a@b.com");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		
		driver.close();
		service.stop();
		
		

	}

}
