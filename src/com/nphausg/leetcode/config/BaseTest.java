package com.nphausg.leetcode.config;

public class BaseTest {
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Running a test...");
        System.out.println("This executes before any test cases. Count = " + count++);
    }


    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

}