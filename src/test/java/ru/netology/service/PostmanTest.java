package ru.netology.service;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanTest {

    @Test
    public void shouldReturnPostData() {
        given()
            .baseUri("https://postman-echo.com")
            .body("some data")
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("data", equalTo("some data"));
    }

    @Test 
    public void shouldFailWithWrongData() {
        // Этот тест должен упасть
        given()
            .baseUri("https://postman-echo.com")
            .body("some data")
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("data", equalTo("wrong data"));
    }
}