package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_04_PATCH;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting13_PATCHBasicAuth_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;

    @Test
    public void test_patchBasicAuthNonBDDStyle() {

        String booking_id = "2";

        // Faker library
        Faker faker = new Faker();
        String last_Name = faker.name().lastName();
        System.out.println(last_Name);
        String payloadPatch = "{\n" +
                "    \"firstname\" : \"PartialTest\",\n" +
                "    \"lastname\" : \""+last_Name+ "\"\n" +
                "}";

//        String payload = "{\n" +
//                "    \"firstname\" : \"CookieBasicAuthTest\",\n" +
//                "    \"lastname\" : \"" +last_Name+ "\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + booking_id);

        r.contentType(ContentType.JSON);
//    r.cookie("token", token);
        r.auth().preemptive().basic("admin", "password123");

        r.body(payloadPatch).log().all();
        r.filter(new AllureRestAssured());

        response = r.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
