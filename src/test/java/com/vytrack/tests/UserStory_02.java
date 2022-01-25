package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.CreateVehiclePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_02 extends TestBase {

    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();

    @Test
    public void AC_01() {
        loginPage.login("salesmanager");

        commonAreaPage.navigateToModule("Fleet", "Vehicles");

        BrowserUtil.waitFor(4);

        new VehiclesPage().createCar.click();

        CreateVehiclePage createVehiclePage = new CreateVehiclePage();

        createVehiclePage.fillForm();

        createVehiclePage.saveAndClose.click();

        String actualText = createVehiclePage.successMessage.getText();

        String expectedText = "Entity saved";

        Assertions.assertEquals(expectedText, actualText);


    }


    @Test
    public void AC_02() {


        loginPage.login("driver");

        commonAreaPage.navigateToModule("Fleet", "Vehicles");

        boolean result = BrowserUtil.waitForElementIsNotLocated(new VehiclesPage().createCar);

        Assertions.assertFalse(result);



    }




}
