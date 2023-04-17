import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// Select From [delhi]
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value='DEL']"))
				.click();
		Thread.sleep(1000);

		// select to [chennai]
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='MAA']"))
				.click();

		// select calender date
		// css select for current date -- .ui-state-default.ui-state-highlight
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// check if destination date is enabled or disabled when round trip button is
		// disabled
		// if destination date is disabled == output of print will be -- display: block;
		// opacity: 0.5;
		// if destination date is enabled == output of print will be == display: block;
		// opacity: 0.1;
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// add adults 5

		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(1000);
		int number_of_adults = 5;
		System.out.println("count after loop starts");
		Thread.sleep(1000);

		for (int i = 0; i < (number_of_adults - 1); i++) {

			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), +number_of_adults + " Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// select currency INR

		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// select family and friends checkbox

		if (driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()) {
			System.out.println("SeniorCitizen Discount checkbox already selected");
		} else {
			driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
			System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		}

		// search flights

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
