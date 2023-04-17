import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestivedropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		String search = "india";
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys(search);
		Thread.sleep(1000);
		
		List<WebElement> webelements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(int i = 0; i < webelements.size(); i++) {
			
			if(webelements.get(i).getText().equalsIgnoreCase(search)) {
				webelements.get(i).click();
				break;
				
			}
			
			
		} 
		
		/*for(WebElement element : webelements) {
			
			if(element.getText().equalsIgnoreCase(search)) 
			{
			element.click();
			break;
			}
		}*/
		
		
	}

}
