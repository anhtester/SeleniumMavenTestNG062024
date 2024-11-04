package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {

    @Test
    public void jsExecutorDemo00() throws InterruptedException {
        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://cms.anhtester.com/");
        Thread.sleep(1000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement menuBlog = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        js.executeScript("arguments[0].click();", menuBlog);
        //menuBlog.click();
        Thread.sleep(1000);

    }

    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        // sendKeys text on input
        js.executeScript("document.getElementById('email').setAttribute('value','admin@example.com');");
        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
        Thread.sleep(2000);

    }

    @Test
    public void jsExecutorDemo03() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement webElement = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        //Scroll to element
        //Giá trị true là nằm phía trên
        //Giá trị false là nằm phía dưới
        js.executeScript("arguments[0].scrollIntoView(false);", webElement);

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo04() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
        inputEmail.sendKeys("admin@example.com");
        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputPassword);
        inputPassword.sendKeys("123456");
        Thread.sleep(1000);
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].style.border='3px solid red'", buttonLogin);
        inputEmail.click();

        Thread.sleep(2000);
    }
}
