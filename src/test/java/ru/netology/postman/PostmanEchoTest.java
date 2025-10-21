package ru.netology.postman;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {
    @Test
    void shouldReturnSentData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные
        // Выполняемые действия
        .when()
                .post("/post")
        // Проверки
        .then()
                .statusCode(200)
                // Проверяем, что в поле data вернулись отправленные данные
                .body("data", equalTo("wrong data")); // вместо "some data"
    }
}