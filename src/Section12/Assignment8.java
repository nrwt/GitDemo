package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String search = "India";
		driver.findElement(By.id("autocomplete")).sendKeys(search);
        Thread.sleep(1000);
		
        //driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);  --use this when search is united kingdom
        
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for(WebElement element : options) {
		
		if(element.getText().equalsIgnoreCase(search)) 
		{
			System.out.println(element.getText());
		    element.click();
		    break;
		}
	}
		Thread.sleep(1000);
		String actualtext =   driver.findElement(By.id("autocomplete")).getAttribute("value");
				
		//driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).getText();
				
		//driver.findElement(By.id("autocomplete")).getAttribute("value");  this works even if there is no attribute

		//driver.findElement(By.id("autocomplete")).getText();
		System.out.println("this is actual text "+ actualtext);
		Assert.assertEquals(actualtext, search);
	}

}
