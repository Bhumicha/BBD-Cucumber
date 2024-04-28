package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;

    @Given("^user opens the browser and hit url (.*)$")
    public void opensBrowser(String urlValue){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(urlValue);
    }

    @When("^user enters username as (.*) and password as (.*)$")
    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("^user clicks on login button$")
    public void clickOnButton(){
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }
    @And("^user lands on Dashboard page$")
    public void verifyDashboardPage(){
        String actualValue=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals(actualValue,"Dashboard");
    }
    @And("^user verifies error message as (.*)$")
    public void verifyErrorMessage(String errorMessageExpected){
        boolean isVisible=driver.findElement(By.xpath("//*[text()='"+errorMessageExpected+"']")).isDisplayed();
        Assert.assertTrue(isVisible);
    }


    @After
    public void quit(){
        driver.quit();
    }
}
