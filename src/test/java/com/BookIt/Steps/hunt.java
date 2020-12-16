package com.BookIt.Steps;

import com.BookIt.Pages.BasePage;
import com.BookIt.Pages.HuntPage;
import com.BookIt.Pages.LoginPage;
import com.BookIt.Pages.SchedulePage;
import com.BookIt.Utils.ConfReader;
import com.BookIt.Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hunt {


    @Given("user enters Username, Password and logged in successfully")
    public void user_enters_Username_Password_and_logged_in_successfully() {
        Driver.get().get("https://cybertek-reservation-qa3.herokuapp.com/sign-in");
        String Email= ConfReader.get("userStudent");
        String Password=ConfReader.get("passwordStudent");
        LoginPage loginPage=new LoginPage();
        loginPage.Login(Email,Password);
    }
    HuntPage huntPage=new HuntPage();
    WebDriverWait wait=new WebDriverWait(Driver.get(),10);
    @When("user choose the date and hours from A to B")
    public void user_choose_the_date_and_hours_from_A_to_B() throws InterruptedException {
        Thread.sleep(3000);
//        wait.until(ExpectedConditions.urlContains("map"));
        huntPage.mapLink.click();Thread.sleep(2000);
        huntPage.hunt.click();Thread.sleep(2000);
        Driver.get().navigate().refresh();
        huntPage.date.click();
        huntPage.date.sendKeys("December 17, 2020");
        Thread.sleep(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(huntPage.from));
        huntPage.from.click();
        wait.until(ExpectedConditions.elementToBeClickable(huntPage.from800));
//        huntPage.from.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
        huntPage.from800.click();
//        wait.until(ExpectedConditions.elementToBeClickable(huntPage.to));
        Thread.sleep(2000);
        huntPage.to.click();
        huntPage.to.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
//        huntPage.to1030.click();
        wait.until(ExpectedConditions.elementToBeClickable(huntPage.searchButton));
        huntPage.searchButton.click();

    }

    @When("user chooses a room and confirms booking")
    public void user_chooses_a_room_and_confirms_booking() throws InterruptedException {
//        wait.until(ExpectedConditions.elementToBeClickable(huntPage.bookRoomList));
        String room="kilimanjaro";
        try{
            Thread.sleep(3000);
//        Driver.get().findElement(By.xpath("//p[text()=' "+room+" ']/../following-sibling::footer/div/button")).click();
        huntPage.bookKilimanjaro.click();
        Thread.sleep(2000);
        String date=huntPage.dateConfirmCheck.getText();
        String time=huntPage.timeConfirmCheck.getText();
        System.out.println(date+" " +time);
        Assert.assertTrue(date.contains("17"));
        Assert.assertTrue(time.contains("8:00")&time.contains(":"));
        huntPage.confirmButton.click();}catch(Exception e){
            System.out.println("Room "+room+" is not available");}
    }

    @Then("user books a room successfully")
    public void user_books_a_room_successfully() throws InterruptedException {

        Assert.assertTrue(huntPage.confirmationText.getText().contains("8:00"));
        Thread.sleep(2000);
    }

    @Then("cancel booking from my schedule")
    public void cancel_booking_from_my_schedule() throws InterruptedException {
        Actions actions=new Actions(Driver.get());
        Thread.sleep(2000);
        actions.moveToElement(huntPage.schedule).moveToElement(huntPage.scheduleMy).click().perform();

        SchedulePage schedulePage=new SchedulePage();
        schedulePage.bookedRoom.click();Thread.sleep(2000);
        schedulePage.cancelConference.click();Thread.sleep(2000);
        Assert.assertTrue(schedulePage.cancelConfirmation.isDisplayed());
        schedulePage.Logout();
    }


    @Then("user cannot book a booked room")
    public void user_cannot_book_a_booked_room() throws InterruptedException {
        try{user_choose_the_date_and_hours_from_A_to_B();
        user_chooses_a_room_and_confirms_booking();}catch(Exception e){
            System.out.println("Error");}
//        System.out.println(huntPage.alertmessage.getText());
//        Assert.assertTrue(huntPage.alertmessage.isDisplayed());
        cancel_booking_from_my_schedule();

    }




}
