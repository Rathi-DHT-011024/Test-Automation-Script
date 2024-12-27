
package slidetype;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;




import com.google.common.io.Files;

import java.awt.HeadlessException;

import java.io.File;




public class live {

    //private static final String WebElement = null;
	private WebDriver driver;
    private WebDriverWait wait;
    

    @BeforeClass
    public void setup() {
        // Setup the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test(priority = 1)
    public void testNavigateToChrome() throws InterruptedException {
        // Navigate to the application
        driver.get("https://app.slidone.com/auth/signin");
        driver.findElement(By.xpath("//*[@id='emailInput']")).sendKeys("praveen@digitalhoop.io");
        driver.findElement(By.xpath("//*[@id='passwordInput']")).sendKeys("Test@12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void testCreatePresentation() throws InterruptedException {
    	Thread.sleep(8000);
    	driver.findElement(By.xpath("//button[contains(@class,'btn btn-n')]")).click();
    	Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='slideName']"))).sendKeys("Testing");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Save']"))).click();
        Thread.sleep(2000);
          
    }
  //Multiple choice
  	@Test(priority = 3)
  	public void multiplechoiceTest() throws InterruptedException {
  		Thread.sleep(3000);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[2]"))).click();
  		Thread.sleep(2000);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Multiple Choice']"))).sendKeys("What is the national animal");
  		Thread.sleep(2000);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a longer description']"))).click(); 
  		Thread.sleep(2000);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@type='text']"))).sendKeys("Choose your choice from the below options");
  		Thread.sleep(2000);
  	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Option ']"))).click();
  	    Thread.sleep(3000);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Option ']"))).click();
  		Thread.sleep(2000);
  		
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'form-control remaining-padding')])[2]"))).sendKeys("lion");		
  		Thread.sleep(2000);
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Option 2']"))).sendKeys("tiger");
  	    Thread.sleep(1000);
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Option 3']"))).sendKeys("cow");
  	    
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Option 4']"))).click();
  	    Thread.sleep(1000);
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Option 4']"))).sendKeys("donkey");
  	    Thread.sleep(1000);
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Option 5']"))).sendKeys("zebra");
  	    Thread.sleep(1000);
  	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-work-space/section/main/section/div/app-right-side-bar/div[1]/div[2]/div[2]/div[3]/div[2]/label/span"))).click();
  	    Thread.sleep(1000);

        // Locate the image element inside the span
        WebElement imageElement = driver.findElement(By.xpath("//img[@src='/assets/new-icons/question-circle.svg']"));

        // Perform hover action using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(imageElement).perform();

        // Locate the parent <span> element that contains the tooltip
        WebElement tooltipSpan = driver.findElement(By.xpath("//span[contains(@class,'ms-1 right-side-bar-settings-tooltip-top')]"));

        // Retrieve the tooltip text from the 'data-tooltip' attribute
        String actualTooltipText = tooltipSpan.getAttribute("data-tooltip");

        // Define the expected tooltip text (update this based on your expectations)
        String expectedTooltipText = "Select the right answer from the options above before starting your presentation.";

        // Validate the tooltip text
        if (actualTooltipText.equals(expectedTooltipText)) {
            System.out.println("Tooltip validation passed: " + actualTooltipText);
        } else {
            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText + ", but found: " + actualTooltipText);
        }
        Thread.sleep(1000);
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='1']"))).click();
  	    driver.findElement(By.xpath("//div[@class='w-100 me-2']//select[1]")).click();
        driver.findElement(By.xpath("//option[normalize-space(text())='Anton']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space(text())='+']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space(text())='+']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//b[normalize-space(text())='/']")).click();
        Thread.sleep(3000);	
        driver.findElement(By.xpath("//input[@value='#82B4FE']")).click();
        Thread.sleep(3000);	
        driver.findElement(By.xpath("//a[@class='fs-14']")).click();
        Thread.sleep(3000);	
  	}
  	
    
  //word cloud
  		@Test(priority = 4)
  		public void wordcloudTest() throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[3]"))).click();
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Word Cloud\"]"))).sendKeys("what the words start with A?");
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a longer description']"))).click(); 
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@type='text']"))).sendKeys("Briefly tell about your place");
  		// Locate the image element inside the span
  	        WebElement imageElement = driver.findElement(By.xpath("//img[@src='/assets/new-icons/question-circle.svg']"));

  	        // Perform hover action using Actions class
  	        Actions actions = new Actions(driver);
  	        actions.moveToElement(imageElement).perform();

  	        // Locate the parent <span> element that contains the tooltip
  	        WebElement tooltipSpan = driver.findElement(By.xpath("//span[contains(@class,'ms-1 right-side-bar-settings-tooltip-top')]"));

  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
  	        String actualTooltipText = tooltipSpan.getAttribute("data-tooltip");

  	        // Define the expected tooltip text (update this based on your expectations)
  	        String expectedTooltipText = "One entry can consist of several words";

  	        // Validate the tooltip text
  	        if (actualTooltipText.equals(expectedTooltipText)) {
  	            System.out.println("Tooltip validation passed: " + actualTooltipText);
  	        } else {
  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText + ", but found: " + actualTooltipText);
  	        }
  	        Thread.sleep(1000);
  			
  			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  	    	WebElement entries = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
  	    	
  	    	// Use Actions to clear and input the text
  	    	

  	    	// Click to focus on the input element, send BACK_SPACE keys to clear, and then input text
  	    	actions.click(entries)
  	    	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
  	    	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
  	    	       .sendKeys("5")  // Input the new data
  	    	       .perform();
  			
  		// Wait and click the first dropdown select element
  		    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
  		    selectElement.click();

  		    // Wait and click the option "Anton"
  		    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Anton']")));
  		    antonOption.click();

  		    // Wait and click the first '+' button
  		    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  		    firstPlusButton.click();

  		    // Wait and click the second '+' button
  		    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  		    secondPlusButton.click();

  		    // Wait and click the '/' button
  		    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space(text())='/']")));
  		    divideButton.click();

  		    // Wait until the hidden input element becomes available and click it
  		    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#82B4FE']")));
  		    colorInput.click();

  		    // Wait and click the link with class 'fs-14'(reset the  default themes)
  		    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
  		   // linkElement.click();
  		    Thread.sleep(5000);	
  		    
  			
  		}
  		
  		//Open ended
  		@Test(priority = 5)
  		public void openendedTest() throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[4]"))).click();
  			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Open Ended']"))).sendKeys("pool your thuoghts about eduaction?");
  		
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a longer description']"))).click(); 
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@type='text']"))).sendKeys("Must respond");
  			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='flexCheckDefault5'])[2]"))).click();
  		// Wait and click the first dropdown select element
  		    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
  		    selectElement.click();

  		    // Wait and click the option "Anton"
  		    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Anton']")));
  		    antonOption.click();

  		    // Wait and click the first '+' button
  		    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  		    firstPlusButton.click();

  		    // Wait and click the second '+' button
  		    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  		    secondPlusButton.click();

  		    // Wait and click the '/' button
  		    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space(text())='/']")));
  		    divideButton.click();

  		    // Wait until the hidden input element becomes available and click it
  		    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#82B4FE']")));
  		    colorInput.click();

  		    // Wait and click the link with class 'fs-14'(reset the  default themes)
  		    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
  		   // linkElement.click();
  		    Thread.sleep(5000);	
  			
  			
  		}
  	//Scales
  			@Test(priority = 6)
  			public void scalesTest() throws InterruptedException {
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[5]"))).click();
  				Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Scales']"))).sendKeys("rate about the leo movie?");
  				Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Statement ']"))).click();
  				Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Statement ']"))).click();
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("//input[@placeholder='Statement 1']")).sendKeys("music");
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("//input[@placeholder='Statement 2']")).sendKeys("comedy");
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("//input[@placeholder='Statement 3']")).sendKeys("song");
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("//input[@placeholder='Statement 4']")).sendKeys("suspense");
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("(//input[@placeholder='Statement 5'])[1]")).sendKeys("twist");
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("(//label[normalize-space(text())='Bottom of the scale']/following::input)[1]")).clear();
  				Thread.sleep(1000);
  				driver.findElement(By.xpath("(//label[normalize-space(text())='Bottom of the scale']/following::input)[1]")).sendKeys("strongle agree");
  				WebElement entries2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='number'])[1]")));
  	  	    	
  	  	    	// Use Actions to clear and input the text
  	  	    	
  				Actions actions = new Actions(driver);
  	  	    	// Click to focus on the input element, send BACK_SPACE keys to clear, and then input text
  	  	    	actions.click(entries2)
  	  	    	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
  	  	    	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
  	  	    	       .sendKeys("1")  // Input the new data
  	  	    	       .perform();
  				
  				Thread.sleep(3000);
  				driver.findElement(By.xpath("//input[@placeholder='Top of the scale']")).clear();
  				driver.findElement(By.xpath("//input[@placeholder='Top of the scale']")).sendKeys("stronly disagree");
                WebElement entries3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='number'])[5]")));
  	  	    	
  	  	    	// Use Actions to clear and input the text
  	  	    	
  				
  	  	    	// Click to focus on the input element, send BACK_SPACE keys to clear, and then input text
  	  	    	actions.click(entries3)
  	  	    	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
  	  	    	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
  	  	    	       .sendKeys("5")  // Input the new data
  	  	    	       .perform();
  	  	 // Wait and click the first dropdown select element
  	  		    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
  	  		    selectElement.click();

  	  		    // Wait and click the option "Anton"
  	  		    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Anton']")));
  	  		    antonOption.click();

  	  		    // Wait and click the first '+' button
  	  		    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  	  		    firstPlusButton.click();

  	  		    // Wait and click the second '+' button
  	  		    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='+']")));
  	  		    secondPlusButton.click();

  	  		    // Wait and click the '/' button
  	  		    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space(text())='/']")));
  	  		    divideButton.click();

  	  		    // Wait until the hidden input element becomes available and click it
  	  		    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#82B4FE']")));
  	  		    colorInput.click();

  	  		    // Wait and click the link with class 'fs-14'(reset the  default themes)
  	  		    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
  	  		   // linkElement.click();
  	  		    Thread.sleep(5000);	
  			}
  			
  			//Ranking
  			@Test(priority = 7)
  			public void rankingTest() throws InterruptedException {
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[6]"))).click();
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Ranking']"))).sendKeys("Rank the orders");
  				
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@maxlength='150']"))).sendKeys("Rank it in alphabetical order");
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Item ']"))).click();
  				 Thread.sleep(2000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Item ']"))).click();
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Item 1']"))).sendKeys("Apple");
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Item 2']"))).sendKeys("Mango");
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Item 3']"))).sendKeys("Pineapple");
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Item 4']"))).sendKeys("Watermelon");
  				 Thread.sleep(1000);
  				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Item 5'])[1]"))).sendKeys("Banana");
  				Thread.sleep(3000);
  			// Wait and click the first dropdown select element
  	  		    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
  	  		    selectElement.click();

  	  		    // Wait and click the option "Anton"
  	  		    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Playwrite']")));
  	  		    antonOption.click();

  	  		    // Wait and click the first '+' button
  	  		    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
  	  		    firstPlusButton.click();

  	  		    // Wait and click the second '+' button
  	  		    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
  	  		    secondPlusButton.click();

  	  		    // Wait and click the '/' button
  	  		    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//s[normalize-space(text())='S']")));
  	  		    divideButton.click();

  	  		    // Wait until the hidden input element becomes available and click it
  	  		    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FF8383']")));
  	  		    colorInput.click();

  	  		    // Wait and click the link with class 'fs-14'(reset the  default themes)
  	  		    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
  	  		   // linkElement.click();
  	  		    Thread.sleep(5000);	
  			}
    
    
    
    // QA Slide
    @Test(priority = 8)
    public void testCreateQASlide() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='New Slide']")).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[7]"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Ask me anything']"))).click();
    	driver.findElement(By.xpath("//input[@placeholder='Ask me anything']")).sendKeys("Drop Your questions here");
    	//driver.findElement(By.id("flexCheckDefault25")).click();
    	// Wait and click the first dropdown select element
		    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
		    selectElement.click();

		    // Wait and click the option "Anton"
		    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Playwrite']")));
		    antonOption.click();

		    // Wait and click the first '+' button
		    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
		    firstPlusButton.click();

		    // Wait and click the second '+' button
		    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
		    secondPlusButton.click();

		    // Wait and click the '/' button
		    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//s[normalize-space(text())='S']")));
		    divideButton.click();

		    // Wait until the hidden input element becomes available and click it
		    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FF8383']")));
		    colorInput.click();

		    // Wait and click the link with class 'fs-14'(reset the  default themes)
		    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
		   // linkElement.click();
		    Thread.sleep(5000);	
    	
    	 
    	
    }

    // GTN Slide
    @Test(priority = 9)
    public void testCreateGTNSlide() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='New Slide']")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[8]"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Guess the Number']"))).sendKeys("Guess the number what i guessed?");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@type='text']"))).sendKeys("give the guess number");
    	Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	// Locate the image element inside the span
	        WebElement imageElement = driver.findElement(By.xpath("(//*[name()='circle'])[18]"));

	        // Perform hover action using Actions class
	        Actions actions = new Actions(driver);
	        actions.moveToElement(imageElement).perform();

	        // Locate the parent <span> element that contains the tooltip
	        WebElement tooltipSpan = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[1]"));

	        // Retrieve the tooltip text from the 'data-tooltip' attribute
	        String actualTooltipText = tooltipSpan.getAttribute("data-tooltip");

	        // Define the expected tooltip text (update this based on your expectations)
	        String expectedTooltipText = "Enter the number the audience needs to guess.";

	        // Validate the tooltip text
	        if (actualTooltipText.equals(expectedTooltipText)) {
	            System.out.println("Tooltip validation passed: " + actualTooltipText);
	        } else {
	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText + ", but found: " + actualTooltipText);
	        }
	        Thread.sleep(1000);

    	WebElement correctAnswerInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("correctAnswer")));
    	
    	// Use Actions to clear and input the text
    	

    	// Click to focus on the input element, send BACK_SPACE keys to clear, and then input text
    	actions.click(correctAnswerInput1)
    	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
    	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
    	       .sendKeys("60")  // Input the new data
    	       .perform();
    	 Thread.sleep(3000);
    	// Locate the image element inside the span
  	        WebElement imageElement1 = driver.findElement(By.xpath("(//*[name()='circle'])[19]"));

  	        // Perform hover action using Actions class
  	        
  	        actions.moveToElement(imageElement1).perform();

  	        // Locate the parent <span> element that contains the tooltip
  	        WebElement tooltipSpan1 = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[2]"));

  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
  	        String actualTooltipText1 = tooltipSpan1.getAttribute("data-tooltip");

  	        // Define the expected tooltip text (update this based on your expectations)
  	        String expectedTooltipText1 = "Set the margin of error for correct answers.";

  	        // Validate the tooltip text
  	        if (actualTooltipText1.equals(expectedTooltipText1)) {
  	            System.out.println("Tooltip validation passed: " + actualTooltipText1);
  	        } else {
  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText1 + ", but found: " + actualTooltipText1);
  	        }
  	        Thread.sleep(1000);
    	// Locate the element you want to click
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overflow-y-auto ng-star-inserted']//span[@class='slider round']")));

    	// Scroll the element into view
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    	// Now wait until the element is clickable and click it
    	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    	WebElement errormargin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-work-space[1]/section[1]/main[1]/section[1]/div[1]/app-right-side-bar[1]/div[1]/div[2]/div[2]/div[4]/div[3]/div[1]/input[1]")));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", errormargin);

    
    	actions.click(errormargin)
	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
	       .sendKeys("10")  // Input the new data
	       .perform();
    	Thread.sleep(1000);
    	// Locate the image element inside the span
  	        WebElement imageElement2 = driver.findElement(By.xpath("(//*[name()='circle'])[20]"));

  	        // Perform hover action using Actions class
  	        
  	        actions.moveToElement(imageElement2).perform();

  	        // Locate the parent <span> element that contains the tooltip
  	        WebElement tooltipSpan2 = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[3]"));

  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
  	        String actualTooltipText2= tooltipSpan2.getAttribute("data-tooltip");

  	        // Define the expected tooltip text (update this based on your expectations)
  	        String expectedTooltipText2 = "Set the range to be guessed from";

  	        // Validate the tooltip text
  	        if (actualTooltipText2.equals(expectedTooltipText2)) {
  	            System.out.println("Tooltip validation passed: " + actualTooltipText2);
  	        } else {
  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText2 + ", but found: " + actualTooltipText2);
  	        }
  	        Thread.sleep(1000);
  	  
    	WebElement correctAnswerInput2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startNumber")));
    	Thread.sleep(1000);
    	correctAnswerInput2.click();
    	correctAnswerInput2.clear();
    	Thread.sleep(3000);
    	correctAnswerInput2.sendKeys("10");
    	Thread.sleep(2000);
    	WebElement correctAnswerInput3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("endNumber")));
    	Thread.sleep(1000);
    	correctAnswerInput3.click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value = '';",correctAnswerInput3 ); 
    	Thread.sleep(3000);
    	correctAnswerInput3.sendKeys("100");
    	
    	Thread.sleep(2000);
    	correctAnswerInput3.click();
    	
    	
    
    	Thread.sleep(3000);
    	
    	
	  		// Locate the image element inside the span
	  	  	        WebElement imageElement3 = driver.findElement(By.xpath(("(//h5[@class='modal-title my-3']//span)[3]")));

	  	  	        // Perform hover action using Actions class
	  	  	        
	  	  	        actions.moveToElement(imageElement3).perform();

	  	  	        // Locate the parent <span> element that contains the tooltip
	  	  	        WebElement tooltipSpan3 = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[4]"));

	  	  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
	  	  	        String actualTooltipText3= tooltipSpan3.getAttribute("data-tooltip");

	  	  	        // Define the expected tooltip text (update this based on your expectations)
	  	  	        String expectedTooltipText3 = "Set the scale range for guessing accuracy.";

	  	  	        // Validate the tooltip text
	  	  	        if (actualTooltipText3.equals(expectedTooltipText3)) {
	  	  	            System.out.println("Tooltip validation passed: " + actualTooltipText3);
	  	  	        } else {
	  	  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText3 + ", but found: " + actualTooltipText3);
	  	  	        }
	  	  	        Thread.sleep(1000);
    	
    	driver.findElement(By.name("scale")).click();
    	driver.findElement(By.xpath("//option[normalize-space(text())='10']")).click();
    	
    	
    	// Wait and click the first dropdown select element
	    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
	    selectElement.click();

	    // Wait and click the option "Anton"
	    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Lexend Deca']")));
	    antonOption.click();

	    // Wait and click the first '+' button
	    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
	    firstPlusButton.click();

	    // Wait and click the second '+' button
	    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
	    secondPlusButton.click();

	    // Wait and click the '/' button
	    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[normalize-space(text())='U']")));
	    divideButton.click();

	    // Wait until the hidden input element becomes available and click it
	    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FFD584']")));
	    colorInput.click();

	    // Wait and click the link with class 'fs-14'(reset the  default themes)
	    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
	   // linkElement.click();
	    Thread.sleep(5000);		  	  	  		
		  	  	  	
    }
 // This or That Slide
    @Test(priority = 10)
    public void testCreateThisOrThatSlide() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='New Slide']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slide-list-hover'])[9]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='This or That']"))).sendKeys("which is your favorite?");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@type='text']"))).sendKeys("chose any one");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Option 1']")).sendKeys("CHOCOLATE");
        driver.findElement(By.xpath("//input[@placeholder='Option 2']")).sendKeys("JUICE");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='thisorthatPrescentageCheck']"))).click();
        Thread.sleep(1000);

    	// Wait and click the first dropdown select element
	    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
	    selectElement.click();

	    // Wait and click the option "Anton"
	    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Lexend Deca']")));
	    antonOption.click();

	    // Wait and click the first '+' button
	    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
	    firstPlusButton.click();

	    // Wait and click the second '+' button
	    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
	    secondPlusButton.click();

	    // Wait and click the '/' button
	    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[normalize-space(text())='U']")));
	    divideButton.click();

	    // Wait until the hidden input element becomes available and click it
	    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FFD584']")));
	    colorInput.click();

	    // Wait and click the link with class 'fs-14'(reset the  default themes)
	    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
	   // linkElement.click();
	    Thread.sleep(5000);	
    }
 // Traffic Lights Slide
    @Test(priority = 11)
    public void testCreateTrafficLightsSlide() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='New Slide']")).click();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slide-list-hover'])[10]"))).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Traffic Lights']"))).click();
    	 driver.findElement(By.xpath("(//input[@placeholder='Traffic Lights'])[1]")).sendKeys("shall we do");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("//a[normalize-space(text())='Add a longer description']")).click();
    	 driver.findElement(By.tagName("textarea")).sendKeys("choose your opinion");
    	 driver.findElement(By.xpath("//input[@placeholder='Red']")).sendKeys("stop");
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//input[@placeholder='Yellow']")).sendKeys("wait");
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//input[@placeholder='Green']")).sendKeys("gooo");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("(//input[@id='flexCheckDefault5'])[2]")).click();
    	 Thread.sleep(1000);

     	// Wait and click the first dropdown select element
 	    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
 	    selectElement.click();

 	    // Wait and click the option "Anton"
 	    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Lexend Deca']")));
 	    antonOption.click();

 	    // Wait and click the first '+' button
 	    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
 	    firstPlusButton.click();

 	    // Wait and click the second '+' button
 	    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
 	    secondPlusButton.click();

 	    // Wait and click the '/' button
 	    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[normalize-space(text())='U']")));
 	    divideButton.click();

 	    // Wait until the hidden input element becomes available and click it
 	    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FFD584']")));
 	    colorInput.click();

 	    // Wait and click the link with class 'fs-14'(reset the  default themes)
 	    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
 	   // linkElement.click();
 	    Thread.sleep(5000);	
    	 
        
    }
 // Truth or Lie Slide
    @Test(priority = 12)
    public void testCreateTruthOrLieSlide() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[text()='New Slide']")).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slide-list-hover'])[11]"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Truth or Lie']")).sendKeys("which is truth or lie?");
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='text-primary fs-12']"))).click();
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("textarea"))).sendKeys("raise your answer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-cstm-secondar')]//span[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-cstm-secondar')]//span[1]")).click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Statement 1']"))).sendKeys("man has tail");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Statement 2']"))).sendKeys("crab has tail");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='2-correct']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Statement 3']"))).sendKeys("cat has tail");
        Thread.sleep(3000);
    
      
        Thread.sleep(1000);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Statement 4']"))).sendKeys("fish doesnot has tail");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Statement 5']"))).sendKeys("cow does not has tail");
       
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@id='flexCheckDefault5'])[2]")).click();
        driver.findElement(By.xpath("//div[@class='w-100 me-2']//select[1]")).click();
     // Wait and click the first dropdown select element
 	    WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='w-100 me-2']//select[1]")));
 	    selectElement.click();

 	    // Wait and click the option "Anton"
 	    WebElement antonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[normalize-space(text())='Lexend Deca']")));
 	    antonOption.click();

 	    // Wait and click the first '+' button
 	    WebElement firstPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
 	    firstPlusButton.click();

 	    // Wait and click the second '+' button
 	    WebElement secondPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='-']")));
 	    secondPlusButton.click();

 	    // Wait and click the '/' button
 	    WebElement divideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[normalize-space(text())='U']")));
 	    divideButton.click();

 	    // Wait until the hidden input element becomes available and click it
 	    WebElement colorInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='#FFD584']")));
 	    colorInput.click();

 	    // Wait and click the link with class 'fs-14'(reset the  default themes)
 	    //WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fs-14']")));
 	   // linkElement.click();
 	    Thread.sleep(5000);
 	    }
    @Test(priority = 13)
    public void testSelectanswer() throws InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
    	Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slide-list-hover'])[12]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select Answer']"))).sendKeys("which word strating with r?");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-primary.fs-12"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).sendKeys("please respond faster");
     // Locate the element you want to click
    	WebElement addop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add Option')]")));

    	// Scroll the element into view
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addop);
    	Thread.sleep(2000);
    	// Now wait until the element is clickable and click it
    	wait.until(ExpectedConditions.elementToBeClickable(addop)).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(addop)).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@placeholder='Option 1']")).sendKeys("mathi");
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Option 2']")).sendKeys("ravi");
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Option 3']")).sendKeys("balu");
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Option 4']")).sendKeys("dinesh");
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Option 5']")).sendKeys("muruga");
    	Thread.sleep(1000);
    	
       
        
        driver.findElement(By.xpath("//label[@for='2']")).click();
        Thread.sleep(3000);
        WebElement second = driver.findElement(By.xpath("(//div[contains(@class,'col-4 px-0')]//input)[1]"));
        Actions actions = new Actions(driver);
        actions.click(second)
	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
	       .sendKeys("100")  // Input the new data
	       .perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Music']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='flexCheckDefault5'])[4]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='polygon'])[2]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//p[@class='mb-0'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='text-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys("C:\\Users\\Admin\\Downloads\\flower.png");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-save')]")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/Trashcan.png']"))).click();
        Thread.sleep(1000);
       // driver.findElement(By.xpath("//img[@src='assets/images/Trashcan.png']")).click();
        // Locate the element using XPath (adjust XPath as needed)
        WebElement element = driver.findElement(By.xpath("(//h5[@class='modal-title mb-0'])[3]"));

        // Retrieve the value of the "cursor" CSS property
        String cursorValue = element.getCssValue("cursor");

        // Output the cursor property value
        System.out.println("Cursor value for the element: " + cursorValue);

        // Check if the cursor indicates a disabled element
        if ("not-allowed".equals(cursorValue)) {
            System.out.println("Themes is disabled (cursor: not-allowed).");
        } else {
            System.out.println("Themes is enabled (cursor: " + cursorValue + ").");
        }
    }
  

 

    @Test(priority = 14)
    public void testtypeanswer() throws InterruptedException {
       
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
    	Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[13]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Type Answer']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Type Answer']"))).sendKeys("who is the father of our nation?");
        Thread.sleep(1000);
       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).sendKeys("He was a national leader and social reformist who is known as the Father of Our Nation in India."); 
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(@class,'col-9 px-0')]//input)[1]")).sendKeys("tiger");
        Thread.sleep(1000);
        WebElement element2 = driver.findElement(By.xpath("//button[contains(.,'Add correct answer')]"));
        Thread.sleep(1000);

        // Use JavaScript to scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        element2.click();
        Thread.sleep(1000);
       
        element2.click();
        Thread.sleep(1000);
       
        element2.click();
        Thread.sleep(1000);
        
        element2.click();
        Thread.sleep(1000);
     
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(@class,'col-9 px-0')]//input)[2]")).sendKeys("lion");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(@class,'col-9 px-0')]//input)[3]")).sendKeys("monkey");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Item 4']")).sendKeys("horse");
        
        driver.findElement(By.xpath("//input[@placeholder='Item 5']")).sendKeys("deer");
        Thread.sleep(1000);
        
        WebElement element3 = driver.findElement(By.xpath("//div[@class='option-limit-alert ng-star-inserted']"));

        // Use JavaScript to scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
        //element3.click();
        Thread.sleep(1000);
        boolean isValid = driver.findElement(By.xpath("//div[@class='option-limit-alert ng-star-inserted']")).getText().equals("Max reached! You can only add up to 5 options.");
        Thread.sleep(1000);
     // Validate the alert message content
        String alertText = element3.getText();
        if (alertText.equals("Max reached! You can only add up to 5 options.")) {
            System.out.println("Alert is shown and the message is correct: " + alertText);
        } else {
            System.out.println("Alert message is incorrect or not as expected. Found: " + alertText);
        }
        
        Thread.sleep(1000);
        WebElement second = driver.findElement(By.xpath("(//div[contains(@class,'col-4 px-0')]//input)[1]"));
        Actions actions = new Actions(driver);
        actions.click(second)
	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
	       .sendKeys("100")  // Input the new data
	       .perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Music']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='flexCheckDefault5'])[4]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='polygon'])[2]"))).click();
        
        driver.findElement(By.xpath("(//p[@class='mb-0'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='text-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys("C:\\Users\\Admin\\Downloads\\flower.png");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-save')]")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/Trashcan.png']"))).click();
        //Thread.sleep(1000);
       // driver.findElement(By.xpath("//img[@src='assets/images/Trashcan.png']")).click();
        // Locate the element using XPath (adjust XPath as needed)
        WebElement element = driver.findElement(By.xpath("(//h5[@class='modal-title mb-0'])[3]"));

        // Retrieve the value of the "cursor" CSS property
        String cursorValue = element.getCssValue("cursor");

        // Output the cursor property value
        System.out.println("Cursor value for the element: " + cursorValue);

        // Check if the cursor indicates a disabled element
        if ("not-allowed".equals(cursorValue)) {
            System.out.println("Themes is disabled (cursor: not-allowed).");
        } else {
            System.out.println("Themes is enabled (cursor: " + cursorValue + ").");
        }
         
       
    }
   
  //Quiz-Guess the number
	@Test(priority = 15)
	public void quiz_GTNTest() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
    	Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='slide-list-hover'])[14]"))).click();
        Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Guess the Number']"))).sendKeys("when the titanic drown?");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@maxlength='150']"))).sendKeys("The ship struck an iceberg in the North Atlantic Ocean at approximately 11:40 PM");
		Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	// Locate the image element inside the span
	        WebElement imageElement = driver.findElement(By.xpath("(//*[name()='circle'])[19]"));

	        // Perform hover action using Actions class
	        Actions actions = new Actions(driver);
	        actions.moveToElement(imageElement).perform();

	        // Locate the parent <span> element that contains the tooltip
	        WebElement tooltipSpan = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[1]"));

	        // Retrieve the tooltip text from the 'data-tooltip' attribute
	        String actualTooltipText = tooltipSpan.getAttribute("data-tooltip");

	        // Define the expected tooltip text (update this based on your expectations)
	        String expectedTooltipText = "Enter the number the audience needs to guess.";

	        // Validate the tooltip text
	        if (actualTooltipText.equals(expectedTooltipText)) {
	            System.out.println("Tooltip validation passed: " + actualTooltipText);
	        } else {
	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText + ", but found: " + actualTooltipText);
	        }
	        Thread.sleep(1000);

    	WebElement correctAnswerInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("correctAnswer")));
    	
    	// Use Actions to clear and input the text
    	

    	// Click to focus on the input element, send BACK_SPACE keys to clear, and then input text
    	actions.click(correctAnswerInput1)
    	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
    	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
    	       .sendKeys("1912")  // Input the new data
    	       .perform();
    	 Thread.sleep(3000);
    	// Locate the image element inside the span
  	        WebElement imageElement1 = driver.findElement(By.xpath("(//*[name()='circle'])[20]"));

  	        // Perform hover action using Actions class
  	        
  	        actions.moveToElement(imageElement1).perform();

  	        // Locate the parent <span> element that contains the tooltip
  	        WebElement tooltipSpan1 = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[2]"));

  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
  	        String actualTooltipText1 = tooltipSpan1.getAttribute("data-tooltip");

  	        // Define the expected tooltip text (update this based on your expectations)
  	        String expectedTooltipText1 = "Set the range to be guessed from";

  	        // Validate the tooltip text
  	        if (actualTooltipText1.equals(expectedTooltipText1)) {
  	            System.out.println("Tooltip validation passed: " + actualTooltipText1);
  	        } else {
  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText1 + ", but found: " + actualTooltipText1);
  	        }
  	        Thread.sleep(1000);
    	

  	      
  	  
    	WebElement correctAnswerInput2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startNumber")));
    	Thread.sleep(1000);
    	correctAnswerInput2.click();
    	correctAnswerInput2.clear();
    	Thread.sleep(3000);
    	correctAnswerInput2.sendKeys("1910");
    	Thread.sleep(2000);
    	WebElement correctAnswerInput3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("endNumber")));
    	Thread.sleep(1000);
    	correctAnswerInput3.click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value = '';",correctAnswerInput3 ); 
    	Thread.sleep(3000);
    	correctAnswerInput3.sendKeys("1920");
    	
    	Thread.sleep(2000);
    	correctAnswerInput3.click();
    	
    	
    
    	Thread.sleep(3000);
    	
    	
	  		// Locate the image element inside the span
	  	  	        WebElement imageElement3 = driver.findElement(By.xpath(("(//h5[@class='modal-title my-3']//span)[3]")));

	  	  	        // Perform hover action using Actions class
	  	  	        
	  	  	        actions.moveToElement(imageElement3).perform();

	  	  	        // Locate the parent <span> element that contains the tooltip
	  	  	        WebElement tooltipSpan3 = driver.findElement(By.xpath("(//span[@class='ms-1 right-side-bar-guess-number-heading-tooltip-top'])[3]"));

	  	  	        // Retrieve the tooltip text from the 'data-tooltip' attribute
	  	  	        String actualTooltipText3= tooltipSpan3.getAttribute("data-tooltip");

	  	  	        // Define the expected tooltip text (update this based on your expectations)
	  	  	        String expectedTooltipText3 = "Set the scale range for guessing accuracy.";

	  	  	        // Validate the tooltip text
	  	  	        if (actualTooltipText3.equals(expectedTooltipText3)) {
	  	  	            System.out.println("Tooltip validation passed: " + actualTooltipText3);
	  	  	        } else {
	  	  	            System.out.println("Tooltip validation failed. Expected: " + expectedTooltipText3 + ", but found: " + actualTooltipText3);
	  	  	        }
	  	  	        Thread.sleep(1000);
    	
    	driver.findElement(By.name("scale")).click();
    	driver.findElement(By.xpath("//option[normalize-space(text())='10']")).click();
    	Thread.sleep(1000);
        WebElement second = driver.findElement(By.xpath("(//div[contains(@class,'col-4 px-0')]//input)[1]"));
        Actions actions1 = new Actions(driver);
        actions1.click(second)
	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
	       .sendKeys("100")  // Input the new data
	       .perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Music']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='flexCheckDefault5'])[4]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='polygon'])[2]"))).click();
        
        driver.findElement(By.xpath("(//p[@class='mb-0'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='text-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys("C:\\Users\\Admin\\Downloads\\flower.png");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-save')]")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/Trashcan.png']"))).click();
        //Thread.sleep(1000);
       // driver.findElement(By.xpath("//img[@src='assets/images/Trashcan.png']")).click();
        // Locate the element using XPath (adjust XPath as needed)
        WebElement element = driver.findElement(By.xpath("(//h5[@class='modal-title mb-0'])[3]"));

        // Retrieve the value of the "cursor" CSS property
        String cursorValue = element.getCssValue("cursor");

        // Output the cursor property value
        System.out.println("Cursor value for the element: " + cursorValue);

        // Check if the cursor indicates a disabled element
        if ("not-allowed".equals(cursorValue)) {
            System.out.println("Themes is disabled (cursor: not-allowed).");
        } else {
            System.out.println("Themes is enabled (cursor: " + cursorValue + ").");
        }
         
	}
	 @Test(priority = 16)
		public void lineupTest() throws InterruptedException {
//			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Slide']"))).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("(//a[@class='slide-list-hover'])[15]")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Lineup']"))).sendKeys("Rank the orders");
	    	    driver.navigate().refresh();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add a longer description']"))).click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@maxlength='150']"))).sendKeys("Must respond");
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 1']"))).sendKeys("Cat");
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 2']"))).sendKeys("Dog");
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 3']"))).sendKeys("Birds");
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Order ']"))).click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Order ']"))).click();
	          Thread.sleep(5000);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 4']"))).click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 4']"))).sendKeys("Fish");
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Order 5']"))).sendKeys("Rat");
	          WebElement second = driver.findElement(By.xpath("(//div[contains(@class,'col-4 px-0')]//input)[1]"));
	          Actions actions = new Actions(driver);
	          actions.click(second)
	  	       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)  // Select all text (Ctrl + A)
	  	       .sendKeys(Keys.BACK_SPACE)  // Delete the selected text
	  	       .sendKeys("100")  // Input the new data
	  	       .perform();
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Music']"))).click();
	          Thread.sleep(1000);
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='flexCheckDefault5'])[4]"))).click();
	          Thread.sleep(1000);
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
	          Thread.sleep(1000);
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='collopse-border d-flex align-item-center mb-2 active-music'])[1]"))).click();
	          Thread.sleep(1000);
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='polygon'])[2]"))).click();
	          
	          driver.findElement(By.xpath("(//p[@class='mb-0'])[3]")).click();
	          Thread.sleep(1000);
	          driver.findElement(By.xpath("//a[@class='text-primary']")).click();
	          Thread.sleep(1000);
	          driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys("C:\\Users\\Admin\\Downloads\\flower.png");
	          Thread.sleep(3000);
	          driver.findElement(By.xpath("//button[contains(@class,'btn btn-save')]")).click();
	          Thread.sleep(1000);
	          //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/Trashcan.png']"))).click();
	          //Thread.sleep(1000);
	         // driver.findElement(By.xpath("//img[@src='assets/images/Trashcan.png']")).click();
	          // Locate the element using XPath (adjust XPath as needed)
	          WebElement element = driver.findElement(By.xpath("(//h5[@class='modal-title mb-0'])[3]"));

	          // Retrieve the value of the "cursor" CSS property
	          String cursorValue = element.getCssValue("cursor");

	          // Output the cursor property value
	          System.out.println("Cursor value for the element: " + cursorValue);

	          // Check if the cursor indicates a disabled element
	          if ("not-allowed".equals(cursorValue)) {
	              System.out.println("Themes is disabled (cursor: not-allowed).");
	          } else {
	              System.out.println("Themes is enabled (cursor: " + cursorValue + ").");
	          }
	           
	    }
	

 	    
 	    
  	

    
    @Test(priority = 17)
    public void testCopyLinkAndPresent() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 //go to first slide
    	 driver.findElement(By.xpath("//span[normalize-space()='1']")).click();
    	 //click copy link
    	driver.findElement(By.className("icon-svg")).click();
    	//click present button
    	driver.findElement(By.xpath("//button[./img[contains(@src, 'play_arrow.svg')]]")).click();
    	 //screenshot for multiple choice presenter page
    	 Thread.sleep(3000);
         File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         Files.copy(screenshotFile1, new File("C:\\Users\\Admin\\Downloads\\screenshot\\multiple_Presenter.png"));//multiple presenter
         Thread.sleep(3000);
         
      // Get the copied link from the clipboard
         String presentationLink = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
         String currentWindowHandle = driver.getWindowHandle();

         // Open a new tab and navigate to the presentation link
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.open();");

         Set<String> windowHandles = driver.getWindowHandles();
         String[] handles = windowHandles.toArray(new String[0]);
         driver.switchTo().window(handles[handles.length - 1]); // Switch to the new tab
         driver.get(presentationLink);
       
         //multiple choice before response
         Thread.sleep(3000);
         File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         Files.copy(screenshotFile2, new File("C:\\Users\\Admin\\Downloads\\screenshot\\multiple_audience_beforereponse.png"));//multiple presenter
         Thread.sleep(5000);
         
     	//Submit response for multiple choice
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[1]"))).click();
         Thread.sleep(1000);
         
    	 JavascriptExecutor js0 = (JavascriptExecutor) driver;

    	// Scroll to the bottom of the page
    	js0.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    	Thread.sleep(5000);
	      // Locate the element you want to scroll to
	         WebElement element = driver.findElement(By.xpath("//img[@class='showreacts ng-tns-c41-0']"));

	         // Use JavaScript to scroll the element into view
	         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	         // Optionally, you can add a short wait here to ensure the scroll action completes
	         Thread.sleep(2000); // Pause for half a second if needed

	         // Now, click the element
	         element.click();
	        
	         Thread.sleep(1000);
	         driver.findElement(By.xpath("//div[@id='reaction-1']//img[1]")).click();
	         Thread.sleep(1000);
	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
	         Thread.sleep(1000);
	         driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[2]")).click();
	         Thread.sleep(3000);
	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
	         Thread.sleep(1000);
	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
	         Thread.sleep(1000);
	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	         Thread.sleep(2000);
         WebElement mc_submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));
 	    mc_submit.click();
 	   Thread.sleep(3000);
 	   
 	   
 	   driver.switchTo().window(currentWindowHandle);
 	  Actions actions2 = new Actions(driver);
 	  actions2.sendKeys(Keys.ENTER).perform();
 	  
 	  
 	  
       //multiple choice after response
       Thread.sleep(3000);
       File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       Files.copy(screenshotFile3, new File("C:\\Users\\Admin\\Downloads\\screenshot\\multiple_audience_afterreponse.png"));//multiple presenter
       Thread.sleep(3000);
       
 	   
 	  Thread.sleep(1000);
 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();

      //word cloud presenter 
      Thread.sleep(3000);
      File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Files.copy(screenshotFile4, new File("C:\\Users\\Admin\\Downloads\\screenshot\\word cloud_presenter.png"));
      Thread.sleep(3000);
      
 	  
 	  
 	 windowHandles = driver.getWindowHandles();
     handles = windowHandles.toArray(new String[0]);

     // Switch to the new tab after clicking Next Slide
     driver.switchTo().window(handles[handles.length - 1]);
     //word cloud audienece before response
     Thread.sleep(3000);
     File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     Files.copy(screenshotFile5, new File("C:\\Users\\Admin\\Downloads\\screenshot\\word cloud_audience.png"));
     Thread.sleep(3000);
     
      driver.findElement(By.id("word-0")).sendKeys("apple");
      driver.findElement(By.id("word-1")).sendKeys("aeroplane");
      driver.findElement(By.id("word-2")).sendKeys("ant");
      driver.findElement(By.id("word-3")).sendKeys("anchor");
      driver.findElement(By.id("word-4")).sendKeys("animation");
      
     
   // Locate the element you want to scroll to
      WebElement element1 = driver.findElement(By.xpath("//span[normalize-space(text())='Emoji']"));

      // Use JavaScript to scroll the element into view
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

      // Optionally, you can add a short wait here to ensure the scroll action completes
      Thread.sleep(2000); // Pause for half a second if needed

      // Now, click the element
      element1.click();
        driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("comment")).sendKeys("yashh!!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        Thread.sleep(2000);
      
        driver.findElement(By.xpath("(//button[contains(@class,'btn btn-primary')])[1]")).click();
      		
      		Thread.sleep(1000);
		
		  driver.switchTo().window(currentWindowHandle);
		//word cloud audienece after response
		     Thread.sleep(3000);
		     File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile6, new File("C:\\Users\\Admin\\Downloads\\screenshot\\word cloud_afterrespose.png"));
		     Thread.sleep(3000);
	 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
	 	//openended presenter
		     Thread.sleep(3000);
		     File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile7, new File("C:\\Users\\Admin\\Downloads\\screenshot\\openendedpresenter.png"));
		     Thread.sleep(3000);
		     
	 	  windowHandles = driver.getWindowHandles();
	     handles = windowHandles.toArray(new String[0]);

	     // Switch to the new tab after clicking Next Slide
	     driver.switchTo().window(handles[handles.length - 1]);
	     Thread.sleep(1000);
	     
	   //openeneded audience
	     Thread.sleep(3000);
	     File screenshotFile8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     Files.copy(screenshotFile8, new File("C:\\Users\\Admin\\Downloads\\screenshot\\openended_audienece.png"));
	     Thread.sleep(3000);
	   
	     
	     WebElement   oe_ans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@maxlength='200'])[1]")));
			oe_ans.click();
			oe_ans.sendKeys("education is the key to success");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']"))).click();
			Thread.sleep(1000);
			
			WebElement element2 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

	        // Use JavaScript to scroll the element into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
	        element2.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.id("comment")).sendKeys("yashh!!");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
//        Thread.sleep(2000);
			
			 driver.switchTo().window(currentWindowHandle);
			 
			 //openeneded after responses
		     Thread.sleep(3000);
		     File screenshotFile9 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile9, new File("C:\\Users\\Admin\\Downloads\\screenshot\\openended_afterresponses.png"));
		     Thread.sleep(3000);
		   
			 
			
			 Thread.sleep(1000);
		 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
		 	 
		 	  
		 	  //scales presenter
		     Thread.sleep(3000);
		     File screenshotFile10 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile10, new File("C:\\Users\\Admin\\Downloads\\screenshot\\scales_presenter.png"));
		     Thread.sleep(3000);
		     
		     
		 	 
		 	 windowHandles = driver.getWindowHandles();
		     handles = windowHandles.toArray(new String[0]);

		     // Switch to the new tab after clicking Next Slide
		     driver.switchTo().window(handles[handles.length - 1]);
		     
		    
		   //scales audience
		     Thread.sleep(3000);
		     File screenshotFile11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile11, new File("C:\\Users\\Admin\\Downloads\\screenshot\\scales_audienece.png"));
		     Thread.sleep(3000);
		     //js.executeScript("document.body.style.zoom='33%';");
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("(//div[@class='point-circle ng-tns-c41-0'])[1]")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("/html/body/app-root/app-audience/div[1]/section/div/div[2]/div/div/div[3]/form/div[3]/div[2]/div/div[3]/div[1]")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//div[5]//div[2]//div[1]//div[4]//div[1]")).click();
		     Thread.sleep(9000);
		     
		     Actions actions = new Actions(driver);
		     actions.sendKeys(Keys.PAGE_DOWN).perform();
//		     WebElement element0 = driver.findElement(By.xpath("//span[normalize-space()='D.']"));
//		     JavascriptExecutor js00 = (JavascriptExecutor) driver;
//		     js00.executeScript("arguments[0].scrollIntoView(true);", element0);
		     driver.findElement(By.xpath("//body[1]/app-root[1]/app-audience[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[7]/div[2]/div[1]/div[4]")).click();
		     driver.findElement(By.xpath("//div[7]//div[2]//div[1]//div[4]//div[1]")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//div[9]//div[2]//div[1]//div[2]//div[1]")).click();
		     Thread.sleep(3000);
		     Actions actions20 = new Actions(driver);
		     actions20.sendKeys(Keys.PAGE_DOWN).perform();
		     
//		     Thread.sleep(3000);
//		     js.executeScript("document.body.style.zoom='100%';");
		     
//             JavascriptExecutor js2 = (JavascriptExecutor) driver;
//             Thread.sleep(5000);	
//         	// Scroll to the bottom of the page
//         	js2.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		     Thread.sleep(5000);	
		     actions.sendKeys(Keys.PAGE_DOWN).perform();
             WebElement element3 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

             // Use JavaScript to scroll the element into view
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
             element3.click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
             Thread.sleep(3000);
	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
	         Thread.sleep(1000);
	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
	         Thread.sleep(1000);
	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	         Thread.sleep(2000);
             
             WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
             WebElement sca_submit =wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Submit')]")));
             ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);", sca_submit);
             Thread.sleep(2000);
             sca_submit.click();
             Thread.sleep(1000);
             driver.switchTo().window(currentWindowHandle);
             
             //scales afterresponses
		     Thread.sleep(3000);
		     File screenshotFile12 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile12, new File("C:\\Users\\Admin\\Downloads\\screenshot\\scales_afterresponses.png"));
		     Thread.sleep(3000);
            
             Thread.sleep(1000);
        	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
        	  Thread.sleep(1000);
        	  
        	  //ranking presenter
 		     Thread.sleep(3000);
 		     File screenshotFile13 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 		     Files.copy(screenshotFile13, new File("C:\\Users\\Admin\\Downloads\\screenshot\\ranking_presenter.png"));
 		     Thread.sleep(3000);
        	  
        	  
        	 windowHandles = driver.getWindowHandles();
            handles = windowHandles.toArray(new String[0]);

            // Switch to the new tab after clicking Next Slide
            driver.switchTo().window(handles[handles.length - 1]);
            Thread.sleep(1000);
            
            //ranking audience
		     Thread.sleep(3000);
		     File screenshotFile14 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     Files.copy(screenshotFile14, new File("C:\\Users\\Admin\\Downloads\\screenshot\\ranking_audienece.png"));
		     Thread.sleep(3000);
		     JavascriptExecutor jsa = (JavascriptExecutor) driver;
		     jsa.executeScript("window.scrollTo(0, 0);");
		     
           
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
        	 JavascriptExecutor js9 = (JavascriptExecutor) driver;
        	 js9.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        	 Thread.sleep(3000);
        	 WebElement element4 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

             // Use JavaScript to scroll the element into view
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
             element4.click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
//             Thread.sleep(3000);
//	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
////	         Thread.sleep(1000);
//	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
//	         Thread.sleep(1000);
//	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//	         Thread.sleep(2000);
//	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
//	         Thread.sleep(2000);
//       	 
             Thread.sleep(3000);
        	 JavascriptExecutor js3 = (JavascriptExecutor) driver;

        	// Scroll to the bottom of the page
        	js3.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        	 WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));
        	    element5.click();
        	    Thread.sleep(1000);
        	    driver.switchTo().window(currentWindowHandle);
        	    
        	    //ranking afterresponses
   		     Thread.sleep(3000);
   		     File screenshotFile15 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   		     Files.copy(screenshotFile15, new File("C:\\Users\\Admin\\Downloads\\screenshot\\ranking_afterresponses.png"));
   		     Thread.sleep(3000);
        	  
        	    Thread.sleep(1000);
        	 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
        	 	 Thread.sleep(1000);
        	 	 
        	 	   //qa presenter
       		     Thread.sleep(3000);
       		     File screenshotFile16 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile16, new File("C:\\Users\\Admin\\Downloads\\screenshot\\qaprsenter.png"));
       		     Thread.sleep(3000);
       		     
       		     
        	 	 windowHandles = driver.getWindowHandles();
        	     handles = windowHandles.toArray(new String[0]);

        	     // Switch to the new tab after clicking Next Slide
        	     driver.switchTo().window(handles[handles.length - 1]);
        	     
        	     
        	     //qa audienece
       		     Thread.sleep(3000);
       		     File screenshotFile17 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile17, new File("C:\\Users\\Admin\\Downloads\\screenshot\\qaaudienece.png"));
       		     Thread.sleep(3000);
       		     
       		     
                 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='validationTextarea']"))).sendKeys("this website is too good");
                 Thread.sleep(3000);
                 driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
                 Thread.sleep(3000);
                 WebElement element6 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

                 // Use JavaScript to scroll the element into view
                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element6);
                 element6.click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
                /* Thread.sleep(3000);
    	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
    	         Thread.sleep(1000);
    	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
    	         Thread.sleep(1000);
    	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
    	         Thread.sleep(2000);
    	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
    	         Thread.sleep(2000);
    	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
    	         Thread.sleep(2000);
    	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    	         Thread.sleep(2000);
    	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    	         Thread.sleep(2000);*/
            	 
                 
                 //File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                 //Files.copy(screenshotFile2, new File("C:\\Users\\DHT-IT-018\\Downloads\\slideone\\qa_A.png"));//A=audience
                
                 Thread.sleep(1000);
                
                 
                
                 driver.switchTo().window(currentWindowHandle);
                 
                 //qa afterresponses
       		     Thread.sleep(3000);
       		     File screenshotFile18 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile18, new File("C:\\Users\\Admin\\Downloads\\screenshot\\qaafterresponses.png"));
       		     Thread.sleep(3000);
                 
               
                      
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                 
                 //guess the number presenter
       		     Thread.sleep(6000);
       		     File screenshotFile19 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile19, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guess_prsenter.png"));
       		     Thread.sleep(3000);
                 
              // Switch back to the new window after clicking Next Slide
                 windowHandles = driver.getWindowHandles();
                 handles = windowHandles.toArray(new String[0]);

                 // Switch to the new tab after clicking Next Slide
                 driver.switchTo().window(handles[handles.length - 1]);
                 
                 
               //guessthe number audienece
       		     Thread.sleep(3000);
       		     File screenshotFile20 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile20, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guess_audience.png"));
       		     Thread.sleep(3000);
                
              // Wait for the range slider to be visible
                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                 WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("guessthenumberRangeBar")));

                 // Check if the element is visible and interactable
                 if (slider.isDisplayed() && slider.isEnabled()) {
                     // Set the slider value using JavaScript
                     JavascriptExecutor js11 = (JavascriptExecutor) driver;
                     
                     // Set the value to 5
                     js11.executeScript("arguments[0].value = '60';", slider);
                     
                     // Dispatch both 'input' and 'change' events to simulate user interaction
                     js11.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", slider);
                     js11.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", slider);
                     
                     // Optionally log to verify the slider value
                     System.out.println("Slider value set to 60.");
                 } else {
                     System.out.println("Slider is not visible or interactable.");
                 }
                 WebElement element7 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

                 // Use JavaScript to scroll the element into view
                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element7);
                 element7.click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
                 Thread.sleep(3000);
    	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
    	         Thread.sleep(1000);
    	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
    	         Thread.sleep(1000);
    	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
    	         Thread.sleep(3000);
//    	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
//    	         Thread.sleep(2000);

                
                 
                 driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
                
                 driver.switchTo().window(currentWindowHandle);
                 Thread.sleep(2000);
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='enter-btn-txt']"))).click();
                 
                 
                 //guessthe number afterresponses
       		     Thread.sleep(3000);
       		     File screenshotFile21 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile21, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guess_afterresponses.png"));
       		     Thread.sleep(3000);
                 
                 
                 
                 
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                 
               //this or that presenter
       		     Thread.sleep(3000);
       		     File screenshotFile22 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile22, new File("C:\\Users\\Admin\\Downloads\\screenshot\\thisorthat_presenter.png"));
       		     Thread.sleep(3000);
                 
                  
                 
                 windowHandles = driver.getWindowHandles();
                 handles = windowHandles.toArray(new String[0]);

                 // Switch to the new tab after clicking Next Slide
                 driver.switchTo().window(handles[handles.length - 1]);
                 
               //this or that audienece
       		     Thread.sleep(3000);
       		     File screenshotFile23 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile23, new File("C:\\Users\\Admin\\Downloads\\screenshot\\thisorthat_audienece.png"));
       		     Thread.sleep(3000);
                 
                 
              
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //label[@for='JUICE1']//div[@class='d-block ng-tns-c41-0']"))).click();
                 
                 
                 WebElement element8 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

                 // Use JavaScript to scroll the element into view
                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element8);
                 element8.click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("//div[@id='reaction-0']//img[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[1]")).click();
                 Thread.sleep(3000);
    	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
    	         Thread.sleep(1000);
    	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
    	         Thread.sleep(1000);
    	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
     	         Thread.sleep(3000);
//    	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    	         Thread.sleep(2000);
                 
                 driver.findElement(By.xpath("//span[@class='summit-btn-align ng-tns-c41-0']")).click();
                 
                
                 
                 driver.switchTo().window(currentWindowHandle);
    
                 
               //this or that afterresponses
       		     Thread.sleep(3000);
       		     File screenshotFile24 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile24, new File("C:\\Users\\Admin\\Downloads\\screenshot\\thisorthat_afterresponses.png"));
       		     Thread.sleep(3000);
                 
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                
                 //trafficlight presenter
       		     Thread.sleep(3000);
       		     File screenshotFile25 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile25, new File("C:\\Users\\Admin\\Downloads\\screenshot\\trafficlight_prseneter.png"));
       		     Thread.sleep(3000);
                 
                 
                 
                 
                 
              // Switch back to the new window after clicking Next Slide
                 windowHandles = driver.getWindowHandles();
                 handles = windowHandles.toArray(new String[0]);

                 // Switch to the new tab after clicking Next Slide
                 driver.switchTo().window(handles[handles.length - 1]);
                 
                 //trafficlight_audience
       		     Thread.sleep(3000);
       		     File screenshotFile26 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile26, new File("C:\\Users\\Admin\\Downloads\\screenshot\\trafficlight_audience.png"));
       		     Thread.sleep(3000);
                 
                 
                 
       		     driver.findElement(By.id("Yellow1")).click();
                 JavascriptExecutor js21 = (JavascriptExecutor) driver;

              	// Scroll to the bottom of the page
              	js21.executeScript("window.scrollTo(0, document.body.scrollHeight);");
              	Thread.sleep(1000);
                 
                 WebElement element9 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

                 // Use JavaScript to scroll the element into view
                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element9);
                 element9.click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("//div[@id='reaction-4']//img[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[5]")).click();
                 Thread.sleep(3000);
    	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
    	         Thread.sleep(1000);
    	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
    	         Thread.sleep(1000);
    	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
    	         Thread.sleep(3000);
//    	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//    	         Thread.sleep(2000);
//    	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
//    	         Thread.sleep(2000);
                 
                 driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")).click();
               
                 Thread.sleep(1000);  
                 driver.switchTo().window(currentWindowHandle);
                 
               //trafficlight_afterresponses
       		     Thread.sleep(3000);
       		     File screenshotFile27 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile27, new File("C:\\Users\\Admin\\Downloads\\screenshot\\trafficlight_afterresponses.png"));
       		     Thread.sleep(3000);
                
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                 //Thread.sleep(3000);

                 //truth_or_lie_presenter
       		     Thread.sleep(3000);
       		     File screenshotFile28 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       		     Files.copy(screenshotFile28, new File("C:\\Users\\Admin\\Downloads\\screenshot\\truth_or_lie_presenter.png"));
       		     Thread.sleep(3000);
                 
                 
                 // Switch back to the new window after clicking Next Slide
                    windowHandles = driver.getWindowHandles();
                    handles = windowHandles.toArray(new String[0]);

                    // Switch to the new tab after clicking Next Slide
                    driver.switchTo().window(handles[handles.length - 1]);
                    
                    //truth_or_lie_audience
          		     Thread.sleep(3000);
          		     File screenshotFile29 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile29, new File("C:\\Users\\Admin\\Downloads\\screenshot\\truth_or_lie_audience.png"));
          		     Thread.sleep(3000);
                    
                    
                    
                   
                    driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
                   Thread.sleep(1000);
                   driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
                   Thread.sleep(1000);
                   WebElement element11 = driver.findElement(By.id("2"));

                   // Scroll to the element using JavaScriptExecutor
                   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element11);
                  
                   // Wait a moment after scrolling
                   Thread.sleep(500);

                   // Click the element
                   element11.click();
                   driver.findElement(By.xpath("(//input[@type='radio'])[7]")).click();
                   Thread.sleep(1000);
                   driver.findElement(By.xpath("(//input[@type='radio'])[9]")).click();
                   
                   WebElement element10 = driver.findElement(By.xpath("//span[@class='showreacts ng-tns-c41-0']"));

                   // Use JavaScript to scroll the element into view
                   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element10);
                   element10.click();
                   Thread.sleep(1000);
                   driver.findElement(By.xpath("//div[@id='reaction-4']//img[1]")).click();
                   Thread.sleep(1000);
                   driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0']//img)[1]")).click();
                   Thread.sleep(1000);
                   driver.findElement(By.xpath("(//button[contains(@class,'btn select-message-badge')])[5]")).click();
                   Thread.sleep(3000);
      	         driver.findElement(By.xpath("(//div[@class='qr-react-qa-sections ng-tns-c41-0'])[1]")).click();
      	         Thread.sleep(1000);
      	         driver.findElement(By.id("comment")).sendKeys("yashh!!");
      	         Thread.sleep(1000);
      	         driver.findElement(By.xpath("//button[normalize-space(text())='Send Comment']")).click();
      	         Thread.sleep(3000);
//      	         driver.findElement(By.xpath("//span[normalize-space(text())='Ask a Question']")).click();
//      	         Thread.sleep(2000);
//      	         driver.findElement(By.id("validationTextarea")).sendKeys("what up!!");
//      	         Thread.sleep(2000);
//      	         driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//      	         Thread.sleep(2000);
//      	         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
      	         Thread.sleep(2000);
                   
                   driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
                   
                 
                  
                    
                    Thread.sleep(3000);
                   
                    
                    
                    driver.switchTo().window(currentWindowHandle);
                    
                    
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(3000);
                    
                    //truth_or_lie_afterresponses
                    Thread.sleep(3000);
         		     File screenshotFile30 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         		     Files.copy(screenshotFile30, new File("C:\\Users\\Admin\\Downloads\\screenshot\\truth_or_lie_afterresponses.png"));
         		     Thread.sleep(3000);
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                    Thread.sleep(3000);
                    windowHandles = driver.getWindowHandles();
                    handles = windowHandles.toArray(new String[0]);

               
                    driver.switchTo().window(handles[handles.length - 1]);
                    
                    Thread.sleep(3000);

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))).click();
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))).sendKeys("bean");
                    Thread.sleep(3000);
                    File screenshotFile31 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile31, new File("C:\\Users\\Admin\\Downloads\\screenshot\\joinpage.png"));

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-primary btn-align w-100 ng-tns-c41-0'])[1]"))).click();
                    driver.switchTo().window(currentWindowHandle);
                    Thread.sleep(3000);
                    Thread.sleep(3000);
                    File screenshotFile32 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile32, new File("C:\\Users\\Admin\\Downloads\\screenshot\\selectanswerpresenter.png"));

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()=\"Let's go\"])[1]"))).click();
                    windowHandles = driver.getWindowHandles();
                    handles = windowHandles.toArray(new String[0]);

               
                    driver.switchTo().window(handles[handles.length - 1]);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    Thread.sleep(5000);
                    
                    Thread.sleep(3000);
                    File screenshotFile33 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile33, new File("C:\\Users\\Admin\\Downloads\\screenshot\\select answer audience.png"));

                   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set an explicit wait for 20 seconds
                    WebElement element99 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='options ng-tns-c41-0']//div)[2]")));
                    element99.click();
                    Thread.sleep(3000);

                    WebElement submit = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
                   
                    Thread.sleep(8000);
                   
                    driver.switchTo().window(currentWindowHandle);
                    Thread.sleep(3000);
                    
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                    Thread.sleep(5000);
                    Thread.sleep(3000);
                    File screenshotFile34 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile34, new File("C:\\Users\\Admin\\Downloads\\screenshot\\selectanswerquizscore.png"));

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Leading Board']"))).click();
                    Thread.sleep(3000);
                    Thread.sleep(3000);
                    File screenshotFile35 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile35, new File("C:\\Users\\Admin\\Downloads\\screenshot\\selectanswerleading.png"));

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                    Thread.sleep(3000);
                    Thread.sleep(3000);
                    File screenshotFile36 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile36, new File("C:\\Users\\Admin\\Downloads\\screenshot\\typeanswerpresenter.png"));

                    
                    actions.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(3000);
                       handles = windowHandles.toArray(new String[0]);

                    
                       driver.switchTo().window(handles[handles.length - 1]);
                       Thread.sleep(8000);
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter a word']"))).sendKeys("lion");
                       Thread.sleep(2000);
                       Thread.sleep(3000);
                       File screenshotFile37 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile37, new File("C:\\Users\\Admin\\Downloads\\screenshot\\typeansweraudience.png"));

                       
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Submit')]"))).click();
                       Thread.sleep(10000);
                       
                       driver.switchTo().window(currentWindowHandle);
                       Thread.sleep(3000);
                       
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                       Thread.sleep(5000);
                       Thread.sleep(3000);
                       File screenshotFile38 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile38, new File("C:\\Users\\Admin\\Downloads\\screenshot\\typeanswerscore.png"));

                       
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Leading Board']"))).click();
                       Thread.sleep(3000);
                       Thread.sleep(3000);
                       File screenshotFile39 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile39, new File("C:\\Users\\Admin\\Downloads\\screenshot\\typeanswerleading.png"));

                       
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                       Thread.sleep(3000);
                       Thread.sleep(3000);
                       File screenshotFile40 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile40, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guessquizpresenter.png"));

                      
                       actions.sendKeys(Keys.ENTER).perform();
                       Thread.sleep(3000);

                       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='position-menu-bottom-last-lineup']//span[1]"))).click();
                       windowHandles = driver.getWindowHandles();
                       handles = windowHandles.toArray(new String[0]);

                  
                       driver.switchTo().window(handles[handles.length - 1]);
                       Thread.sleep(3000);
                       File screenshotFile41 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile41, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guessquizaudience.png"));

                       
                       WebElement slider1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("guessthenumberRangeBar")));
            	         if (slider1.isDisplayed() && slider1.isEnabled()) {
            	             JavascriptExecutor js11 = (JavascriptExecutor) driver;
            	             js11.executeScript("arguments[0].value = '1912';", slider1);  
            	             js11.executeScript("arguments[0].dispatchEvent(new Event('input'));", slider1);
            	         } else {
            	             System.out.println("Slider is not visible or interactable.");
            	         }
            	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[@class='btn btn-primary btn-align w-100 ng-tns-c41-0']"))).click();
                  	
                  	  driver.switchTo().window(currentWindowHandle);
                      
                  	 Thread.sleep(3000);
                  	Thread.sleep(3000);
                    File screenshotFile42 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          		     Files.copy(screenshotFile42, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guessquizafterresponses.png"));

                     
                     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                     Thread.sleep(5000);
                     Thread.sleep(3000);
                     File screenshotFile43 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           		     Files.copy(screenshotFile43, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guessquizquizscore.png"));

                     
                     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Leading Board']"))).click();
                     Thread.sleep(3000);
                     Thread.sleep(3000);
                     File screenshotFile44 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           		     Files.copy(screenshotFile44, new File("C:\\Users\\Admin\\Downloads\\screenshot\\guessquizleading.png"));

                     
                     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                     Thread.sleep(3000);
                     Thread.sleep(3000);
                     File screenshotFile45 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           		     Files.copy(screenshotFile45, new File("C:\\Users\\Admin\\Downloads\\screenshot\\lineuppresenterquiz.png"));

                      
                     actions.sendKeys(Keys.ENTER).perform();
                     Thread.sleep(3000);
                      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='position-menu-bottom-last-lineup']//span[1]"))).click();
                      windowHandles = driver.getWindowHandles();
                      handles = windowHandles.toArray(new String[0]);

                 
                      driver.switchTo().window(handles[handles.length - 1]);
                      Thread.sleep(3000);
                      Thread.sleep(3000);
                      File screenshotFile46 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            		     Files.copy(screenshotFile46, new File("C:\\Users\\Admin\\Downloads\\screenshot\\lineupaudiencequiz.png"));

                      Thread.sleep(3000);
            		    // js.executeScript("document.body.style.zoom='50%';");
            		     Thread.sleep(3000);
                      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
                 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
                 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
                 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
                 	Thread.sleep(3000);
                 	actions.sendKeys(Keys.PAGE_DOWN).perform();
               	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='text-decoration-none drag-hand'])[1]"))).click();
               	 JavascriptExecutor js4 = (JavascriptExecutor) driver;
               	   	js4.executeScript("window.scrollTo(0, document.body.scrollHeight);");
               	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Submit')]"))).click();  
                   
                 	   driver.switchTo().window(currentWindowHandle);
                 	  Thread.sleep(3000);
                 	 Thread.sleep(3000);
                     File screenshotFile47 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           		     Files.copy(screenshotFile47, new File("C:\\Users\\Admin\\Downloads\\screenshot\\lineupafterresponses.png"));

                      
                      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-tooltip='Next Slide']"))).click();
                      Thread.sleep(5000);
                      Thread.sleep(3000);
                      File screenshotFile48 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            		     Files.copy(screenshotFile48, new File("C:\\Users\\Admin\\Downloads\\screenshot\\lineupquizscore.png"));

                       
                      
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Champion Board']"))).click();
                       Thread.sleep(3000);
                       File screenshotFile49 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             		     Files.copy(screenshotFile49, new File("C:\\Users\\Admin\\Downloads\\screenshot\\champian board.png"));

                       windowHandles = driver.getWindowHandles();
                       handles = windowHandles.toArray(new String[0]);

                      
                       driver.switchTo().window(handles[handles.length - 1]);
                       Thread.sleep(3000);
                       
        
    }
	
	
}
