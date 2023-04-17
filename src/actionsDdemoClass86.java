

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDdemoClass86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id=\"nav-link-accountList\"]"));
		
		//move to element and right click (contextclick)
		a.moveToElement(move).build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		//class 87 below
		WebElement searchbar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		//move to search bar and then click, then write hello in caps then double click
		a.moveToElement(searchbar).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		

	}

}
