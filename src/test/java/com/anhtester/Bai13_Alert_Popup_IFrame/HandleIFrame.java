package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {
    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);

        //Chuyển hướng đến iframe thông qua chính element thẻ iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

        Thread.sleep(1000);
        //Chuyển hướng về nội dung chính không thuộc thẻ iframe nào
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText());


        Thread.sleep(1000);
    }
}
