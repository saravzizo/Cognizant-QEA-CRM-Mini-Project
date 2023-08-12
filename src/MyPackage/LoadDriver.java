package MyPackage;

import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;



public class LoadDriver {
	
	static WebDriver driver;
	
	public void getDriver() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.className("dropdown-toggle"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		WebElement subMenu = driver.findElement(By.linkText("Alerts"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		
//		Alert with OK
		System.out.println("Handling Alert with OK started...!");
		driver.findElement(By.linkText("Alert with OK")).click();
		driver.findElement(By.className("btn-danger")).click();
		Alert alert= driver.switchTo().alert();
		try
		{
			alert.accept();
		}
		catch (NoAlertPresentException e)
		{
			System.out.println("Alert Not Found");
		}
		System.out.println("Handling Alert with OK ended successfully...\n");
		Thread.sleep(3000);
		
//		Alert with cancel
		System.out.println("Handling Alert with OK and Cancel started...!");
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		driver.findElement(By.className("btn-primary")).click();
		try
		{
			alert.dismiss();
			WebElement w=driver.findElement(By.id("demo"));
			String message=w.getText();
			System.out.println(message+" Button");
		}
		catch (NoAlertPresentException e)
		{
			System.out.println("Alert Not Found"+ e);
		}
		System.out.println("Handling Alert with Ok and Cancel Ended Successfully...\n");
		Thread.sleep(3000);
		
//		Alert with text
		System.out.println("Handling Alert with TextBox started..!");
		driver.findElement(By.linkText("Alert with Textbox")).click();
		driver.findElement(By.className("btn-info")).click();
		try
		{
			driver.switchTo().alert().sendKeys("Saravanan");
			driver.switchTo().alert().accept();
			WebElement w=driver.findElement(By.id("demo1"));
			String message=w.getText();
			if(message.contains("Saravanan"))
			{
			System.out.println("Message contains my name");
			}
			else
			{
				System.out.println("Name not found in the Message");
			}
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("Alert Not Found"+ e);
		}
		System.out.println("Handling Alert with TextBox Ended Successfully...");
		Thread.sleep(3000);
		driver.close();
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("In which Browser you want to load the website..?\n 1.Chrome \n 2.Microsoft Edge \n 3.Internet Explorer");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice (1 or 2 or 3): ");
		int choice=sc.nextInt();
		System.out.println("Loading website...");
		
		switch(choice)
		{
		case 1:
			driver=SetDriver.LoadChrome();
			break;
		case 2:
			driver=SetDriver.LoadEdge();
			break;
		case 3:
			driver=SetDriver.LoadInternetExplorer();
			break;
		default:
			driver=SetDriver.LoadChrome();
		}

		LoadDriver load = new LoadDriver();
		load.getDriver();
		
		sc.close();
			
	}

}
