package org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_03_PUT;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.sasidemo.Mod_04_RestAssured_HTTP_Methods.Ex_02_POST.APITesting11_POST_NonBDDStyle;
import org.testng.annotations.Test;

    public class APITesting12_PUTCookieToken_NonBDDStyle extends APITesting11_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;


    @Test
    public void test_PUTcookieTokenNonBDDStyle(){

        // Token generation from previous package class
        APITesting11_POST_NonBDDStyle ob = new APITesting11_POST_NonBDDStyle();
        ob.test_POST_AuthToken_NonBDDStyle();
        token = ob.generated_token;
        System.out.println(token);

        String booking_id = "2";

        String payload = "{\n" +
                "    \"firstname\" : \"CookieAuthTestSasi\",\n" +
                "    \"lastname\" : \"New\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);

        r.contentType(ContentType.JSON);
        r.cookie("token", token);
//        r.auth().preemptive().basic("admin", "password123");

        r.body(payload).log().all();
        r.filter(new AllureRestAssured());

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
