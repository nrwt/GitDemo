import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1_lecture62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Check the first  Checkbox and 
		//verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected(), true);
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected(), false);
		
		//2== How to get the Count of number of check boxes present in the page
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[id*='checkBoxOption']"));
		
		System.out.println("Total number of checkboxes in page are "+checkboxes.size());

	}

}
