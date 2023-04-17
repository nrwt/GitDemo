package Section13;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Miscelleanious {

	public static void main(String[] args) throws IOException {
		
		/*ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",

			     Arrays.asList("disable-popup-blocking"));*/
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
       // driver.manage().deleteAllCookies();
 		
		//if we want to delete only one cookie below code applied
		
		driver.manage().deleteCookieNamed("xyz");
		
		//if we delete session id cookie, our session will be logged out.. how to verify that
		// suppose session id cookie name is sessioncookie ..
		//so we delete this particular cookie and then click on any page it will ask to login
		
		
		driver.get("https://www.google.co.uk/");
		
		
		//how to take screenshots
		//In below line first we are casting our driver object to takescreenshot by
		// using method getScreenshotAs and output it in file object src
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//then we need to move this file in our machine
		//NOTE::> We download jars for fileUtils from "https://commons.apache.org/proper/commons-io/download_io.cgi"
		//then import
		
		FileUtils.copyFile(src, new File("D:\\images\\screenshot.png"));
		//FileUtils.copyFile(src, new File("C:\\Users\\screenshot.png"));
		
		
	}

}
