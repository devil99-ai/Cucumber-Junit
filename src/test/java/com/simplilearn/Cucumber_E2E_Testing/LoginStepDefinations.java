package com.simplilearn.Cucumber_E2E_Testing;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinations {
	WebDriver driver = Hooks.driver;
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
        driver.get("https://bstackdemo.com/");
	}

	@When("User Navigate to LogIn Page")
	public void user_Navigate_to_LogIn_Page() {
		driver.navigate().to("https://bstackdemo.com/signin");
	}

	@And("User enters UserName and Password")
	public void user_enters_UserName_and_Password() {
		driver.findElement(By.xpath("//*[@id=\"username\"]/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"react-select-2-option-0-0\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"react-select-3-option-0-0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
	}

	@Then("Message displayed DASHBOARD")
	public void message_displayed_DASHBOARD() {
		String actual=	driver.getTitle();
	    Assert.assertEquals("StackDemo", actual);
	    System.out.println("login successfull");
	}
	@When("user selects iphone12mini")
	public void user_selects_iphone12mini() {
		driver.get("https://bstackdemo.com/");
	    String mobileName = driver.findElement(By.xpath("//*[@id=\"2\"]/p")).getText();
	    Assert.assertEquals("iPhone 12 Mini",mobileName);
	}

	@And("clicks on Add To Cart")
	public void clicks_on_Add_To_Cart() {
	    driver.findElement(By.xpath("//*[@id=\"2\"]/div[4]")).click();
	}

	@Then("user go for checkout and fill details")
	public void user_go_for_checkout_and_fill_details() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"firstNameInput\"]")).sendKeys("Souvik");
	    driver.findElement(By.xpath("//*[@id=\"lastNameInput\"]")).sendKeys("Sharma");
	    driver.findElement(By.xpath("//*[@id=\"addressLine1Input\"]")).sendKeys("A.C.Road");
	    driver.findElement(By.xpath("//*[@id=\"provinceInput\"]")).sendKeys("West Bengal");
	    driver.findElement(By.xpath("//*[@id=\"postCodeInput\"]")).sendKeys("742103");
	    
	    
	}

	@And("submit the order")
	public void submit_the_order() {
		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-continue\"]")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"confirmation-message\"]")).getText(), "Your Order has been successfully placed.");
	}
	@Then("user click on logout and navigates back to the home page")
	public void user_click_on_logout_and_navigates_back_to_the_home_page() {
	    driver.navigate().to("https://bstackdemo.com/");
	    driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
	}

	

}

