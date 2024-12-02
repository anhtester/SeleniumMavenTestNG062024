package com.anhtester.Bai20_21_Practise_POM_CRM.testcases;

import com.anhtester.Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import com.anhtester.Bai20_21_Practise_POM_CRM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckDashboardTotal(){
        loginPage = new LoginPage(driver);

        //loginPage.loginCRM();

        //dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
    }

}