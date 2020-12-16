package com.BookIt.Pages;

import com.BookIt.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BasePage {
    BasePage(){       PageFactory.initElements(Driver.get(),this);    }

    @FindBy(xpath = "//a[text()='map']")
    public WebElement mapLink;
    @FindBy(xpath = "//a[text()='schedule']")
    public  WebElement schedule;
    @FindBy(xpath = "(//a[text()='my'])[1]")
    public WebElement scheduleMy;
    @FindBy(xpath = "//a[text()='general']")
    public WebElement scheduleGeneral;
    @FindBy(xpath = "//a[text()='hunt']")
    public WebElement hunt;
    @FindBy(xpath = "(//a[text()='my'])[2]")
    public WebElement myLink;
    @FindBy(xpath = "//a[text()='self']")
    public WebElement mySelf;
    @FindBy(xpath = "//a[text()='team']")
    public WebElement myTeam;
    @FindBy(xpath = "//a[text()='sign out']")
    public WebElement mySignout;

    public void Logout(){
        Actions hover=new Actions(Driver.get());
        hover.moveToElement(myLink).moveToElement(mySignout).click().perform();
    }
//@Test
//    public void t(){
//    System.out.println(Math.sqrt(25));
//
//}

}
