import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Testcase2{
	

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
		         js.executeScript("document.getElementById('droppable').innerText='Drop here'");
			}else {
				System.out.println("Try Again");
			}
			
			}
			
	}
