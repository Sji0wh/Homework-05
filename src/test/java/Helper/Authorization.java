package Helper;

import com.google.gson.Gson;
import dto.TestLoginDto;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authorization {
    public static String getToken(){
        SetupFunctions setupFunctions = new SetupFunctions();
        TestLoginDto loginDto = new TestLoginDto(setupFunctions.getUsername(), setupFunctions.getPassword());

        // serialization
        String testLoginDtoAsJson = new Gson().toJson(loginDto);

        Response response = given().
                log().
                all().
                header("Content-Type", "application/json").
                body(testLoginDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                extract().
                response();

        return response.body().asString();

    }


}