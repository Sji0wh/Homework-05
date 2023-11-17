package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class OrderControllerTest {

    private static final String BASE_URL = "http://51.250.6.164:8080";

    //Positive GET method test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9, 10})
    public void successGettingOrder(int orderId){
        String URL = BASE_URL + "/test-orders/" + orderId;
        given()
                .log()
                .all()
                .when()
                .get(URL)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    //Negative GET method test
    @ParameterizedTest
    @ValueSource (ints = {15, 16})
    public void negativeGettingOrder(int orderId){
        String URL = BASE_URL + "/test-orders/";
        given()
                .log()
                .all()
                .when()
                .get(URL + "{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    //Mixed GET method test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9, 10, 11})
    public void testGettingOrder(int orderId){
        String URL = "http://51.250.6.164:8080/test-orders/" + orderId;

        Response response = given()
                .log()
                .all()
                .when()
                .get(URL);

        if (orderId > 10) {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST);
        } else {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK);
        }
    }
}
