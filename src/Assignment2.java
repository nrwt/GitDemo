import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.manage().window().maximize();
		
		String name = "dummyrahul";
		String email = "dummyrahul@gmail.com";
		String pwd = "password1234";
		
		
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pwd);
		
		//verify if checkbox is selected or not
		
		if (driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected()) {
			
			System.out.println("Check me out if you Love IceCreams!   checkbox is already selected");
		}else {
			driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		}
        
		//verify if checkbox is selected
		Assert.assertEquals(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected(), true);
		
		WebElement dropdownoption = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown = new Select(dropdownoption);
		
		Thread.sleep(1000);
		//dropdown.selectByValue("Male");
		dropdown.selectByVisibleText("Female");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select student radio button
		
		WebElement student_radio_button = driver.findElement(By.cssSelector("input[id='inlineRadio1']"));
		
		if (student_radio_button.isSelected()) {
			student_radio_button.click();
		}
		
		System.out.println(student_radio_button.isSelected());
		
		driver.findElement(By.cssSelector("input[name='bday']")).click();
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("02/03/2023");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		Thread.sleep(1000);
		String s = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		//System.out.println(s);
		String[] message = s.split("\\R");
		
		/*for(int i=0; i < message.length; i++) {
			System.out.println(message[i]);
		}*/
		
		Assert.assertEquals(message[1], "Success! The Form has been submitted successfully!.");
		
	}

}
