package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//JavascriptExecutor initialisation will help me to scrollup or down in page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(10, 500)");
		
		
		List<WebElement> rows = driver.findElements(By.cssSelector("table[class='table-display'] tbody tr"));
		List<WebElement> columns = driver.findElements(By.cssSelector("table[class='table-display'] tbody tr th"));
		
		int totalrowsInTable = rows.size();
		int totalcolumnsInTable = columns.size();
		System.out.println("Total number of rows in Table are "+totalrowsInTable);
		System.out.println("Total number of columns in Table are "+totalcolumnsInTable);
		
		for(int i =0; i < rows.size(); i++) {
			
			//print second row of data
			
			if(i==2) {
				
				System.out.println(rows.get(i).getText());
				break;
			}
		}
	}

}
