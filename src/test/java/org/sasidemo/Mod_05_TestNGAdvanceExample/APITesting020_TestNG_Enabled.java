package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Enabled {

    @Test
    public void test_01() {
        System.out.println("I am Test1");
        Assert.assertTrue(true);
        System.out.println("After assertion1 Line1"); //This line and further lines won't execution if Assertion fails
        System.out.println("Line2");
    }

    @Test(enabled = false)
    public void test_02() {
        System.out.println("I am Test2");
        Assert.assertTrue(true);
    }

    @Test
    public void test_03() {
        System.out.println("I am Test3");
        Assert.assertTrue(true);
    }
}
