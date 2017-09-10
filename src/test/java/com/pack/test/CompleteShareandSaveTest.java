package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pageObjects.SharingFromHomePage;


public class CompleteShareandSaveTest extends TestBaseSetup
{
	public WebDriver driver;
	public SharingFromHomePage obj;

	@BeforeClass
	public void setUp() 
	{
		driver=getDriver();
	}
//------------------------FBShare------------------------//	
	@Test(priority=1, description="Test Case-1")
	public void fBShare() throws InterruptedException
	{
		System.out.println("Starting Sharing with FB Service...");
		obj = new SharingFromHomePage(driver);
        obj.clickonFBbutton();
        obj.fbLogin();
        obj.fBShare();		
	}
	
	@Test(priority=2, description="Test Case-2")
	public void fBThankYouMsg()
	{
		obj = new SharingFromHomePage(driver);
		obj.fBthankYouMsg();
	}
		
//------------------------TwitterShare------------------------//	
	@Test(priority=3, description="Test Case-3")
	public void twitterShare() throws InterruptedException
	{
		System.out.println("Starting Sharing with Twitter Service...");
		obj = new SharingFromHomePage(driver);
		obj.clickontweetbutton();
		obj.twitterLogin();
		obj.twitterShare();				
	}
	
	@Test(priority=4, description="Test Case-4")
	public void tweetThankYouMsg()
	{
		obj = new SharingFromHomePage(driver);
		obj.thankYouMsg();
	}
//------------------------PinterestShare------------------------//	
	@Test(priority=5, description="Test Case-5")
	public void pinShare() throws InterruptedException
	{
		System.out.println("Starting Sharing with Pinterest Service...");
		obj = new SharingFromHomePage(driver);
		obj.pinShare();
		obj.pinterestLogin();		
	}
	
	@Test(priority=6, description="Test Case-6")
	public void pinThankYouMsg()
	{
		obj = new SharingFromHomePage(driver);
		obj.pinitThankYouMsg();
	}
//------------------------EmailShare------------------------//
	
	@Test(priority=7, description="Test Case-7")
	public void emailShare() throws InterruptedException
	{
		System.out.println("Starting Sharing with Email Service...");
		obj = new SharingFromHomePage(driver);
		obj.clickonemailShareBtn();
		obj.emailSignup();
	}
	
	@Test(priority=8, description="Test Case-8")
	public void emailThankYouMsg()
	{
		obj = new SharingFromHomePage(driver);
		obj.emailThankYouMsg();
	}	
	
}

