package com.anhtester.package_demo.package3;

import org.testng.annotations.Test;

public class TestPackage3_A {
    @Test(groups = {"smoke"})
    public void testLoginCRM(){
        System.out.println("Test login success CRM");
    }

    @Test
    public void testCreateCustomer(){
        System.out.println("Test add new Customer CRM");
    }

    @Test(groups = {"smoke"})
    public void testEditCustomer(){
        System.out.println("Test edit Customer CRM");
    }
}
