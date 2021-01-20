package Automation.Assesment;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITest;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vishal\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.irctc.co.in");
		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
		WebElement Login = driver.findElement(By.xpath("//a[@id='loginText']"));
		Login.click();
		
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.xpath("//input[@id='userId']"));
		username.sendKeys("username");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id='pwd']"));
		password.sendKeys("password");
		
		Thread.sleep(5000);

		/*File src = driver.findElement(By.xpath("//div[@id='nlpImgContainer']//div//div//div//div//div//img"))
				.getScreenshotAs(OutputType.FILE);
		String path = 	System.getProperty("user.dir")+"/screenshots/captcha.png";
		FileHandler.copy(src, new File(path));
		
		ITesseract image = new Tesseract();
		String imagetext = image.doOCR(new File(path));
		
	String finalText =	imagetext.split("below")[1].replaceAll("[^a-zA-Z]", "");
		System.out.println("Final Captha is : "+finalText);
		
		*/
		
		WebElement captcha = driver.findElement(By.xpath("//input[@id='nlpAnswer']"));
		captcha.sendKeys("finalText");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();

		String expected = "Invalid Captcha....";
		WebElement er = driver.findElement(By.xpath("//div[@class='loginError']"));
		String error = er.getText();
		//String error1 = er.toString();
		System.out.println(error);
		// Assert.assertEquals(error, expected);

	}

}
