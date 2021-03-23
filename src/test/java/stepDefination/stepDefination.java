package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class stepDefination {
	
	WebDriver driver;
	
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "D:/Vinay/Fulcrum/selenium-java-3.141.59/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@When("^User navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {

		driver.get(arg1);
		driver.manage().window().maximize();
		
	    
	}

	@And("^Click on SignIn button$")
	public void click_on_SignIn_button() throws Throwable {

		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
	   
	}

	@And("^user enters (.+) and (.+) and Log In$")
	public void user_enters_and_and_Log_In(String arg1, String arg2) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(arg1);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(arg2);
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		
	   
	}


	@SuppressWarnings("deprecation")
	@Then("^Verify, user is successfully Logged In$")
	public void verify_user_is_successfully_Logged_In() throws Throwable {

		String bodyText = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
		System.out.println(bodyText);
		Assert.assertEquals("Hello, Vinay", bodyText);
		
	   
	}
	
	@And("^Close all browsers$")
    public void close_all_browsers() throws Throwable {
        driver.quit();
    }

}
