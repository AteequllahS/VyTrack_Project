package com.vytrack.tests;

import com.vytrack.pages.*;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_08 extends TestBase {
    LoginPage loginPage=new LoginPage();
    CommonAreaPage commonPage=new CommonAreaPage();
    @Test
    public void AC_01() {

        loginPage.login("driver");

        commonPage.navigateToModule("Fleet", "Vehicle Odometer");

        BrowserUtil.waitFor(4);
        new VehicleOdometerPage().createVehicleOdometer.click();

        CreateOdometerPage createOdometerPage=new CreateOdometerPage();

        createOdometerPage.fillForm();


        BrowserUtil.scrollToElement(createOdometerPage.saveAndClose);

        createOdometerPage.saveAndClose.click();

        String actualText = createOdometerPage.successMessage.getText();

        System.out.println("actualText = " + actualText);

        Assertions.assertEquals("Entity saved", actualText);



    }



    @Test
    public void AC_02() {


        loginPage.login("salesmanager");

        commonPage.navigateToModule("Fleet", "Vehicle Odometer");

        String actualText = commonPage.permissionAlert.getText();

        System.out.println("actualText = " + actualText);

        Assertions.assertEquals("You do not have permission to perform this action.",actualText);


    }
}
