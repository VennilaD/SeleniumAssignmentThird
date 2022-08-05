package com.gmoonline;

import org.testng.annotations.Test;


import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingAlerts extends Library{
	
	  @SuppressWarnings("deprecation")
	@Test(priority=0)
	  public void Alertvalidation() {
		  
		  System.out.println("inside Alertvalidation");
		  driver.navigate().to(objProperties.getProperty("chercheralertvalidation"));
		  driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeOut,TimeUnit.SECONDS);
		 String alertpagetitle = driver.getTitle();
		 System.out.println("alertpagetitle:"+alertpagetitle);
		 Assert.assertEquals(alertpagetitle, objProperties.getProperty("titleofalertwindow"));
			 
	  }
		 
	  @Test(priority=1	)
	  public void validationtypesofalerts() throws InterruptedException {
		  driver.findElement(By.name("alert")).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert normalAlert=driver.switchTo().alert();
		  String normalalertmessage=normalAlert.getText();
		  System.out.println("normalalertmessage :"+normalalertmessage);
		  Assert.assertEquals(normalalertmessage, objProperties.getProperty("alertmessageinaccepttype"));
		  normalAlert.accept();
		  
		  
		  driver.findElement(By.name("confirmation")).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert confirmalert=driver.switchTo().alert();
		  String confirmalerttitle=confirmalert.getText();
		  System.out.println("confirmalerttitle :"+confirmalerttitle);
		  Assert.assertEquals(confirmalerttitle,objProperties.getProperty("confirmalertmessage"));
		  confirmalert.dismiss();
		  
		  driver.findElement(By.name("prompt")).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert promptalert=driver.switchTo().alert();
		  promptalert.sendKeys(objProperties.getProperty("promptalersendkeys"));
		  promptalert.accept();
		  
	  }
		 
		
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  Library.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("insite beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (Exception e) {
	
		e.printStackTrace();
  }
  }

  @AfterSuite
  public void afterSuite() {
  }

}
