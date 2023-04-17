import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_AddItemsInCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		String[] veg_int_cart = {"Beetroot", "Cucumber", "Cauliflower", "Beans"};
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		
		System.out.println("outside loop");
		
		for(int i = 0; i < veg_int_cart.length; i++) {
			
			for (int j =0; j < items.size(); j++)
			{
				System.out.println("inside 2nd for loop "+j+" times");
				//System.out.println(items.get(j).getText());
				String[] veg_name= items.get(j).getText().split(" ");
				System.out.println(veg_name[0]);
				//List<String> itemsInCart = Arrays.asList(veg_int_cart);
				System.out.print("compare "+veg_name[0]+" with "+veg_int_cart[i]);
			if(veg_int_cart[i].equalsIgnoreCase(veg_name[0])) 
			{
				System.out.println("--------------it matches   and break");
				System.out.println("*********************************************");
				Thread.sleep(1000);
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(j).click();
				//commented below one as can't rely on add to cart text
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(j).click();
				//add_to_cart_buttons.get(i).click();
				//Thread.sleep(5000);
				break;
				
			}
			
			System.out.print("-----NOT matches");
			System.out.println();
			}
			
		}
		
		
		
	}



public static String splitstring(String s)
{ 
  String[] veg_name = s.split(" ");
	s = veg_name[0];
	System.out.println(s);
	return s;
}
}
