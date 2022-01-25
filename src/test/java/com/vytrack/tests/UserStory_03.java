package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_03 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage=new CommonAreaPage();

    @Test
    public void AC_01() {

        loginPage.login("storemanager");

        commonAreaPage.navigateToModule("Fleet","Vehicles");

        VehiclesPage vehiclesPage=new VehiclesPage();

        BrowserUtil.waitFor(4);

        vehiclesPage.selectAllCheckboxes.click();

        Assertions.assertTrue(BrowserUtil.getIsCheck(vehiclesPage.allCheckboxes,vehiclesPage.nextButton));


    }

    @Test
    public void AC_02() {

        loginPage.login("salesmanager");

        commonAreaPage.navigateToModule("Fleet","Vehicles");

        VehiclesPage vehiclesPage=new VehiclesPage();

        BrowserUtil.waitFor(4);

        int i = BrowserUtil.randomNumber(0, 10);

        vehiclesPage.allCheckboxes.get(i).click();

        Assertions.assertTrue(vehiclesPage.allCheckboxes.get(i).isSelected());



    }






}
