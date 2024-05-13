package starter.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class login {
    private static String url="https://fakestoreapi.com/auth/login/";
    String token="eyJhbGciOiJIUzI1NiIsInR";
    @Step("I set API Endpoint for login")
    public static String setAPIEndpointForLogin() {
        return url;
    }

    @Step("I send request to login with valid email and password")
    public void loginWithValidInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "mor_2314");
        requestBody.put("password", "83r5^_");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointForLogin());
    }

    @Step("I receive status code 200")
    public void statusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get a token")
    public void getToken() {
        restAssuredThat(response -> response.body("token", notNullValue()));
    }

    @Step("I send request to login with invalid username and valid password")
    public void loginWithInvalidUsername() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "contoh");
        requestBody.put("password", "83r5^_");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointForLogin());
    }

    @Step("I receive status code 400")
    public void statusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I send request to login with valid username and invalid password")
    public void loginWithInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "mor_2314");
        requestBody.put("password", "000000");

        SerenityRest.given()
                .header("Content-type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAPIEndpointForLogin());
    }

    @Step("I send request to login with empty username and valid password")
    public void loginWithEmptyUsername() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "");
        requestBody.put("password", "83r5^_");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointForLogin());
    }

    @Step("I send request to login with valid username and empty password")
    public void loginWithEmptyPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "mor_2314");
        requestBody.put("password", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointForLogin());
    }

    @Step("receive error status code 401")
    public void errorStatusCode401() {
            restAssuredThat(response -> response.statusCode(401));
    }





}
