package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.annotations.Test;

public class APITesting15_TestNG_Basics {

    public void TC1(){
        System.out.println("Testcase 1 without TestNG annotation");
    }

    @Test
    public void TC2(){
        System.out.println("Testcase 2 with TestNG annotation");
    }
}
