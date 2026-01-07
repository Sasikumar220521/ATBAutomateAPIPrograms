package org.sasidemo.Mod_06_TestValidations;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    @Test
    public void testHardAssert(){
        System.out.println("Test case started");
        Assert.assertEquals("name", "nam");
        System.out.println("This won't execute due to assertion failed");

    }

    @Test
    public void testSoftAssert(){
        System.out.println("Test case started");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals("name", "nam");

        System.out.println("This will execute even if assertion failed");
        System.out.println("Due to soft assert, in the end asserAll() need to add to throw the exceptions");

        sa.assertAll();  // Call assertAll() to report any failures
    }
}
