package org.example;

import com.google.gson.Gson;
import dto.TestOrderDto;
import dto.TestUserDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiMockTest {

    //Task 1 constructor with setters
    @Test
    public void testWithBody () {

        //Dto creation with constructor and setters
        TestOrderDto testOrderDtoSetter = new TestOrderDto();
        testOrderDtoSetter.setComment("new-comment");
        testOrderDtoSetter.setCustomerPhone("77777777");
        testOrderDtoSetter.setCustomerName("Name");

        //Serialization
       String testOrderDtoAsJson = new Gson().toJson(testOrderDtoSetter);


        //API Request
        Response requestResponse = given()
                .header("Content-Type", "application/json")
                .body(testOrderDtoAsJson)
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .extract()
                .response();

        //Deserialization
        TestOrderDto resultReceived = new Gson().fromJson(requestResponse.asString(),TestOrderDto.class);

        //Assertion
        assertAll("Assert all fields",
        () -> Assertions.assertEquals("new-comment", resultReceived.getComment()),
        () -> Assertions.assertEquals("77777777", resultReceived.getCustomerPhone()),
        () -> Assertions.assertEquals("Name", resultReceived.getCustomerName()),
        () -> assertEquals(HttpStatus.SC_OK, requestResponse.getStatusCode()));
    }

    //Task 1 constructor with parameters
    @Test
    public void testOrderDtoConstructor(){

        //Dto creation
        TestOrderDto testOrderDto = new TestOrderDto("John", "+372372273", "Some comments");

        //Serialization
        String testOrderDtoConstructorAsJson = new Gson().toJson(testOrderDto);

        Response response = given()
                .log()
                .all()
                //API request
                .header("Content-type", "application/json")
                .body(testOrderDtoConstructorAsJson)
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .extract()
                .response();


        //Deserialization
        TestOrderDto resultReceived = new Gson().fromJson(response.asString(), TestOrderDto.class);

        //Assertions
        Assertions.assertEquals("OPEN", resultReceived.getStatus());
        Assertions.assertEquals("John", resultReceived.getCustomerName());
        Assertions.assertEquals("+372372273", resultReceived.getCustomerPhone());
        Assertions.assertEquals("Some comments", resultReceived.getComment());

        //AssertALL
        assertAll("Group Assertion",
                () -> assertEquals("OPEN", resultReceived.getStatus()),
                () -> assertEquals("John", resultReceived.getCustomerName()),
                () -> assertEquals("+372372273", resultReceived.getCustomerPhone()),
                () -> assertEquals("Some comments", resultReceived.getComment()),
                () -> assertEquals(HttpStatus.SC_OK, response.getStatusCode()));

    }

    //Task 2, constructor + setters
    @Test
    public void userTestWithBody() {

        //Dto creation with setters
        TestUserDto testUserDtoSetter = new TestUserDto();
        testUserDtoSetter.setUsername("User-name");
        testUserDtoSetter.setFirstName("Name");
        testUserDtoSetter.setLastName("Last");
        testUserDtoSetter.setEmail("mail@gmail.com");
        testUserDtoSetter.setPassword("567");
        testUserDtoSetter.setPhone("+1234567");

        //Serialization
        String testUserDtoAsJson = new Gson().toJson(testUserDtoSetter);

        //API request
        Response response = given()
                .header("Content-type","application/json")
                .body(testUserDtoAsJson)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .body()
                .extract()
                .response();

        //Deserialization
        TestUserDto receivedResult = new Gson().fromJson(response.asString(), TestUserDto.class);

        //Assertion
        assertAll("All assertions",
                () -> Assertions.assertEquals(200, receivedResult.getCode()),
                () -> Assertions.assertEquals("unknown", receivedResult.getType()),
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode())
        );
    }

    //Task 2, constructor with parameters
    @Test
    public void userTestConstructor(){

        //Dto creation
        TestUserDto testUserDto = new TestUserDto("nameuser", "Name", "Lastname", "email@mail.com", "1234", "+372372273");

        //Serialization
        String testUserDtoConstructorAsJson = new Gson().toJson(testUserDto);

        //API request
        Response response = given()
                .header("Content-type","application/json")
                .body(testUserDtoConstructorAsJson)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .body()
                .extract()
                .response();

        //Deserialization
        TestUserDto resultOfRequest = new Gson().fromJson(response.asString(), TestUserDto.class);

        //Assertions
        assertAll("All assertions",
                () -> Assertions.assertEquals(200, resultOfRequest.getCode()),
                () -> Assertions.assertEquals("unknown", resultOfRequest.getType()),
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode()));
    }
}