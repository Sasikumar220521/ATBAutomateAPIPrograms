package org.sasidemo.Mod_06_TestValidations;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;


    @Description("Verify the POST Request with 3 types of validations")
    @Test
    public void test_createBooking_POST() {

        String payload = "{\n" +
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
        requestSpecification.body(payload);
        requestSpecification.filter(new AllureRestAssured());

        response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured Assertions -> import org.hamcrest.Matchers;
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Steve"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Smith"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2024-01-01"));

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        String fn = validatableResponse.extract().body().jsonPath().get("booking.firstname"); //1st way
        System.out.println("Firstname:-->>>>> " + fn);
        String ln = response.then().extract().path("booking.lastname"); //2nd way
        System.out.println("Lastname:-->>>>> " + ln);
        bookingID = response.then().extract().path("bookingid");
        System.out.println("BookingID:-->>>>> " + bookingID);

        // TestNG Assertions
        // SoftAssert vs HardAssert
        // This means that if any assertion fails, the remaining statements in that test method will not be executed.
        Assert.assertEquals(fn, "Steve");
        Assert.assertEquals(ln, "Smith");
        Assert.assertNotNull(bookingID);

        // AssertJ
        assertThat(bookingID).isPositive().isNotNull().isNotZero();
        assertThat(fn).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Stev");

        //        String s1 = ""; //Empty
        //        String s2 = " "; //Blank
    }

}
