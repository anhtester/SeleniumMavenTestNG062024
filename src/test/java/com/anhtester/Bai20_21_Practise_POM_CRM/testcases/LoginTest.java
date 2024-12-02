package com.anhtester.Bai20_21_Practise_POM_CRM.testcases;

import com.anhtester.Bai20_21_Practise_POM_CRM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 3)
    public void loginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail("Invalid email or password"); //Invalid email or password
    }

    @Test(priority = 4)
    public void loginFailWithEmailNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

    @Test(priority = 5)
    public void loginFailWithPasswordNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }

    @Test(priority = 6)
    public void loginFailWithEmailNullAndPasswordNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "");
        //loginPage.verifyLoginFailWithNullFields();
        loginPage.verifyLoginFailWithNullFields_ArrayList(2);
    }

}
