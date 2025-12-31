package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_05_DELETE;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting14_DELETEBasicAuth_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;

    @Test
    public void test_deleteBasicAuthNonBDDStyle() {

        String booking_id = "6";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + booking_id);

        r.contentType(ContentType.JSON);
        r.auth().preemptive().basic("admin", "password123");

        r.filter(new AllureRestAssured());

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
