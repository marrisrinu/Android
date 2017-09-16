package com.appium;

import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

public class UDF {
	public static DesiredCapabilities cap;
	public void userDefinedFunction(String automationname, String devicename,String planame, String plaversion,String actity, String apppackage ){
		cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationname);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, planame);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, plaversion);
		cap.setCapability("appActivity", actity);
		cap.setCapability("appPackage", apppackage);
		
	}
	
 
}
