package com.BookIt.Steps;

import com.BookIt.Pages.HuntPage;
import com.BookIt.Pages.LoginPage;
import com.BookIt.Utils.ConfReader;
import com.BookIt.Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class hun {

    @Given("user enters {string}, {string} and logged in successfully")
    public void user_enters_and_logged_in_successfully(String email, String pass) {
        Driver.get().get("https://cybertek-reservation-qa3.herokuapp.com/sign-in");
        String Email= ConfReader.get(email);
        String Password=ConfReader.get(pass);
        LoginPage loginPage=new LoginPage();
        loginPage.Login(Email,Password);
    }
    HuntPage huntPage=new HuntPage();
    @When("user chooses a {string} and confirms booking")
    public void user_chooses_a_and_confirms_booking(String rom) {
        String room=ConfReader.get(rom);
        try{
            Thread.sleep(3000);
        Driver.get().findElement(By.xpath("//p[text()=' "+room+" ']/../following-sibling::footer/div/button")).click();
//            huntPage.bookKilimanjaro.click();
            Thread.sleep(2000);
            String date=huntPage.dateConfirmCheck.getText();
            String time=huntPage.timeConfirmCheck.getText();
            System.out.println(date+" " +time);
            Assert.assertTrue(date.contains("17"));
            Assert.assertTrue(time.contains("8:00")&time.contains(":"));
            huntPage.confirmButton.click();}catch(Exception e){
            System.out.println("Room "+room+" is not available");}
    }
}
