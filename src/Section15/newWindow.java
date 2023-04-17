package Section15;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class newWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		String url = "https://rahulshettyacademy.com/angularpractice/";
		String mainUrl = "https://rahulshettyacademy.com/#";
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);

		//open new tab or windows as below
		
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windowIDs = driver.getWindowHandles();
		//iterator is used to iterate in items in set
		Iterator<String> it = windowIDs.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		driver.get(mainUrl);
		driver.manage().window().maximize();
		
		String firstCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(firstCourse);
		
		//take partial screenshot
		
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File ("new_file"));
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		//driver.quit();
	}

}
