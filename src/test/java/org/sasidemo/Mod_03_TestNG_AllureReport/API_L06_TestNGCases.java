package org.sasidemo.Mod_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_L06_TestNGCases {
    String pincode = " ";

    @Test
    public void testGetPositive_TC1() {
        System.out.println("TC1");
        pincode = "560037";
        RestAssured
                .given().baseUri("https://zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all().statusCode(200);

    }

    @Test
    public void testGetNegative_TC2() {
        System.out.println("TC2");
        pincode = "@";
        RestAssured
                .given().baseUri("https://zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all().statusCode(200);

    }

    @Test
    public void testGetNegative_TC3() {
        System.out.println("TC3");
        pincode = " ";
        RestAssured
                .given().baseUri("https://zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all().statusCode(200);

    }
}
