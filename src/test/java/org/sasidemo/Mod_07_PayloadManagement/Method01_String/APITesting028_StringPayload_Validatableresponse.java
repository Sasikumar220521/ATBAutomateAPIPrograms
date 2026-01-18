package org.sasidemo.Mod_07_PayloadManagement.Method01_String;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting028_StringPayload_Validatableresponse {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;


    @Description("Verify the POST Request using String payload")
    @Test
    public void test_createBooking_POST() {

        String payloadPost = "{\n" +
                "    \"firstname\" : \"Steve\",\n" +
                "    \"lastname\" : \"Smith\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Dinner\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadPost);
        requestSpecification.filter(new AllureRestAssured());

        response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        String fn = validatableResponse.extract().body().jsonPath().get("booking.firstname"); //1st way
        System.out.println("Firstname:-->>>>> " + fn);
        String ln = response.then().extract().path("booking.lastname"); //2nd way
        System.out.println("Lastname:-->>>>> " + ln);
        bookingID = response.then().extract().path("bookingid");
        System.out.println("BookingID:-->>>>> " + bookingID);
        //TestNG assertions
        Assert.assertEquals(fn, "Steve");
        Assert.assertEquals(ln, "Smith");
        Assert.assertNotNull(bookingID);
    }
}
