package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018a_TestNG_DependsOnMethodFailure {

    @Test
    public void serverStart(){
        System.out.println("Server started, I will run first");
        System.out.println("!!dependsOnMethods attribute is guaranteed to be executed only once by TestNG, regardless of how many other methods depend on it. ");
        System.out.println("!! If failed, dependent tests will be skipped(ignored)");
        Assert.assertTrue(false);
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
