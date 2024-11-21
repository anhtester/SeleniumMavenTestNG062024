package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]"))
    private List<WebElement> listElement;
    // Hoặc
//    @FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]")
//    private List<WebElement> listElement;

    public void getListMenu() {
        System.out.println("Menu Total: " + listElement.size());
        for (int i = 0; i < listElement.size(); i++) {
            System.out.println(listElement.get(i).getText());
        }
    }

    public void verifyInvoicesAwaitingPaymentTotal(String total) {
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total not match.");
    }

}