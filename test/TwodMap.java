package org.tcs.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TwodMap {
	public static WebDriver driver;
	@Given("User launch the browser and enter the URL")
	public void user_launch_the_browser_and_enter_the_URL() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/telecom/index.html");
		WebElement btn = driver.findElement(By.xpath("//a[text()='Add Customer']"));
		btn.click();
		WebElement rbtn = driver.findElement(By.xpath("//label[@for='done']"));
		rbtn.click();
	
	    	}

	@When("User click Add customer button and fill the page")
	public void user_click_Add_customer_button_and_fill_the_page(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> l4 = dataTable.asMaps(String.class, String.class);    
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(l4.get(0).get("firstname"));
		  driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(l4.get(0).get("lastname"));
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(l4.get(0).get("emailid"));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(l4.get(0).get("address"));
		  driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(l4.get(0).get("mobno"));
		 
	    }

	@When("User click submit button")
	public void user_click_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	    }

	@Then("User Nvigates into Home page")
	public void user_Nvigates_into_Home_page() {
		String cUrl = driver.getCurrentUrl();
		if(cUrl.contains("telecom"))
		{
			System.out.println("Successfully Navigated in to Home page");
		}else
		System.out.println("Navigates to Someother page");
	   

	    }



}
