package Section13;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); //this method will set the behaviour of chromedriver to ignore certificate
		//options.addExtensions( filepath )  similary there are many more methods
		
		
		FirefoxOptions options1 = new FirefoxOptions(); //this is for firefox.. same for Edge as well
		EdgeOptions options2 = new EdgeOptions();
		
		Proxy proxy =new Proxy(); 
		//set proxy as below if required
		
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		//check website "https://chromedriver.chromium.org/capabilities" for more methods
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		driver.getTitle();
		
		//above code will not give title because of certificate error so we use Chromeoptions class
		//Chromeoptions class set the behaviour of your browser
	}

}
