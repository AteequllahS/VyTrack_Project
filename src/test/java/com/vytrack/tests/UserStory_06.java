package com.vytrack.tests;

import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_06 extends TestBase {

    CommonAreaPage commonPage=new CommonAreaPage();

    @Test
    public void AC_01() {

        new LoginPage().login("storemanager");

        commonPage.waitUntilLoaderScreenDisappear();

        commonPage.userName.click();

        //Assertions.assertEquals("My User",commonPage.myUser.getText());
        Assertions.assertEquals("My Configuration",commonPage.myConf.getText());
        Assertions.assertEquals("My Calendar",commonPage.myCalendar.getText());

    }
}
