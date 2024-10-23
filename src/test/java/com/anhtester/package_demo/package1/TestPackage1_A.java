package com.anhtester.package_demo.package1;

import org.testng.annotations.Test;

public class TestPackage1_A {
    @Test
    public void testLoginCRM(){
        System.out.println("Test login success CRM");
    }

    @Test
    public void testCreateCustomer(){
        System.out.println("Test add new Customer CRM");
    }

    @Test
    public void testEditCustomer(){
        System.out.println("Test edit Customer CRM");
    }
}
