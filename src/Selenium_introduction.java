import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_introduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invoking Browser
		//Chrome - ChromeDriver--> Methods
		//Frirefox - FirefoxDriver -> Methods
		//WebDriver is an interface
		//any class implement WebDriver interface can use WebDriver methods + their own methods
		
		//ChromeDriver driver = new ChromeDriver();
		
		/* ChromeDriver is not an interface but WebDriver is an interface 
		so we can make chromeDriver object as below as well*/
		
		
		
		//As per selenium architecture, it cannot invoke browser directly, it invoke the browser drivers.
		/* so chromedrive.exe is Chrome Drivers by third party (Chrome Guys)and selenium guys 
		 can only invoke chrome drivers and these browsers will invoke the website.*/
		// so for that we need to download the driver and set path as below
		//webDriver.chrome.driver-> value of path
		//in my case path where chrome diver downloaded is C:\Users\nndnr\Downloads\chromedriver_win32
        
		//latest Selenium Manager package -
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nndnr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//Chrome
		//WebDriver driver = new ChromeDriver();
		
		
		//Firefox
		// System.setProperty -- webdriver.gecko.driver
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\nndnr\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		//EdgeDriver
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/java/java_getstarted.asp");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//driver.close();
		driver.quit();
	}

}
