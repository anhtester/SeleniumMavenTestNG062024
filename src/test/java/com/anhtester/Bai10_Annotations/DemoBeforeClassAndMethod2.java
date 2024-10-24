package com.anhtester.Bai10_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBeforeClassAndMethod2 extends SetupClass{

    @Test
    public void testLoginCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
    }

}