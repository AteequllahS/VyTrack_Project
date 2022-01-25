package com.vytrack.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class is meant to be super class
 * to provide driver set up and closing browser
 * for it's subclasses
 *
 * // Now you can try to replace driver with
 * Driver.getDriver() so it can be same driver everywhere wherever you use
 *
 */
public abstract class TestBase {
    protected WebDriver driver;


    @BeforeEach
    public void setupWebDriver(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfigReader.read("url"));
    }

    @AfterEach
    public void closeBrowser(){


        Driver.closeBrowser();
    }


}
