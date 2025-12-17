package org.sasidemo.Mod_02_RA_Concepts;

import io.restassured.RestAssured;

public class API_L05_MultipleCases {
    public static void main(String[] args) {
        String pincode = "560037";

        RestAssured
                .given().baseUri("https://zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}
