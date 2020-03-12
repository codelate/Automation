

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase1 {	


//Test case #1:
@Test
	public void Resizable() {
//Open Chrome Browser
				
				System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
//Click on Resizable			
				driver.get("https://demoqa.com/resizable/");
		        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		        
		int count = 1;
		for(int i=20;i<60;) {
			for(int j=22;j<=60;j=j+10) {
				
				System.out.println("Resize number:"+ count);
				System.out.println("height-"+i+"px ; widht-"+j+"px" ); 
				
//Resize the text editor using Selenium APIs
				
                      WebElement target =  driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
			                  Actions action = new Actions(driver);
				              action.dragAndDropBy(target,i,j).release().build().perform();

				i=i+10;
				count++;
			}
			
			}
			}}	
