package com.vytrack.tests;

import com.vytrack.pages.CreateVehicleContractPage;
import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleContractsPage;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_09 extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonPage = new CommonAreaPage();

    @Test
    public void AC_01() {
        loginPage.login("salesmanager");

        commonPage.navigateToModule("Fleet", "Vehicle Contracts");

        commonPage.waitUntilLoaderScreenDisappear();

        new VehicleContractsPage().createVehicleContract.click();

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();

        createVehicleContractPage.fillForm();

        createVehicleContractPage.saveAndClose.click();

        String actualText = createVehicleContractPage.successMessage.getText();
        System.out.println("actualText = " + actualText);

        Assertions.assertEquals("Entity saved", actualText);


    }

    @Test
    public void AC_02() {

        loginPage.login("driver");

        commonPage.navigateToModule("Fleet", "Vehicle Contracts");

        String actualText = commonPage.permissionAlert.getText();

        System.out.println("actualText = " + actualText);

        Assertions.assertEquals("You do not have permission to perform this action.", actualText);
    }
}
