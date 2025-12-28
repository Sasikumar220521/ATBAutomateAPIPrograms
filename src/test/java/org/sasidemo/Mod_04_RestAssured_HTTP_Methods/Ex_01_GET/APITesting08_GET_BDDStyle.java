package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_01_GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting08_GET_BDDStyle {

@Test
    public void test_GET_Positive() {
        String pincode = "560037";
        RestAssured
                .given().baseUri("https://zippopotam.us")
                        .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }

}
