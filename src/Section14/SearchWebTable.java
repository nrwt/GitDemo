package Section14;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//id="search-field"
		
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String search = "Rice";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='#/offers']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@role='columnheader'][1]")));
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		driver.findElement(By.id("search-field")).sendKeys(search);
		List<WebElement> vegandfruits = driver.findElements(By.xpath("//tr/td[1]"));
		/*vegandfruits.stream().map(s->s.getText()).forEach(s-> System.out.print(s+" "));
		System.out.println();
		System.out.println("**********************");
		System.out.println();
		Thread.sleep(5000);
		
		Thread.sleep(5000);*/
		//List<WebElement> searchlist = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> searchlist = vegandfruits.stream().filter(veg->veg.getText().contains(search))
		.collect(Collectors.toList());
		//searchlist.stream().map(s->s.getText()).forEach(s-> System.out.print(s+" "));
		Assert.assertEquals(vegandfruits.size(), searchlist.size());
		
	}

}
