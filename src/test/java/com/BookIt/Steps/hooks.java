package com.BookIt.Steps;

import com.BookIt.Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.After;   // doesnt connect stepdefinitions
//import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class hooks {
//    public static WebDriver driver;
    @Before
    public void before(){
//        driver=Driver.get();
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
//        if(driver!=null){Driver.close();driver=null;}
        Driver.close();
    }

}
