

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesClass88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//objective -- capture email id from child window and paste in parent window
		String url = "https://rahulshettyacademy.com/loginpagePractise/";
		String username = "rahulshettyacademy";
		String password = "learning";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement((By.xpath("//a [@href='https://rahulshettyacademy.com/documents-request']"))).click();
	     Set<String> windows = driver.getWindowHandles(); //parentid and childid in Set
	     
	     //iterator method will pull all windows id from Set data structure
	     Iterator<String> it = windows.iterator();
	     String parentWindowId = it.next();
	     String childWindowId = it.next();
	     driver.switchTo().window(childWindowId);
	     
	     
	     WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='im-para red']")));
	    System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
	     //String paragraph = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
	     
	     String email = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	     driver.switchTo().window(parentWindowId);
	     
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	     driver.findElement(By.id("username")).sendKeys(email);
	}

}
