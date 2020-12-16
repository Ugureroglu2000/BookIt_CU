package com.BookIt.Steps;

import com.BookIt.Pages.LoginPage;
import com.BookIt.Utils.ConfReader;
import com.BookIt.Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
//    WebDriver driver;
    @Given("user is in loginPage")
    public void user_is_in_loginPage() {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();        // doesnt work since in page object classes we use driver in constructor to initelements
//        driver.get("https://cybertek-reservation-qa3.herokuapp.com/sign-in");
        Driver.get().get("https://cybertek-reservation-qa3.herokuapp.com/sign-in");

    }

// single positive login
    @When("User enters Username and Password")
    public void user_enters_Username_and_Password() {
        String Email= ConfReader.get("userStudent");
        String Password=ConfReader.get("passwordStudent");
        LoginPage loginPage=new LoginPage();
        loginPage.Login(Email,Password);

    }
// multiple positive login
    @When("users enters {string} and {string}")
    public void users_enters_and(String str1, String str2) {
        String Email= ConfReader.get(str1);
        String Password=ConfReader.get(str2);
        LoginPage loginPage=new LoginPage();
        loginPage.Login(Email,Password);
    }
// multiple negative log in
    @When("User enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.Login(email,password);
    }


    @Then("User can Login successfully")
    public void user_can_Login_successfully() throws InterruptedException {
//          Thread.sleep(5000);
        WebDriverWait wait=new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.urlContains("/map"));
        Assert.assertTrue("doesnt verify sign in",Driver.get().getCurrentUrl().contains("https://cybertek-reservation-qa3.herokuapp.com/map"));
//        driver.quit();
    }



    @Then("User can not Login")
    public void user_can_not_Login() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertFalse("Sign in",Driver.get().getCurrentUrl().contains("https://cybertek-reservation-qa3.herokuapp.com/map"));
    }

}
