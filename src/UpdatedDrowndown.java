import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the Testing Framework

public class UpdatedDrowndown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();		
		// round trip or one way trip
		//select round trip radio button
		
		//first of all check if destination date is enabled or not without clicking round trip
		//below line should return false as it should not be enabled
		//---commented later===System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		
		//Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected(), false);
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//now click on to roundtrip button
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//---added later--workaround to check if return date is enabled or disables
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//if output of print == display: block; opacity: 1;  == which means it is enabled
		//if output of print == display: block; opacity: 0.5;  == which means it is disabled
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		//check again if destination date calendar is enabled
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		//When run the test, both destination date fields selenium statements return true.. this is because as per 
		//selenium if something is disabled it should not get active when click on that...but in current html page,,
		//destination date field gets active even if it is disabled, hence selenium code not working here.
		
		
		//Now we comment out isEnabled satement abs use a workaround. Style attribute change explain in lecture
		
		
		
		
		//lecture60-- handle checkbox
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
				System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				if (driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) {
					System.out.println("SeniorCitizen Discount checkbox already selected");
				}
				else {
					driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
					System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				}
				
				Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
				System.out.println("Total number of checkboxes are "+checkboxes.size());
				
				
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	//Thread.sleep(1000L);
		int number_of_adults = 5 ;
		System.out.println("count after loop starts");
		Thread.sleep(1000L);
		
		for(int i =0; i < (number_of_adults-1); i++) 
		{
			
			driver.findElement(By.id("hrefIncAdt")).click();	
		}		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}
