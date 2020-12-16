package com.BookIt.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){}
//    private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driver=new InheritableThreadLocal<>();
    public static WebDriver get(){
        if(driver.get()==null){String d=ConfReader.get("browser");
        switch (d){
            case "chrome" :  WebDriverManager.chromedriver().setup();
//                            driver=new ChromeDriver();
                              driver.set(new ChromeDriver()); break;
            case "chromeHeadless":WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));break;
            case "firefox": WebDriverManager.firefoxdriver().setup();
                            driver.set(new FirefoxDriver());break;
//                            driver=new FirefoxDriver(); break;
            case "edge" :   WebDriverManager.edgedriver().setup();
                            driver.set(new EdgeDriver());
//                            driver=new EdgeDriver();  break;
            }
        }
        return driver.get();
    }

    public static void close(){
//        if(driver!=null){driver.get().quit(); driver=null;}   //single
        driver.get().quit(); driver.remove();           //parallel
    }

}
