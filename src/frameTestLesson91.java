import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTestLesson91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("draggable")).click();
		
		//to find how many frames.. below is one line of code
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//after run..output of above line is 1..so we can also find frame by index as line below. it works already 
		//ran and verified, but it is not usually good practice so commented it out
		
		//driver.switchTo().frame(0);
		//when run above script it failed with following error:>
		//Exception in thread "main" org.openqa.selenium.NoSuchElementException: Unable to locate element: #draggable
		//WHY
		//reason behind that is its entire box is in frame
		//Frames are components which are hosted on html webpages. its specific container, which is independent of html code
		//selenium cannot identify frames in normal fashion, we have to tell selenium that it is frame and handle it accordingly
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		System.out.println("done");
		System.out.println(driver.findElement(By.id("draggable")).getText());
		
		
		Actions a = new Actions(driver);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Destination = driver.findElement(By.id("droppable"));
		a.dragAndDrop(Source, Destination).build().perform();
		
		// to come out of frame use following code
		driver.switchTo().defaultContent();
	}

}
