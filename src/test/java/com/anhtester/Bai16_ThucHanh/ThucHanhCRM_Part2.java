package com.anhtester.Bai16_ThucHanh;

import com.anhtester.common.BaseTest;
import com.anhtester.common.LocatorsCRM;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThucHanhCRM_Part2 extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {
        String CUSTOMER_NAME = "Viettel VTCC07";
        new WebUI(driver); //Khởi tạo class WebUI để truyền driver vào

        driver.get("https://crm.anhtester.com/admin/authentication");
        System.out.println("Open website: https://crm.anhtester.com/admin/authentication");

        WebUI.clearText(By.xpath(LocatorsCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorsCRM.inputPassword));

//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();

        WebUI.setText(By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(By.xpath(LocatorsCRM.inputPassword), "123456");

//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonLogin));
//        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));
//        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();

        System.out.println(WebUI.getElementText(By.xpath(LocatorsCRM.headerCustomerPage)));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText());

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonAddNewCustomer));
//        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomer)).click();
//        Thread.sleep(2000);

        WebUI.setText(By.xpath(LocatorsCRM.inputCompany), CUSTOMER_NAME);

        WebUI.setText(By.xpath(LocatorsCRM.inputVat), "10");
        WebUI.setText(By.xpath(LocatorsCRM.inputPhoneNumber), "0123456789");
        WebUI.setText(By.xpath(LocatorsCRM.inputWebsite), "https://viettel.com.vn/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[normalize-space()='Groups']")));

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));

        Thread.sleep(1000);
        WebUI.setText(By.xpath(LocatorsCRM.inputSearchGroup), "VIP");

        Thread.sleep(1000);
        WebUI.clickElement(By.xpath(LocatorsCRM.itemVIP));
        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownLanguage));
        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamese));
        WebUI.setText(By.xpath(LocatorsCRM.inputAddress), "Ha Noi");
        WebUI.setText(By.xpath(LocatorsCRM.inputCity), "Ha Noi");
        WebUI.setText(By.xpath(LocatorsCRM.inputState), "Hoan Kiem");
        WebUI.setText(By.xpath(LocatorsCRM.inputZipCode), "123456");
        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownCountry));
        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCountry), "Vietnam");
        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamCountry));
        WebUI.clickElement(By.xpath(LocatorsCRM.buttonSave));

        //Search and check first item
        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));
        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCustomer), CUSTOMER_NAME);
        Thread.sleep(2000);
        WebUI.waitForElementVisible(By.xpath(LocatorsCRM.itemCustomerFirst));
        Assert.assertEquals(WebUI.getElementText(By.xpath(LocatorsCRM.itemCustomerFirst)), CUSTOMER_NAME);
        WebUI.clickElement(By.xpath(LocatorsCRM.itemCustomerFirst));

        //Verify data in customer detail
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"), CUSTOMER_NAME, "The Company name not match.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputVat)).getAttribute("value"), "10", "The VAT value not match.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).getAttribute("value"), "0123456789", "The Phone number value not match.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"), "https://viettel.com.vn/", "The Website value not match.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).getAttribute("title"), "VIP", "The Group value not match.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getAttribute("title"), "Vietnamese", "The Language value not match.");

//        System.out.println("Company Detail: " + driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputVat)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).getAttribute("title"));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getAttribute("title"));

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)

    }
}
