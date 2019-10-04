package org.tcs.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Onemap {
	public static WebDriver driver;
	@Given("USer launch the browser and enter Url")
	public void user_launch_the_browser_and_enter_Url() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/telecom/index.html");
		WebElement btn = driver.findElement(By.xpath("//a[text()='Add Customer']"));
		btn.click();
		WebElement rbtn = driver.findElement(By.xpath("//label[@for='done']"));
		rbtn.click();
	
	    }

	@When("User click Add customer button and fill")
	public void user_click_Add_customer_button_and_fill(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> ond = dataTable.asMap(String.class,String.class);    
	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(ond.get("Firstname"));
	  driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(ond.get("Lastname"));
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(ond.get("Email"));
	  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(ond.get("Address"));
	  driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(ond.get("Mob"));
	
	}

	@When("User click Submit button")
	public void user_click_Submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    }

	@Then("User Navigates into Home page")
	public void user_Navigates_into_Home_page() {
		String cUrl = driver.getCurrentUrl();
		if(cUrl.contains("telecom"))
		{
			System.out.println("Successfully Navigated in to Home page");
		}else
		System.out.println("Navigates to Someother page");
	   
	    }



}
