import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Section9_class_84fluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
				   .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		       
           WebElement helloworld = driver.findElement(By.cssSelector("div[id='finish'] h4"));
		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if(helloworld.isDisplayed()) {
		       return helloworld;
		    	 }
		    	 else {
		    		 return null;
		    	 }
		     }
		   });
   System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed());
   System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
   
   
	}

}
