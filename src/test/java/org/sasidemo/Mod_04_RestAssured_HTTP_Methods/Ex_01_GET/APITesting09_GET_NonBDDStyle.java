package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_01_GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting09_GET_NonBDDStyle {

    String pincode;
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public  void test_GET_NonBDDStyle(){
        pincode = "560037";
        // DIVIDE YOUR PROGRAM INTO 3 PARTS
        // GIVEN - PART 1
        r = RestAssured.given();
        r.baseUri("https://zippopotam.us");
        r.basePath("/IN/" + pincode);

        // Making HTTP Request -> Part 2
        response = r.when().log().all().get();
        System.out.println(response.asString());

        // Then - Part 3 - validation
        vr = response.then().log().all();
        vr.statusCode(200);
        // Write the further testcases or assertions also here.

    }
}
