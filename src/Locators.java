import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         WebDriver driver = new ChromeDriver();
         
         //below line wait for objects to show in page
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         String url = "https://www.scopay.com/login";
         String scopayusernameid= "userName";
         String scopayusernameidvalue = "nndnrwt@gmail.com";
         String scopay_password_id = "password";
         String Loginbuttonclass = "loginButton";
         String css_selector_for_error_msg =  "li#errorMessage1";
         
         driver.get(url);
         driver.findElement(By.id(scopayusernameid)).sendKeys(scopayusernameidvalue);
         driver.findElement(By.id(scopay_password_id)).sendKeys("password");
         driver.findElement(By.className(Loginbuttonclass)).click();
         driver.findElement(By.cssSelector(css_selector_for_error_msg)).getText();
         //li#errorMessage1
         System.out.println(driver.findElement(By.cssSelector(css_selector_for_error_msg)).getText());
         
         //check linktext
         
         //driver.findElement(By.linkText("See our frequently asked questions")).click();
         
        
         //xpath example
         
        driver.findElement(By.xpath("//input[@value=\"I've forgotten my password\"]")).click();
        //enter email
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(scopayusernameidvalue);
        //driver.findElement(By.xpath("//input[@name=\"email\"]")).clear();
        driver.findElement(By.xpath("//input[@value=\"Reset password\"]")).click();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(driver.findElement(By.xpath("//li[@id=\"errorMessage1\"]")).getText());
        
      
	}

}
