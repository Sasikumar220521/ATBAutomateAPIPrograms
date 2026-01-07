package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    @Test(invocationCount = 2)
    public void test_02() {
        System.out.println("I am Test2");
        Assert.assertTrue(true);
    }

    @Test(invocationCount = 3)
    public void test_01() {
        System.out.println("I am Test1");
        Assert.assertTrue(true);
    }
}
