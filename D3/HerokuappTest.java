import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HerokuappTest {

	//Set up the driver
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Heroku for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com");
	}
	
	
	// Given that I am on the main page
	// When I view the header
	// Then I see that it contains "CS1632 D3 Home", "Factorial", "Fibonacci", "Hello", and "Cathedral Pics" links
	@Test
	public void testMainHasCorrectLinks() 
	{
		// Check for CS1632 D3 Home, Factorial, Fibonacci, Hello, and Cathedral Pics links 
		// If any of these is not found, fail the test
		
		try {
			driver.findElement(By.linkText("CS1632 D3 Home"));
			driver.findElement(By.linkText("Factorial"));
			driver.findElement(By.linkText("Fibonacci"));
			driver.findElement(By.linkText("Hello"));
			driver.findElement(By.linkText("Cathedral Pics"));
		} catch (NoSuchElementException nseex) {
			fail();
		}//end of try catch
	}//end of testMainHasCorrectLinks()
	
	// Given that I am on the main page
	// When I click on the "Factorial" link and I am redirected to the "Factorial" page
	// Then I should see the URL to end with to the "/fact" page
	@Test
	public void testFactLink() 
	{
		
		// find the "Factorial" link and click on it
		// The page you go to should have the URL (/fact) without any trailing values
		driver.findElement(By.linkText("Factorial")).click();
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("https://cs1632ex.herokuapp.com/fact"));
	}
	
	// Given that I am on the main page
	// When I click on the "Fibonacci" link and I am redirected to the "Fibonacci" page
	// Then I should see the URL to end with to the "/fib" page
	@Test
	public void testFibLink() 
	{
		
		// find the "Factorial" link and click on it
		// The page you go to should have the URL (/fact) without any trailing values
		driver.findElement(By.linkText("Fibonacci")).click();
		String url = driver.getCurrentUrl();
		//System.err.format("var: %s\n", url);
		assertTrue(url.contains("https://cs1632ex.herokuapp.com/fib"));
	}
	
	// Given that I am on the main page
	// When I click on the "Hello" link and I am redirected to the "Hello" page
	// Then I should see the URL to end with to the "/hello" page
	@Test
	public void testHelloLink() 
	{
		
		// find the "Factorial" link and click on it
		// The page you go to should have the URL (/fact) without any trailing values
		driver.findElement(By.linkText("Hello")).click();
		String url = driver.getCurrentUrl();
		//System.err.format("var: %s\n", url);
		assertTrue(url.contains("https://cs1632ex.herokuapp.com/hello"));
	}

	
	//Given that I am on the Fibonacci Page
	//When I enter a positive integer (e.g., 5) and press submit
	//Then I will see the Fibonacci of the value (e.g., 8)
	@Test
	public void testValidIntFibonacci()
	{
		
		//Start on the factorial page
		driver.get("https://cs1632ex.herokuapp.com/fib");
		
		//Find the textbox and pass in the integer value 5
		WebElement textBox = driver.findElement(By.id("tb1"));
		textBox.sendKeys("5");
		
		//look for the submit button in textBox and click
		WebElement submitButton = driver.findElement(By.id("sub"));
		submitButton.click();
	
		//check to see if the answer is 8
		WebElement answer = driver.findElement(By.cssSelector("h2"));
		assertEquals(answer.getText(), "Fibonacci of 5 is 8!");
	}
	
	//Given that I am on the Fibonacci Page
	//When I enter a positive integer (e.g., 1) and press submit
	//Then I will see the Fibonacci of the value (e.g., 1)
	@Test
	public void testMinBoundFibonacci()
	{
		
		//Start on the factorial page
		driver.get("https://cs1632ex.herokuapp.com/fib");
		
		//Find the textbox and pass in the integer value 5
		WebElement textBox = driver.findElement(By.id("tb1"));
		textBox.sendKeys("1");
		
		//look for the submit button in textBox and click
		WebElement submitButton = driver.findElement(By.id("sub"));
		submitButton.click();
	
		//check to see if the answer is 8
		WebElement answer = driver.findElement(By.cssSelector("h2"));
		assertEquals(answer.getText(), "Fibonacci of 1 is 1!");
	}
	
	//Given that I am on the Fibonacci Page
	//When I enter a positive integer (e.g., 100) and press submit
	//Then I will see the Fibonacci of the value (e.g., 354224848179261915075)
	@Test
	public void testTopBoundFibonacci()
	{
		
		//Start on the factorial page
		driver.get("https://cs1632ex.herokuapp.com/fib");
		
		//Find the textbox and pass in the integer value 5
		WebElement textBox = driver.findElement(By.id("tb1"));
		textBox.sendKeys("100");
		
		//look for the submit button in textBox and click
		WebElement submitButton = driver.findElement(By.id("sub"));
		submitButton.click();
	
		//check to see if the answer is 8
		WebElement answer = driver.findElement(By.cssSelector("h2"));
		assertEquals(answer.getText(), "Fibonacci of 100 is 354224848179261915075!");
	}
	


	// Given that I am on the hello page (/hello)
	// and there are no trailing values in the URL
	//When I view the display message
	// Then I will see "Hello CS1632, from Prof. Laboon!" 
	@Test
	public void testDefaultHelloPageMessage() {
		
		//Start on the hello page
		driver.get("https://cs1632ex.herokuapp.com/hello");
		//check the display message 
		WebElement message = driver.findElement(By.cssSelector("h2"));
		assertEquals(message.getText(), "Hello CS1632, from Prof. Laboon!");
	
	}
	
	
	//Given that I am on the Cathedral Pics page (/cathy) 
	//When I view the entire page
	//Then I will see three images of the Cathedral of Learning in a numbered List
	@Test
	public void testCathedralPicsList()
	{
		//Start on the Cathedral Pics page
		driver.get("https://cs1632ex.herokuapp.com/cathy");
		
		// Check that there are three images 
		// If any of these is not found, fail the test
		try {
			driver.findElement(By.cssSelector("img[alt='Sunny Cathedral']"));
			driver.findElement(By.cssSelector("img[alt='Alpenglow Cathedral']"));
			driver.findElement(By.cssSelector("img[alt='Old Cathedral']"));
		} catch (NoSuchElementException nseex) {
			fail();
		}//end of try catch
	
	}

	
	
	
	
	
	
	
	
}//end of Herokuapp Test