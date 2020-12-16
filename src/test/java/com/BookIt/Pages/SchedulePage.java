package com.BookIt.Pages;

import com.BookIt.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends BasePage {
    public SchedulePage(){        PageFactory.initElements(Driver.get(),this);    }

    @FindBy(xpath = "//td[contains(@class,'conference')]")
    public WebElement bookedRoom;

    @FindBy(xpath = "//button[text()='cancel conference']")
    public WebElement cancelConference;

    @FindBy(xpath = "//*[contains(text(),'been canceled')]")
    public WebElement cancelConfirmation;
}
