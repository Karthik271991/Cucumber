package org.tcs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Guru9 {
	public static WebDriver driver;
	@Given("The user is in fb login page")
	public void the_user_is_in_fb_login_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/telecom/index.html");
	   	}

	@When("The user click the Add customer and click button")
	public void the_user_click_the_Add_customer_and_click_button() {
		WebElement cl = driver.findElement(By.xpath("//a[text()='Add Customer'][1]"));
		cl.click();
		WebElement dne = driver.findElement(By.xpath("//label[@for='done']"));
		dne.click();
	   }

	@When("user enter details {string},{string},{string},{string}{string}")
	public void user_enter_details(String Fnme, String lstn, String emil, String addr, String mob) {
	  WebElement fn = driver.findElement(By.xpath("//input[@id='fname']"));
		fn.sendKeys(Fnme);
		WebElement lnme = driver.findElement(By.xpath("//input[@id='lname']"));
		lnme.sendKeys(lstn);
		WebElement eml = driver.findElement(By.xpath("//input[@id='email']"));
		eml.sendKeys(emil);
		WebElement adr = driver.findElement(By.xpath("//textarea[@id='message']"));
		adr.sendKeys(addr);
		WebElement mobno = driver.findElement(By.xpath("//input[@id='telephoneno']"));
		mobno.sendKeys(mob);
		WebElement submt = driver.findElement(By.xpath("//input[@type='submit']"));
		submt.click();
		
	}

	@Then("User navigates into after submit page")
	public void user_navigates_into_after_submit_page() {
		driver.getCurrentUrl();
		if(driver.getCurrentUrl().contains("telecom"))
		{
			System.out.println("successfully navigates");
		}
		else
	   
	System.out.println("Invalid ");
	}

}
