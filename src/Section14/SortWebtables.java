package Section14;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SortWebtables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
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
		
		List<WebElement> vegandfruits = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
	   /* int i=0;
	    int j =vegandfruits.size();
	    String[] li = new String[j];
		while(i < j){
			li[i] = vegandfruits.get(i).getText();
			//System.out.print(li[i]+" ");
			i++;
		}*/
		//Stream list1 = vegandfruits.stream().map(s->s.getText());
		List<String> originalList = vegandfruits.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("------------------------------------------------");
		//List<String> values = Arrays.asList(li);
		//Stream list1 = values.stream();
		vegandfruits.stream().map(s->s.getText()).forEach(s-> System.out.print(s+" "));
		System.out.println();
		System.out.println("------------------------------------------------");
		//Stream sortedlist = vegandfruits.stream().map(s->s.getText()).sorted();
		vegandfruits.stream().map(s->s.getText()).sorted().forEach(s-> System.out.print(s+" "));
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("done");
		Assert.assertEquals(originalList, sortedList);
		System.out.println("done");
		
		
		//get the price of potato
		
		List<WebElement> priceslist = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]"));
		
		//priceslist.stream().map(s->s.getText().contains("Beans")).collect(Collectors.toList());
		
		int size =0;
		do {
			
		List<WebElement> vegandfruitslist = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		List<String> price = vegandfruitslist.stream().filter(s->s.getText().contains("Tomato"))
		.map(s->getvegprice(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println(a));
		
		size = price.size();
		if(size<1) {
			driver.findElement(By.cssSelector("a[aria-label=\"Next\"]")).click();
			
		}		
		
		}while(size<1);
		
		
	}

	private static String getvegprice(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
