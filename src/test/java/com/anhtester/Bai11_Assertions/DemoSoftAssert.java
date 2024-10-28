package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import com.anhtester.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {

    @Test
    public void testLoginSuccess() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), "Header login page not display.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(), "Login123", "Giá trị header không đúng.");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        softAssert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not display.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).getText(), "Dashboard123", "Giá trị menu dashboard không đúng.");

        softAssert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Invoices Awaiting Payment']")).getText().contains("Invoices Awaiting123"), "The content of label not match.");

        softAssert.assertAll();
    }

}
