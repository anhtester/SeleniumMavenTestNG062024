package com.anhtester.Bai20_Practise_POM_CRM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    public void verifyInvoicesAwaitingPaymentTotal(String total) {
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total not match.");
    }

}