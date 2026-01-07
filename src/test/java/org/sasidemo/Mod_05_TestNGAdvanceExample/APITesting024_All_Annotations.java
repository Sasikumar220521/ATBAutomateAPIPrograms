package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.annotations.*;

public class APITesting024_All_Annotations {

    @BeforeTest
    void demo1(){
        System.out.println("Launch Browser");
    }

    @Test
    void demo2(){
        System.out.println("Test case execution");
    }

    @AfterTest
    void demo3(){
        System.out.println("Close Browser");
    }
}
