package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginsteps extends BaseTest {
	
	public LoginPage lp;
	public HomePage hp;
	public LeadPage ldp;
	public String TCName;
	public Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
		if(extent==null)
		{
			createExtentReport();
		}
		
	    this.scenario = scenario;
	    TCName = scenario.getName();
	    Logger = extent.createTest(TCName);
	}
	
	@After
	public void after(Scenario scenario) {
		 extent.flush();
		 driver.quit();
	}
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		Intiation();
	}

	
	
	
	
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	   driver.findElement(By.linkText("Logout")).isDisplayed();
	}

	@Then("user can see logout link is appear on top right corner")
	public void user_can_see_logout_link_is_appear_on_top_right_corner() {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@When("user enters valid userid and password and click on login button")
	public void user_enters_valid_userid_and_password_and_click_on_login_button() {
	   lp = new LoginPage(driver,Logger);
	   lp.login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"));
	}
	
	@When("user click on new lead link link")
	public void user_click_on_new_lead_link_link() {
	    ldp = new LeadPage(driver,Logger);
	    ldp.clickNewLead();
	    
	}
	@When("fill all mandatory fields")
	public void fill_all_mandatory_fields() {
		ldp.createLeadwithMandatoryFields(dt.get(TCName).get("Lname"), dt.get(TCName).get("Company"));
	}
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
	   
	}
	
	@When("user enters invalid userid and password and click on login button")
	public void user_enters_invalid_userid_and_password_and_click_on_login_button() {
		lp = new LoginPage(driver,Logger);
		   lp.login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"));
	}
	@Then("user can see error message above the login block")
	public void user_can_see_error_message_above_the_login_block() {
	    
	}


}
