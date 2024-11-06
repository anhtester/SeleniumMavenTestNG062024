package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void demoExplicitWait01() throws InterruptedException {
        driver.get("https://hrm.anhtester.com/");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("iusername123")));

        driver.findElement(By.id("iusername")).sendKeys("admin_example");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ipassword")));

        driver.findElement(By.id("ipassword")).sendKeys("123456");

        wait1.until(ExpectedConditions.elementToBeClickable(By.id("iusername")));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
