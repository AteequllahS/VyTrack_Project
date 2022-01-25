package com.vytrack.tests;

import com.vytrack.pages.*;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_07 extends TestBase {
    CommonAreaPage commonPage=new CommonAreaPage();
    @Test
    public void AC_01() {
        new LoginPage().login("storemanager");

        commonPage.navigateToModule("Fleet", "Vehicle Costs");

        commonPage.waitUntilLoaderScreenDisappear();

        new VehicleCostsPage().createVehicleCosts.click();

        CreateVehicleCosts createVehicleCosts=new CreateVehicleCosts();

        createVehicleCosts.fillForm();

        createVehicleCosts.saveAndClose.click();

        String actualText = createVehicleCosts.successMessage.getText();

        Assertions.assertEquals("Entity saved", actualText);

    }
}
