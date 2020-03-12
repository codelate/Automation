package Chrome;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageChrome {	
	
//Test case #1:
			@Test  //(enabled=false)

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
			}

//Test case #2:
			
		@Test
		
		public void secondTask() {

//Open Chrome Browser

			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoqa.com/droppable/");
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Click on 'Droppable'
	        
	        WebElement source =  driver.findElement(By.id("draggable"));
	        WebElement target =  driver.findElement(By.id("droppable"));

//Perform a drag and drop      
	        
        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).perform();

//check that the text of the dropee box has changed to 'Dropped!'	   
        
        String textTo = target.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS");
		}else {
			System.out.println("Try Again");
		}
		
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 
//Drag the box back out
        
        action.clickAndHold(source).perform();
		action.dragAndDropBy(source,-150,-3).release().build().perform();
		
//Execute javascript to change the text back to 'Drop here'
		
		if(textTo.equals("Dropped!")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
	         js.executeScript("document.getElementById('droppable').innerText='drop here'");
		}else {
			System.out.println("Try Again");
		}
		
		}
		
}
