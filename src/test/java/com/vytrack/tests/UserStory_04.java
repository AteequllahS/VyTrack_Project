package com.vytrack.tests;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.CreateContactPage;
import com.vytrack.pages.CommonAreaPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utility.BrowserUtil;
import com.vytrack.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class UserStory_04 extends TestBase {

    CommonAreaPage commonPage=new CommonAreaPage();


    @Test
    public void AC_01() {

        new LoginPage().login("salesmanager");

        commonPage.navigateToModule("Customers", "Contacts");

        BrowserUtil.waitFor(4);
        new ContactsPage().createContact.click();

        CreateContactPage createContactPage=new CreateContactPage();

        createContactPage.fillForm();

        BrowserUtil.scrollToElement(createContactPage.saveAndClose);

        createContactPage.saveAndClose.click();

        String text =BrowserUtil.waitForVisibility(By.cssSelector(".message"),10).getText();

        System.out.println(text);

        Assertions.assertEquals("Contact saved", text);
    }


}
