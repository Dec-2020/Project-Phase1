package amazon;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/iamneha30gmail/Downloads/chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement searchText = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchText.sendKeys("IPhone 12");
		
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		searchBtn.click();
		
		List<WebElement> pName = driver.findElements(By.xpath("//h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> pPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		

		for(int i = 0; i <= pName.size()-1; i++) {
			
			if(pName.get(i).getText().contains("Apple iPhone 12")) {
				
				System.out.println(pName.get(i).getText() + " - " + pPrice.get(i).getText());
			}
		}
		
		driver.close();

	}

}











