package org.example;

import Helper.Authorization;
import com.google.gson.Gson;
import dto.TestOrderDto;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class OrderCreationTest {

    static String token;

    @BeforeAll
    public static void setup() {
        token = Authorization.getToken();
    }

    @Test
    public void CreateOrder () {

        //DTO creation
        TestOrderDto testOrderDto = new TestOrderDto("John", "+372372273", "Some comments");

        //Serialization
        String testOrderDtoAsJson = new Gson().toJson(testOrderDto);

        //Api test
        given()
                .header("content-type", "application/json")
                .header("Authorization","Bearer " + token)
                .body(testOrderDtoAsJson)
                .post("http://51.250.6.164:8080/orders")
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK);

    }
    @Test
    public void getOrderById(){
        given()
                .header("content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get("http://51.250.6.164:8080/orders/5315")
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK);
    }
}

