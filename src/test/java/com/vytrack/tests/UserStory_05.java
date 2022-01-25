package com.vytrack.tests;

import com.vytrack.pages.AccountsPage;
import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_05 extends TestBase {

    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonPage = new CommonAreaPage();
    AccountsPage accountsPage = new AccountsPage();

    @Test
    public void AC_01() {

        loginPage.login("storemanager");

        commonPage.navigateToModule("Customers", "Accounts");

        commonPage.waitUntilLoaderScreenDisappear();

        accountsPage.selectAllCheckboxes.click();

        Assertions.assertTrue(BrowserUtil.getIsCheck(accountsPage.allCheckboxes,accountsPage.nextButton));

    }

    @Test
    public void AC_02() {

        loginPage.login("storemanager");

        commonPage.navigateToModule("Customers", "Accounts");

        commonPage.waitUntilLoaderScreenDisappear();

        accountsPage.allCheckboxes.get(1).click();

        Assertions.assertTrue(accountsPage.allCheckboxes.get(1).isSelected());

    }
}
