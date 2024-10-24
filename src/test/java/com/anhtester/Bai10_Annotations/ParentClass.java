package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class ParentClass {
    @BeforeSuite
    public void beforeSuiteParent() {
        System.out.println("Before Suite PARENT");
    }

    @AfterSuite
    public void afterSuiteParent() {
        System.out.println("After Suite PARENT");
    }

    @BeforeTest
    public void beforeTestParent() {
        System.out.println("Before Test PARENT");
    }

    @AfterTest
    public void afterTestParent() {
        System.out.println("After Test PARENT");
    }

    @BeforeClass
    public void beforeClassParent() {
        System.out.println("Before Class PARENT");
    }

    @AfterClass
    public void afterClassParent() {
        System.out.println("After Class PARENT");
    }

    @BeforeMethod
    public void beforeMethodParent() {
        System.out.println("Before Method PARENT");
    }

    @AfterMethod
    public void afterMethodParent() {
        System.out.println("After Method PARENT");
    }

}
