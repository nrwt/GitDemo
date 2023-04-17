package Section11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		
		//1.give me count of link on this webpage
		
		getLinkCount(driver);
		
		//2.below method is one way of doing that.. another way is below this method
		getLinkCountInFooterSection(driver);
		
		//here we limit the webDriver scope
		WebElement footerSectiondriver = driver.findElement(By.cssSelector("div[class=' footer_top_agile_w3ls gffoot footer_style']"));
		getLinkCount(footerSectiondriver);
		
		
		//3. give count of only first column in footersection
		WebElement firstsection = driver.findElements(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']/table/tbody/tr/td/ul")).get(0);
	    int i = firstsection.findElements(By.tagName("a")).size();
	    System.out.println("Link count in first column of footersection is "+i);
	    
	    //3
	    
	    WebElement columndriver = footerSectiondriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
	    getLinkCount(columndriver);
	    
	    //4 . click on each link in first column and check if page is working
	    
	    int countlink = columndriver.findElements(By.tagName("a")).size();
	   
	    for(int j =1; j < countlink; j++ ) {
	    	
	    	//click on link 
	    	String clickOnLinkTab= Keys.chord(Keys.CONTROL, Keys.ENTER);
	    	columndriver.findElements(By.tagName("a")).get(j).sendKeys(clickOnLinkTab);
	    	Thread.sleep(1000);
	    	
	    	
	     }
	    
	    Set<String> windows = driver.getWindowHandles();
    	Iterator<String> Itr = windows.iterator();
    	
    	while(Itr.hasNext()){
    		
    		driver.switchTo().window(Itr.next());
    		System.out.println(driver.getTitle());
    	}
	    
    	driver.quit();
	    
	    }
	
	public static int getLinkCount(WebDriver driver) {
		
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("Link count in page is "+count);
		return count;
		
		
	}
	
public static int getLinkCount(WebElement driver) {
		
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("another method to get Link count in footersection is "+count);
		return count;
		
		
	}
	
public static int getLinkCountInFooterSection(WebDriver driver) {
		
		int count = driver.findElements(By.cssSelector("div[class=' footer_top_agile_w3ls gffoot footer_style'] a")).size();
		System.out.println("Link count in footer section of page is "+count);
		return count;
		
		
	}

}
