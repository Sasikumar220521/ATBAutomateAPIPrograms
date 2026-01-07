package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {

    @Test
    public void serverStart(){
        System.out.println("Server started, I will run first");
        System.out.println("dependsOnMethods attribute is guaranteed to be executed only once by TestNG, regardless of how many other methods depend on it. ");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStart")
    public void test1(){
        System.out.println("Test case 1 executed");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStart")
    public void test2(){
        System.out.println("Test case 2 executed");
        Assert.assertTrue(true);
    }

}
