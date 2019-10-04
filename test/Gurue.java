package org.tcs.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Gurue {
	public static WebDriver driver;
	@Given("User launch the browser and Enter URL")
	public void user_launch_the_browser_and_Enter_URL() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/telecom/index.html");
		
	   }

	@When("User click the Add customer button")
	public void user_click_the_Add_customer_button() {
		WebElement btn = driver.findElement(By.xpath("//a[text()='Add Customer']"));
	btn.click();
	WebElement rbtn = driver.findElement(By.xpath("//label[@for='done']"));
	rbtn.click();
	}

	@When("User Goes to next page and Fill the webpage")
	public void user_Goes_to_next_page_and_Fill_the_webpage(io.cucumber.datatable.DataTable dataTable) {
	  List<String> Addcust= dataTable.asList(String.class);
	  driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(Addcust.get(0));
	  driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(Addcust.get(1));
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Addcust.get(2));
	  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(Addcust.get(3));
	  driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(Addcust.get(4));
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("User navigates into Homepage")
	public void user_navigates_into_Homepage() {
		String cUrl = driver.getCurrentUrl();
		if(cUrl.contains("telecom"))
		{
			System.out.println("Successfully Navigated in to Home page");
		}else
		System.out.println("Navigates to Someother page");
	   }


}
