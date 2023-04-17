import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
		String username = "rahul";
       //below line wait for objects to show in page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String pwd = getpassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(username);

		driver.findElement(By.name("inputPassword")).sendKeys(pwd);

		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String s = driver.findElement(By.tagName("p")).getText();
		
	    System.out.println(s);
		Assert.assertEquals(s,"You are successfully logged in.");
		
		String s1 = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		System.out.println(s1);
		Assert.assertEquals(s1, "Hello "+username+",");
		
		 driver.findElement(By.className("logout-btn")).click();
		 driver.close();
		
		//------------------------------------------------------------------
		/*forget password section
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John.rwt@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        
		String s4= driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//String pwd= s4.su
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys(username);

		driver.findElement(By.name("inputPassword")).sendKeys("arahulshettyacademy");

		String s = driver.findElement(By.tagName("p")).getText();
	
	    System.out.println(s);
		Assert.assertEquals(s,"You are successfully logged in.");
		
	String s1 = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
	Assert.assertEquals(s1, "Hello "+username+",");
	
	 driver.findElement(By.className("logout-btn")).click();
	 driver.close(); */
		//-------------------------------------------------------------------------------	 
				
	}
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordtext = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		System.out.println(passwordtext);
		//Please use temporary password 'rahulshettyacademy' to Login.'rahulshettyacademy' to Login.
		
		String[] li =  passwordtext.split("'");
		
		 //li[0] = Please use temporary password '
		 //li[1] = rahulshettyacademy' to Login.
		
		String[] passwordtextarray = li[1].split("'");
		String pwd = passwordtextarray[0];
		System.out.println(pwd);
		
		return pwd;
		
	}

}
