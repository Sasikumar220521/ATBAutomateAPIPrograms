package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_02_POST;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting11_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    public String generated_token;

    @Test
    public void test_POST_AuthToken_NonBDDStyle(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // DIVIDE YOUR PROGRAM INTO 3 PARTS
        // GIVEN - PART 1
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();
        r.filter(new AllureRestAssured());

        // Making HTTP Request -> Part 2
        response = r.when().post();
        generated_token = response.jsonPath().getString("token");
        System.out.println("Generated token "+ generated_token);

        // Then - Part 3 - validations
        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
