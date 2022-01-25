package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory_01 extends TestBase {

    LoginPage loginPage=new LoginPage();

    @Test
    public void AC_01() {

        loginPage.login("salesmanager");

        List<String> actualModules = BrowserUtil.getElementsText(new CommonAreaPage().allModules);

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));

        Assertions.assertEquals(expectedModules, actualModules);

    }

    @Test
    public void AC_011() {
        loginPage.login("storemanager");

        List<String> actualModules = BrowserUtil.getElementsText(new CommonAreaPage().allModules);

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));

        Assertions.assertEquals(expectedModules, actualModules);

    }


    @Test
    public void AC_02() {
        new LoginPage().login("driver");

        new CommonAreaPage().waitUntilLoaderScreenDisappear();

        List<String> actualModules = BrowserUtil.getElementsText(new CommonAreaPage().allModules);

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));

        Assertions.assertEquals(expectedModules, actualModules);

    }


}
