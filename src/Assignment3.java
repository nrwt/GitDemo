import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https://rahulshettyacademy.com/loginpagePractise/";
		String username = "rahulshettyacademy";
		String password = "learning";
		
		WebDriver driver = new ChromeDriver();
		
		signInAsUser(driver, url, username, password);
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-info")));
		addItemsInCart(driver);
		

	
	}
	
	public static void signInAsUser(WebDriver driver, String url, String username, String password) throws InterruptedException {
		
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//select User
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[2]")).click();
		
		//driver.switchTo().alert().accept();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id(("okayBtn"))));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
				//Select class to handle Select dropdown. It will only work if dropdown in HTML page has Select tag
		WebElement staticdropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(staticdropdown);
		Thread.sleep(1000);
		dropdown.selectByValue("consult");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
	
		
	}
	
	public static void addItemsInCart(WebDriver driver) {
		
		//h4.card-title
		//(By.cssSelector("button.btn.btn-info")
		List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
		List<WebElement> buttons = driver.findElements(By.cssSelector("button.btn.btn-info"));
		
		System.out.println("Items added to the cart are following");
		for(int i = 0; i < items.size();i++) {
			
			System.out.println(items.get(i).getText());
			buttons.get(i).click();
			//buttons.get(i).click();
			
		}
		
		String[] totalItemAtCheckout = driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).getText().split(" ");
		
		
		System.out.println("Total items in checkout are "+totalItemAtCheckout[2]+" while items total is "+items.size());
		
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
			
		
		
	}

}
