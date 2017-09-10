package com.pack.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharingFromHomePage 
{
	public WebDriver driver;
	
	public SharingFromHomePage(WebDriver driver) 
	{
		this.driver=driver;
	}

//*****************************FB Service*****************************//		
	public void clickonFBbutton() throws InterruptedException
	{
		Thread.sleep(10000);
		//click on S&S Widget
		WebElement widgetclick= driver.findElement(By.xpath("//div[contains(@id,'s4-widget-div-inner-up')]"));
		widgetclick.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        // Switch to ParentFrame
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe"))) ;
		Thread.sleep(6000);
		//Click on FB button
		WebElement rootWebElement = driver.findElement(By.id("sa-s4-facebook"));
		List<WebElement> linkElements = rootWebElement.findElements(By.tagName("a"));		 
	    
		for(WebElement element : linkElements)			
		 {			
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("arguments[0].click();", element);			
		    break;
		 }			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	public void fbLogin() throws InterruptedException
	{
	    Thread.sleep(6000);  
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Thread.sleep(6000);
	    
		//String parentwindow=driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		  for(String handle : winHandles) 
		  {
			  driver.switchTo().window(handle);
		  }		  

		//Enter input in Email field
	    WebElement Emailtextbox= driver.findElement(By.xpath("//input[@id='email']"));
		String f_email= "sophiadavis.sa@gmail.com";
		Emailtextbox.getAttribute("name");
		JavascriptExecutor f_jst = (JavascriptExecutor) driver;
		f_jst.executeScript("arguments[1].value = arguments[0]; ", f_email, Emailtextbox );		 
		Thread.sleep(2000);
	    
	    //Enter input in Pawd field
	    WebElement passwdtextbox=driver.findElement(By.xpath("//input[@id='pass']"));
	    String f_Pwd= "immply@123";
	    passwdtextbox.getAttribute("name");
		JavascriptExecutor fb_jst = (JavascriptExecutor) driver;
		fb_jst.executeScript("arguments[1].value = arguments[0]; ", f_Pwd, passwdtextbox );
   
	    //click on Login button
	    driver.findElement(By.xpath(".//*[@id='u_0_2']")).click();	
	    Thread.sleep(5000);  
	}
	
	public void fBShare() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(1));
	  
		Set<String> winHandles = driver.getWindowHandles();
		driver.switchTo().window(new ArrayList<String>(winHandles).get(0));		   
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("s4-main-iframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".FB_UI_Dialog")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement PostBtn= driver.findElement(By.xpath("//button[contains(.,'Post to Facebook')]"));
		Thread.sleep(6000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",PostBtn);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Close thank you pop up
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(@id,'sa_s4_popup_close')]")).click();
		Thread.sleep(5000);
	}
	public void fBthankYouMsg() 
	{
		System.out.println("Thank You for Sharing with Facebook!");
	}

//****************************TwitterShare******************************//
	
	public void clickontweetbutton() throws InterruptedException 
	{	
		Thread.sleep(5000);
		WebElement widgetclick= driver.findElement(By.xpath("//div[@id='s4-widget-div-inner-up']"));
		widgetclick.click();
		Thread.sleep(2000);
		
		//switch to main iframe
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe"))) ;
		Thread.sleep(6000);
		//click on Tweet button
		WebElement tweetButton=driver.findElement(By.id("sa-s4-twitter"));		
		List<WebElement> linkElements = tweetButton.findElements(By.tagName("a"));
		 
		for(WebElement element : linkElements)			
		 {			
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("arguments[0].click();", element);			
		    break;
		 }
		Thread.sleep(2000);
	}
	public void twitterLogin() throws InterruptedException
	{
		Thread.sleep(6000);
		String parentwindow=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
	    } 
		Thread.sleep(6000);
		//Enter input in Email field
		WebElement emailTextbox= driver.findElement(By.xpath("//*[@id='username_or_email']"));
		String tweetemail= "sophiadavis.sa@gmail.com";
		emailTextbox.getAttribute("name");
		JavascriptExecutor jst = (JavascriptExecutor) driver;
		jst.executeScript("arguments[1].value = arguments[0]; ", tweetemail, emailTextbox );		 
		Thread.sleep(2000);
	
		//Enter input in Pawd field
		WebElement passwdTextbox= driver.findElement(By.xpath("//input[@id='password']"));
		String pswd= "immply1234";
		passwdTextbox.getAttribute("name");
		JavascriptExecutor jstpwd = (JavascriptExecutor) driver;
		jstpwd.executeScript("arguments[1].value = arguments[0]; ", pswd, passwdTextbox );		 
		Thread.sleep(2000);

		//click on Login button
		driver.findElement(By.xpath(".//*[@id='allow']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentwindow);
		// to switch back in iframe
		driver.switchTo().defaultContent(); 
		Thread.sleep(2000);
	}

	public void twitterShare() throws InterruptedException 
	{	
		driver.switchTo().frame("s4-main-iframe");
        Thread.sleep(1000);       
        // enter First Name
		WebElement firstName= driver.findElement(By.xpath("//*[@id='sa_s4_first_name_share']"));
		String FName= "Michael";
		firstName.getAttribute("name");
		JavascriptExecutor jst_fName = (JavascriptExecutor) driver;
		jst_fName.executeScript("arguments[1].value = arguments[0]; ", FName, firstName );		 
		Thread.sleep(1000);

		// enter Last Name
        WebElement LastName=driver.findElement(By.xpath("//*[@id='sa_s4_last_name_share']"));
        String LName= "Roy";
        LastName.getAttribute("name");
		JavascriptExecutor jst_LName = (JavascriptExecutor) driver;
		jst_LName.executeScript("arguments[1].value = arguments[0]; ", LName, LastName );		 
		Thread.sleep(1000);

        WebElement youremailtextbox=driver.findElement(By.xpath("//*[@id='sa_s4_your_email_share']"));			        
        String email= "michaelroy.sa@gmail.com";
        youremailtextbox.getAttribute("name");
		JavascriptExecutor jst_email = (JavascriptExecutor) driver;
		jst_email.executeScript("arguments[1].value = arguments[0]; ", email, youremailtextbox );		 
		Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();	
        Thread.sleep(10000);
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
      
        //close Thank you pop up
        driver.findElement(By.xpath("//div[contains(@id,'sa_s4_popup_close')]")).click();
        Thread.sleep(6000);
	}
	public void thankYouMsg() 
	{
		System.out.println("Thank You for Sharing with Twitter!");
	}
	
//****************************PinShare******************************//
	
    public void pinShare() throws InterruptedException 
	{
        Thread.sleep(6000);
		WebElement widget= driver.findElement(By.xpath("//div[@id='s4-widget-div-inner-up']"));
		widget.click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe"))) ;
		WebElement rootWebElement = driver.findElement(By.id("sa-s4-pin"));
		List<WebElement> linkElements = rootWebElement.findElements(By.tagName("a"));
		
		for(WebElement element : linkElements)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("arguments[0].click();", element);
			break;
	
		}
		Thread.sleep(6000);
		//Enter input in FirstName field
		WebElement FirstNametextbox= driver.findElement(By.xpath("//*[@id='sa_s4_first_name_share']"));
		String Firstname= "Michael";
		FirstNametextbox.getAttribute("name");
		JavascriptExecutor jst_fstName = (JavascriptExecutor) driver;
		jst_fstName.executeScript("arguments[1].value = arguments[0]; ", Firstname, FirstNametextbox );		 
		Thread.sleep(1000);
		
		//Enter input in LastName field
		WebElement LastNameTextbox= driver.findElement(By.xpath("//input[@id='sa_s4_last_name_share']"));
		String Lastname= "Roy";
		LastNameTextbox.getAttribute("name");
		JavascriptExecutor jst_lstName = (JavascriptExecutor) driver;
		jst_lstName.executeScript("arguments[1].value = arguments[0]; ", Lastname, LastNameTextbox );		 
		Thread.sleep(1000);
		
		//Enter input in Your Email field
		WebElement YourEmailTextbox=driver.findElement(By.xpath("//input[@id='sa_s4_your_email_share']"));
		String yourEmail= "michaelroy.sa@gmail.com";
		LastNameTextbox.getAttribute("name");
		JavascriptExecutor jst_youremail = (JavascriptExecutor) driver;
		jst_youremail.executeScript("arguments[1].value = arguments[0]; ", yourEmail, YourEmailTextbox );		 
		Thread.sleep(1000);
		
		//Enter input in Username field
		WebElement UsernameTextbox=driver.findElement(By.xpath("//input[@id='sa_s4_pin_user_name']"));
		String userName= "michaelroysa";
		LastNameTextbox.getAttribute("name");
		JavascriptExecutor jst_userName = (JavascriptExecutor) driver;
		jst_userName.executeScript("arguments[1].value = arguments[0]; ", userName, UsernameTextbox );		 
		Thread.sleep(1000);
		
		//click on Share button (Submit form)
		driver.findElement(By.xpath(".//*[@id='pinShareForm']/div/div[5]/a")).submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  
	}
    
	public void pinterestLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		// Switch to new Pinit window
		String parentwindow=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);		
		//Login with Pinterest Account
		
		//Enter input in Email field
        WebElement pinEmailTextbox= driver.findElement(By.xpath("//*[@id='userEmail']"));
		String pinemail= "michaelroy.sa@gmail.com";
		pinEmailTextbox.getAttribute("name");
		JavascriptExecutor jst_pinlogin = (JavascriptExecutor) driver;
		jst_pinlogin.executeScript("arguments[1].value = arguments[0]; ", pinemail, pinEmailTextbox );		 
		Thread.sleep(1000);
		
		//Enter input in Pawd field
		WebElement pinPasswdTextbox=driver.findElement(By.xpath("//input[contains(@id,'userPassword')]"));
		String pinpwd= "Test@1234";
		pinPasswdTextbox.getAttribute("name");
		JavascriptExecutor jst_pinpwd = (JavascriptExecutor) driver;
		jst_pinpwd.executeScript("arguments[1].value = arguments[0]; ", pinpwd, pinPasswdTextbox );		 
		Thread.sleep(2000);
		
		//click on signup button
		WebElement signupBtn= driver.findElement(By.xpath("//button[@class='Button Module btn hasText medium primary large userRegisterButton continueButton rounded']"));
		signupBtn.click();
		Thread.sleep(10000);
//	---------------------------------------------------------//	
		//Click on pinit Btn		
		WebElement pinitBtn= driver.findElement(By.xpath("//button[@class='Button Module btn hasText isBrioFlat pinitLocalization primary primaryOnHover repinSmall repinBtn rounded']"));
		pinitBtn.click();
		Thread.sleep(30000);	
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(6000);
		// to switch back in iframe
		driver.switchTo().defaultContent(); 
		Thread.sleep(6000);
		//close thank you pop up
        driver.findElement(By.xpath("//div[contains(@id,'sa_s4_popup_close')]")).click();
        Thread.sleep(6000);
	}
	
	public void pinitThankYouMsg() 
	{
		System.out.println("Thank You for Sharing with Pinterest!");
	}
	
//****************************EmailShare******************************//			
	
	public void clickonemailShareBtn() throws InterruptedException 
	{
		Thread.sleep(6000);
		// Click on Widget
		WebElement sas_widget= driver.findElement(By.xpath("//div[@id='s4-widget-div-inner-up']"));
		sas_widget.click();
		Thread.sleep(5000);
        // Switch to frame
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe"))) ;
		WebElement rootWebElement = driver.findElement(By.id("sa-s4-email"));
		List<WebElement> linkElements = rootWebElement.findElements(By.tagName("a"));
		 
		for(WebElement element : linkElements)
		{
			 JavascriptExecutor js = (JavascriptExecutor)driver; 
			 js.executeScript("arguments[0].click();", element);
		     break;
		} 		
	}
    public void emailSignup() throws InterruptedException
    {
	    //Fill up Email form 
		Thread.sleep(5000);
		//Enter input in FirstName field
	    WebElement E_FNameTbox =driver.findElement(By.xpath("//*[@id='sa_s4_first_name_share']"));
	    String emailfname= "Michael";
	    E_FNameTbox.getAttribute("name");
		JavascriptExecutor jst_emailfname = (JavascriptExecutor) driver;
		jst_emailfname.executeScript("arguments[1].value = arguments[0]; ", emailfname, E_FNameTbox );	
		Thread.sleep(2000);
		
	    //Enter input in LastName field
	    WebElement emailLName_Tbox=driver.findElement(By.xpath("//input[@id='sa_s4_last_name_share']"));
	    String emailLname= "Roy";
	    emailLName_Tbox.getAttribute("name");
		JavascriptExecutor jst_emailLname = (JavascriptExecutor) driver;
		jst_emailLname.executeScript("arguments[1].value = arguments[0]; ", emailLname, emailLName_Tbox );
		Thread.sleep(2000);

	    //Enter input in Your Email field
	    WebElement yourEmailTbox=driver.findElement(By.xpath("//input[@id='sa_s4_your_email_share']"));
	    String useremail= "michaelroy.sa@gmail.com";
	    yourEmailTbox.getAttribute("name");
		JavascriptExecutor jst_useremail = (JavascriptExecutor) driver;
		jst_useremail.executeScript("arguments[1].value = arguments[0]; ", useremail, yourEmailTbox );
		Thread.sleep(2000);

	    //Enter input in Share with field
	    WebElement shareWithtextbox =driver.findElement(By.xpath("//textarea[@placeholder='Email addresses separated by comma, max 50 at a time']"));
	    String senderEmail= "sophiadavis.sa@gmail.com";
	    shareWithtextbox.getAttribute("name");
		JavascriptExecutor jst_senderEmail = (JavascriptExecutor) driver;
		jst_senderEmail.executeScript("arguments[1].value = arguments[0]; ", senderEmail, shareWithtextbox );
		Thread.sleep(2000);

	    //click on Share button (Submit form)
	    WebElement sharebutton =driver.findElement(By.xpath(".//*[@id='em-form']/form/div/div[6]/button"));
	    sharebutton.submit();  
	    Thread.sleep(10000);
	}
  
   	public void emailThankYouMsg() 
   	{
   		System.out.println("Thank You for Sharing with Email!");
	}

}
