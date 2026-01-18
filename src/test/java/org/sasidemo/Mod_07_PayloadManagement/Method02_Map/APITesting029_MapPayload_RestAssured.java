package org.sasidemo.Mod_07_PayloadManagement.Method02_Map;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting029_MapPayload_RestAssured {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;


    @Description("Verify the POST Request using Map payload")
    @Test
    public void test_createBooking_POST() {

//        String payloadPost = "{\n" +
//                "    \"firstname\" : \"Steve\",\n" +
//                "    \"lastname\" : \"Smith\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-02\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Dinner\"\n" +
//                "}";


        // Hashmap - key value - order is not maintained
        // LinkedHashmap - can maintain the order. -
        //  TreeMap - Sorting.

        Map<String,Object> payloadPostUsingMap = new LinkedHashMap<>();
        payloadPostUsingMap.put("firstname", "Glenn");
        payloadPostUsingMap.put("lastname", "Max");
        payloadPostUsingMap.put("totalprice", 120);
        payloadPostUsingMap.put("depositpaid", true);

        Map<String,Object> bookingdatesMap = new LinkedHashMap<>();
        bookingdatesMap.put("checkin" , "2024-01-01");
        bookingdatesMap.put("checkout", "2024-01-02");

        payloadPostUsingMap.put("bookingdates", bookingdatesMap);
        payloadPostUsingMap.put("additionalneeds", "Lunch");
        System.out.println("JSONBodyUsingMap: " + payloadPostUsingMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadPostUsingMap).log().all();
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

        // AssertJ
        assertThat(bookingID).isPositive().isNotNull().isNotZero();
        assertThat(fn).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Steve");
    }
}