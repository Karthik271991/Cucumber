package org.tcs.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GuruTwoD {
	public static WebDriver driver;
	@Given("User launch the browser and enter URL")
	public void user_launch_the_browser_and_enter_URL() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/telecom/index.html");
		WebElement btn = driver.findElement(By.xpath("//a[text()='Add Customer']"));
		btn.click();
		WebElement rbtn = driver.findElement(By.xpath("//label[@for='done']"));
		rbtn.click();
	    }

	@When("User Click Add customer and fill the page")
	public void user_Click_Add_customer_and_fill_the_page(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> Addcust = dataTable.asLists(String.class);
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(Addcust.get(1).get(0));
		  driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(Addcust.get(1).get(1));
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Addcust.get(1).get(2));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(Addcust.get(1).get(3));
		  driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(Addcust.get(1).get(4));
		   
	}

	@When("click submit utton")
	public void click_submit_utton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("Navigates to home page")
	public void navigates_to_home_page() {
		String cUrl = driver.getCurrentUrl();
		if(cUrl.contains("telecom"))
		{
			System.out.println("Successfully Navigated in to Home page");
		}else
		System.out.println("Navigates to Someother page");
	   
		
	   
	}


}
