package org.sasidemo;

import io.restassured.RestAssured;

public class HelloWorldNew {
    public static void main(String[] args) {
        RestAssured.given().baseUri("https://google.com").log().all()
                .when().get()
                .then().statusCode(200).log().all();
    }
}
