package com.BookIt.Pages;

import com.BookIt.Utils.ConfReader;
import com.BookIt.Utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){        PageFactory.initElements(Driver.get(),this);    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    public  void Login(String Email,String Password){
        email.sendKeys(Email);
        password.sendKeys(Password, Keys.ENTER);
    }
//    public  void LoginTeamLead(){
//        String Email= ConfReader.get("userTeamLeader");
//        String Password=ConfReader.get("passwordTeamLeader");
//        email.sendKeys(Email);
//        password.sendKeys(Password, Keys.ENTER);
//    }
//    public  void LoginTeacher(){
//        String Email= ConfReader.get("userTeacher");
//        String Password=ConfReader.get("passwordTeacher");
//        email.sendKeys(Email);
//        password.sendKeys(Password, Keys.ENTER);
//    }

}
