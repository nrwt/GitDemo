import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentwindowid = itr.next();
		String child1windowid = itr.next();
		//String childofchild1Id = itr.next();
		driver.switchTo().window(child1windowid);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentwindowid);
		//System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		

	}

}
