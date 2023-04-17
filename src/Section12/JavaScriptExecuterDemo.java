package Section12;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecuterDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//first initialize JavaScriptExecuter object that will help to javascript related code
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//we can write simple script in javascript to scroll as below
		
		js.executeScript("window.scrollBy(10, 400)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		List<WebElement> amountsToAdd = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
	
		int sum = 0;
	      for(int i =0; i < amountsToAdd.size(); i++) {
	    	  
	    	 int value = Integer.parseInt(amountsToAdd.get(i).getText());
	    	 
	    	 sum = sum + value;
	    	 
	      }
	      
	      System.out.println(sum);
	      
	    int sumvalue = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
	      
	    System.out.println(sumvalue);
	    Assert.assertEquals(sum, sumvalue);
	}

	
	
	
}
