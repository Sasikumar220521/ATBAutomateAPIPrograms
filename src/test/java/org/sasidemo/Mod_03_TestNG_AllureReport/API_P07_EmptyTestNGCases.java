package org.sasidemo.Mod_03_TestNG_AllureReport;

import org.testng.annotations.Test;

public class API_P07_EmptyTestNGCases {

    @Test
    public void test_01() {
        System.out.println("I am Test1");
    }

    @Test(enabled = false)
    public void test_02() {

    }

    @Test
    public void test_03() {

    }

}
