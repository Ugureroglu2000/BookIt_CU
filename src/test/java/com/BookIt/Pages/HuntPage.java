package com.BookIt.Pages;

import com.BookIt.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HuntPage extends BasePage {

    public HuntPage(){        PageFactory.initElements(Driver.get(),this);    }

    @FindBy(id = "mat-input-0")
    public WebElement date;

    @FindBy(id = "mat-select-0")
    public WebElement from;

    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'7:30')]")
    public WebElement from730;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'8:00am')]")
    public WebElement from800;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'8:30')]")
    public WebElement from830;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'9:30')]")
    public WebElement from930;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'9:00')]")
    public WebElement from900;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'10:00')]")
    public WebElement from1000;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'10:30')]")
    public WebElement from1030;

    @FindBy(id = "mat-select-1")
    public WebElement to;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'9:30')]")
    public  WebElement to930;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'10:00')]")
    public  WebElement to1000;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'10:30')]")
    public  WebElement to1030;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'11:00')]")
    public  WebElement to1100;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//p[text()=' kilimanjaro ']/../following-sibling::footer/div/button")
    public WebElement bookKilimanjaro;

    @FindBy(xpath = "(//time[@datetime='2016-1-1'])[1]")
    public WebElement dateConfirmCheck;
    @FindBy(xpath = "(//time[@datetime='2016-1-1'])[2]")
    public WebElement timeConfirmCheck;
    @FindBy(xpath = "//button[text()='confirm']")
    public  WebElement confirmButton;
    @FindBy(xpath = "(//p[@class='has-text-grey']/b)[2]")
    public  WebElement confirmationText;
    @FindBy(xpath = "//*[text()='there are no spots for a selected date and time']")
    public WebElement alertmessage;


}
