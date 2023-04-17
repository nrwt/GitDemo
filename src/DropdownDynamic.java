import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownDynamic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//lecture60-- handle checkbox
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		if (driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) {
			System.out.println("SeniorCitizen Discount checkbox already selected");
		}
		else {
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		}
		
		//driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		//driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		//driver.findElement(By.cssSelector("input[id*='chk_Unmr']")).click();
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Total number of checkboxes are "+checkboxes.size());
		
		
		
		////a[@value='MAA'] --chennai xpath
		//a[@value='BLR'] -- Banglore xpath
		
		//there are 2 chennai options with same xpaths in above url.. so in order to select second one we use following xpath
		//(//a[@value='MAA'])[2]
	// commenting first section	
	/*	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@value='MAA']")).click();
		//above line will give " element not interactable"--error, because there are 2 nodes or 2 elements with same x path
		//to clarify which option to choose, we need to change xpath as below
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();   */
		
	//-------------------------------------------------------------------------------------------------------------
		
		//as per instruction some team leads might not like the index put in code like a line above and will not approve your code
		//there is another way of doing that as below.
		//parent xpath and space then child xpath
		
		//to select first chennai value xpath is below
		//div[@id="ctl00_mainContent_ddl_originStation1_CTNR"] //a[@value='MAA']
		
		//to select second chennai value xpath is below
		//div[@id="ctl00_mainContent_ddl_destinationStation1_CTNR"] //a[@value='MAA']
		
		//----------------------------------------------------------------------------------------
		
		//another way of doing it as below
		
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//OR
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value='BLR']")).click();
		Thread.sleep(1000);
				
		
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='MAA']")).click();
		
		//select calender date
		//css select for current date --  .ui-state-default.ui-state-highlight
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
	}

}
