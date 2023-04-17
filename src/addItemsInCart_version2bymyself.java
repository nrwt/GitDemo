import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addItemsInCart_version2bymyself {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String promocode = "rahulshettyacademy";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsAddedToCart = {"Brocolli", "Cauliflower", "Cucumber"};
		Thread.sleep(3000);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//create object of class to call non static methods of that class
		addItemsInCart_version2bymyself classObject = new addItemsInCart_version2bymyself();
		
		classObject.addItems(driver, itemsAddedToCart);
		driver.findElement(By.cssSelector("img[alt = 'Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        //applied implicit wait above
       // Thread.sleep(2000);
        //then applied expliciti wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys(promocode);
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        //Thread.sleep(7000);
    	
    	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        String text = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        System.out.println();
        System.out.println(text);
	}
	
	
	public void addItems(WebDriver driver, String[] itemsAddedToCart) throws InterruptedException {
		
		List<WebElement> vegetables = driver.findElements(By.xpath("//h4[@class='product-name']"));
		Thread.sleep(2000);
		//print out -- Brocolli - 1kg
		System.out.println(vegetables.get(0).getText());
					
		int j = 1;
		for(int i = 0; i < vegetables.size(); i++) 
		{
			
			List<String> list = Arrays.asList(itemsAddedToCart);
			String[] stringsplit = vegetables.get(i).getText().split(" ");
			String actual_veg_name = stringsplit[0];
			//Thread.sleep(2000);
			//System.out.print(" "+actual_veg_name);
			
			if(list.contains(actual_veg_name)) {
				
				System.out.print(" "+actual_veg_name);
				Thread.sleep(3000);
				//click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j == itemsAddedToCart.length) 
				{
				break;
				}
				
				j++;
			}
			
		}
			
		
	}

}
