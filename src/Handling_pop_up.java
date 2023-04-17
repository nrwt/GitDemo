import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_pop_up {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		String name = "Rahul Shetty";

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();

		// selenium only detect what is written in html, but pop ups are written in
		// Javascript,
		// So in selenium we can use switch to handle alerts.

		// click ok on alert

		System.out.println(driver.switchTo().alert().getText());
		String s = driver.switchTo().alert().getText();
		if (s.equalsIgnoreCase("Hello " + name + ", share this practice page and share your knowledge")) {
			System.out.println("correct text");
		}
		driver.switchTo().alert().accept();

		// how to handle alert with 2 buttons.. Ok and cancel

		driver.findElement(By.cssSelector("input[id='confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		// driver.close();

	}

}
