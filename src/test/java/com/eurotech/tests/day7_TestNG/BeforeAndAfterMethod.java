package com.eurotech.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAndAfterMethod {


    @BeforeClass
    public void setupClass(){
        System.out.println("---BEFORE CLASS---");
        System.out.println("Execute one time before the class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("----AFTER CLASS---");
        System.out.println("Some reporting Code Here");
    }
    @Test
    public void test1() {

        System.out.println("First Test Case");

    }

    @BeforeMethod
    public void setup(){
        System.out.println("Web driver, opening browser");
        System.out.println("Navigate DevEx URL");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Thread.Sleep(2000)");
        System.out.println("User Logut");
        System.out.println("Closing Browser quit");

    }
    @Test
    public void test2() {

        System.out.println("Second Test Case");
    }

    @Test
    public void test3() {

        System.out.println("Third test case");
    }

    @Test
    public void test4() {
        System.out.println("Last Test Case");
    }
}
