package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionClass {
	WebDriver dr;
	@Given("^open browser$")
	public void open_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		dr = new ChromeDriver();
	}

	@Given("^navigate to facebook url$")
	public void navigate_to_facebook_url() throws Throwable {
	    dr.get("http://www.facebook.com");
	}

	@When("^user types userid on useridBox$")
	public void user_types_userid_on_useridBox() throws Throwable {
		dr.findElement(By.id("email")).sendKeys("Ashequl");
	}

	@When("^user types userpassword in passwordBox$")
	public void user_types_userpassword_in_passwordBox() throws Throwable {
	   dr.findElement(By.id("pass")).sendKeys("1234");
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    dr.findElement(By.xpath("//input[@value='Log In']"));
	}

	@Then("^user should be in his profile page$")
	public void user_should_be_in_his_profile_page() throws Throwable {
		System.out.println("I am on the profile page");
	}
	
	@When("^user types invalid userid on useridBox$")
	public void user_types_invalid_userid_on_useridBox() throws Throwable {
	    
	}

	@When("^user types invalid userpassword in passwordBox$")
	public void user_types_invalid_userpassword_in_passwordBox() throws Throwable {
	   
	}

	@Then("^user should not be in his profile page$")
	public void user_should_not_be_in_his_profile_page() throws Throwable {
	    
	}
	
	@When("^user types \"([^\"]*)\" on useridBox$")
	public void user_types_on_useridBox(String arg1) throws Throwable {
	    dr.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^user types \"([^\"]*)\" in passwordBox$")
	public void user_types_in_passwordBox(String arg1) throws Throwable {
		dr.findElement(By.id("id")).sendKeys(arg1);
	}

}
