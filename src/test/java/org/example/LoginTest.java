package org.example;

import Helper.SetupFunctions;
import com.google.gson.Gson;
import dto.TestLoginDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    public static SetupFunctions setupFunctions;

    @BeforeAll
    public static void setup(){
        setupFunctions = new SetupFunctions();

    }

    @Test
    public void userLogin (){

        //DTO creation
        TestLoginDto logIn = new TestLoginDto(setupFunctions.getUsername(), setupFunctions.getPassword());

        //Serialization
        String testLoginDtoAsJson = new Gson().toJson(logIn);

        //Api test
        Response response = given()
                .header("content-type", "application/json")
                .body(testLoginDtoAsJson)
                .post(setupFunctions.getBaseUrl() + "/login/student")
                .then()
                .log()
                .body()
                .extract()
                .response();
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void incorrectCredentialsUserLogin (){

        //DTO creation
        TestLoginDto logIn = new TestLoginDto(setupFunctions.getUsername(), "123");

        //Serialization
        String testLoginDtoAsJson = new Gson().toJson(logIn);

        //Api test
        given()
                .header("content-type", "application/json")
                .body(testLoginDtoAsJson)
                .post(setupFunctions.getBaseUrl() + "/login/student")
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
