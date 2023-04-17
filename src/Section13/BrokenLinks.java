package Section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert asr = new SoftAssert();
		//broken link mean url tied to link not working
		
		//Selenium alone cannot help here so selenium alongwith java methods 
		// help to call url and get you status codes to find broken links
		//any status code in Network tab more than 400 means broken link
		
		//1st step is to get all urls tied up to the links
		
		List<WebElement> urls =  driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		
	    for(int i=0; i< urls.size();i++) {
	    	String URL = urls.get(i).getAttribute("href");
	    	String text = urls.get(i).getText();
	    	//System.out.println(URL);
	    	
	    	HttpURLConnection conn = (HttpURLConnection)new URL(URL).openConnection();
	    // explain above line as
	    	//openConnection() is a method to open url and it is a method of URL class so
	    	//called method after initialising object  as below
	    	//new URL(URL[i]).openConnection()
	    	//but return type is HttpURLConnection so we cast it as above and save the output
	    	//in conn variable which is HttpURLConnection type variable
	    	
	    	conn.setRequestMethod("HEAD");
	    	conn.connect();
	    	int code = conn.getResponseCode();
	    	System.out.println(code);
	    	
	    	//we comment out if condition and use hard assertion below
	    	//Assert.assertFalse(code > 400, URL+ " xxxxxxxx*****this url is tied to link ["+text+"] and it is broken because its response code is "+code);
	    
	    	//now we will check with soft assertions
	    	
	    	asr.assertFalse(code > 400, URL+ " xxxxxxxx*****this url is tied to link ["+text+"] and it is broken because its response code is "+code);
		    
	    	/*if(code > 400) {
	    		
	    		System.out.println(code);
	    		System.out.println(URL+ " xxxxxxxx*****this url is tied to link ["+text+"] and it is broken because its response code is "+code);
	    	Assert.assertFalse(code > 400, "broken link");
	    	
	    	// the drawback of above assertion is it stopped test there and did not check
	    	//remaining links for any broken links.. so that we need softassertions
	    	//which are in testng.. so I downloaded testng jars and create 
	    	}*/
	    	
	    	System.out.println(URL+ "this url is tied to link ["+text+"] and it is not broken as its response code is "+code);
	    
	    }
	
	    // if there are any failed assertions captured above
	    asr.assertAll();
	    driver.close();
	}

}
