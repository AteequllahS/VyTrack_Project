package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleModelPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_11 extends TestBase {

    @Test
    public void AC_01() {

        new LoginPage().login("driver");

        new CommonAreaPage().navigateToModule("Fleet", "Vehicles Model");

        VehicleModelPage vehicleModelPage=new VehicleModelPage();

        boolean actualResult = BrowserUtil.elementIsDisplayed(vehicleModelPage.allVehicles);

        System.out.println("actualResult = " + actualResult);

        Assertions.assertTrue(actualResult);


    }
}
