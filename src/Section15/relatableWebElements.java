package Section15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relatableWebElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		//String url = "https://rahulshettyacademy.com/angularpractice/";
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(1000);
		WebElement nameEditBox = driver.findElement(By.name("name"));
		
		//write actual locator.. for that we have to import one package
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement checkboxtext = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxtext)).click();
		
		WebElement radiobutton = driver.findElement(By.xpath("//input[@value='option1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText());
		
		WebElement DOB = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(DOB)).click();
	}

}
