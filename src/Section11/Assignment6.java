package Section11;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//select option2 checkbox and grab text
		//label[for='benz']
		//input[id='checkBoxOption2']
		WebElement checkboxtick = driver.findElement(By.cssSelector("input[id='checkBoxOption2']"));
		WebElement checkboxname = driver.findElement(By.cssSelector("label[for='benz']"));
		checkboxtick.click();
		System.out.println(checkboxname.getText());
		
		//select same option in dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		//staticDropdown.click();
		//dropdown.selectByValue("option2");
		dropdown.selectByVisibleText(checkboxname.getText());;
		String s = checkboxname.getText();
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//enter the label text in "Switch to alert" textbox
		
		driver.findElement(By.id("name")).sendKeys(checkboxname.getText());
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert();
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		//verify if text grabbed is presented in popup message
		
		String[] aletBoxText = alertText.split(",");
		String grabbedtext = aletBoxText[0].split(" ")[1].trim();
		System.out.println(grabbedtext);
		
		//Assert.assertEquals(grabbedtext, s);
		if(grabbedtext.equals(s)) {
			
			System.out.println(s+ "--- is present in alert message ["+alertText+"]");
		}else {
			
			System.out.println(s+ " ---is not present in alert message ["+alertText+"]");
		}
		
		
	}

}
