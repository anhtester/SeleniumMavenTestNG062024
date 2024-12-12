package com.anhtester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(String browser) {

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                System.out.println("Khởi chạy trình duyệt Chrome...");
                break;
            case "edge":
                driver = new EdgeDriver();
                System.out.println("Khởi chạy trình duyệt Edge...");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                System.out.println("Khởi chạy trình duyệt Firefox...");
                break;
            case "safari":
                driver = new SafariDriver();
                System.out.println("Khởi chạy trình duyệt Safari...");
                break;
            default:
                driver = new ChromeDriver();
                System.out.println("Khởi chạy trình duyệt Chrome mặc định...");
                break;
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
