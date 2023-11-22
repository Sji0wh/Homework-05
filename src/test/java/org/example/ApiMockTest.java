package org.example;

import com.google.gson.Gson;
import dto.TestOrderDto;
import dto.TestUserDto;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


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

        given()
                .header("Content-Type", "application/json")
                .body(testOrderDtoAsJson)
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    //Task 1 constructor with parameters
    @Test
    public void testOrderDtoConstructor(){

        //Dto creation
        TestOrderDto testOrderDto = new TestOrderDto("John", "+372372273", "Some comments");

        //Serialization
        String testOrderDtoConstructorAsJson = new Gson().toJson(testOrderDto);

        //API request
        given()
                .header("Content-type", "application/json")
                .body(testOrderDtoConstructorAsJson)
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
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
        given()
                .header("Content-type","application/json")
                .body(testUserDtoAsJson)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    //Task 2, constructor with parameters
    @Test
    public void userTestConstructor(){
        //Dto creation
        TestUserDto testUserDto = new TestUserDto("nameuser", "Name", "Lastname", "email@mail.com", "1234", "+372372273");

        //Serialization
        String testUserDtoConstructorAsJson = new Gson().toJson(testUserDto);

        //API request
        given()
                .log()
                .all()
                .header("Content-type","application/json")
                .body(testUserDtoConstructorAsJson)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
