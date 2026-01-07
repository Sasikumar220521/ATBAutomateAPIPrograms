package org.sasidemo.Mod_05_TestNGAdvanceExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void testCase1(String value) {
        System.out.println("Selected Browser " + value);

        if (value.equalsIgnoreCase("chrome"))
            System.out.println("Execution started!! in chrome");
        else if (value.equalsIgnoreCase("firefox"))
            System.out.println("Execution started!! in firefox");

    }

}
