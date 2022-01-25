package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class UserStory_10 extends TestBase {
    @Test
    public void AC_01() {

            new LoginPage().login("driver");

            new CommonAreaPage().getHelp.click();

            BrowserUtil.switchToWindow("Welcome to Oro Documentation");

            System.out.println("driver.getTitle() = " + driver.getTitle());

            Assertions.assertEquals("Welcome to Oro Documentation", driver.getTitle());

        }
    }

