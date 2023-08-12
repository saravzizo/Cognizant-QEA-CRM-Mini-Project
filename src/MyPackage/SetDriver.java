package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetDriver {
	
	static String baseUrl="http://demo.automationtesting.in/Alerts.html";
	
	public static WebDriver LoadChrome()
	{
		System.setProperty("webdriver.chrome.driver","../Java/Drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static WebDriver LoadEdge()
	{
		System.setProperty("webdriver.edge.driver","../Java/Drivers/msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static WebDriver LoadInternetExplorer()
	{
		System.setProperty("webdriver.ie.driver","../Java/Drivers/IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}

}
