package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class user {
    private static String url="https://fakestoreapi.com/users/";
    String token="eyJhbGciOiJIUzI1NiIsInR";
    @Step("set API endpoint for all user")
    public static String setApiEndpointAllUser() {
        return url;
    }

    @Step("set API endpoint for a single user")
    public static String setApiEndpointSingleUser(int userID) {
        return url + userID;
    }

    @Step("set API endpoint for limiting user results")
    public static String setApiEndpointLimitUserResult(int limit) {
        return url + "?limit=" + limit;
    }

    @Step("set API endpoint for sort user results")
    public static String setApiEndpointSortUserResult(String sort){
        return url + "?sort=" + sort;
    }

    @Step(" I send request to get all user")
    public void getAllUser() {
        SerenityRest.given()
                .get(setApiEndpointAllUser());
    }

    @Step("I send request to get a single user")
    public void getSingleUser() {
        SerenityRest.given()
                .get(setApiEndpointSingleUser(1));
    }

    @Step("I send request to limit the user result")
    public void limitUserResult() {
        SerenityRest.given()
                .get(setApiEndpointLimitUserResult(5));
    }

    @Step("I send request to sort user by descending")
    public void sortDescendingUser() {
        SerenityRest.given()
                .get(setApiEndpointSortUserResult("desc"));
    }

    @Step("I send request to sort user by ascending")
    public void sortAscendingUser() {
        SerenityRest.given()
                .get(setApiEndpointSortUserResult("asc"));
    }


    @Step("I send request to add new user")
    public void addNewUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "John@gmail.com");
        requestBody.put("username", "johnd");
        requestBody.put("password", "'m38rmF$");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", 5).put("quantity", 1))
                .put(new JSONObject().put("productId", 1).put("quantity", 5));
        requestBody.put("products", productsArray);
        requestBody.put("address", new JSONObject()
                .put("city", "kilcoole")
                .put("street", "7835 new road")
                .put("number", 3)
                .put("zipcode", "12926-3874")
                .put("geolocation", new JSONObject()
                        .put("lat", "-37.3159")
                        .put("long", "81.1496")
                )
        );
        requestBody.put("phone", "1-570-236-7033");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllUser());
    }

    @Step("I send request to add new user with empty fields")
    public void addNewUserWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("username", "");
        requestBody.put("password", "'");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", "").put("quantity", ""))
                .put(new JSONObject().put("productId", "").put("quantity", ""));
        requestBody.put("products", productsArray);
        requestBody.put("address", new JSONObject()
                .put("city", "")
                .put("street", "")
                .put("number", "")
                .put("zipcode", "")
                .put("geolocation", new JSONObject()
                        .put("lat", "")
                        .put("long", "")
                )
        );
        requestBody.put("phone", "1-570-236-7033");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllUser());
    }

    @Step("I send request to update a user")
    public void updateUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "John@gmail.com");
        requestBody.put("username", "johnd");
        requestBody.put("password", "'m38rmF$");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", 5).put("quantity", 1))
                .put(new JSONObject().put("productId", 1).put("quantity", 5));
        requestBody.put("products", productsArray);
        requestBody.put("address", new JSONObject()
                .put("city", "kilcoole")
                .put("street", "7835 new road")
                .put("number", 3)
                .put("zipcode", "12926-3874")
                .put("geolocation", new JSONObject()
                        .put("lat", "-37.3159")
                        .put("long", "81.1496")
                )
        );
        requestBody.put("phone", "1-570-236-7033");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleUser(7));
    }

    @Step("I cannot update a user with empty fields")
    public void updateUserWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("username", "");
        requestBody.put("password", "'");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", "").put("quantity", ""))
                .put(new JSONObject().put("productId", "").put("quantity", ""));
        requestBody.put("products", productsArray);
        requestBody.put("address", new JSONObject()
                .put("city", "")
                .put("street", "")
                .put("number", "")
                .put("zipcode", "")
                .put("geolocation", new JSONObject()
                        .put("lat", "")
                        .put("long", "")
                )
        );
        requestBody.put("phone", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleUser(7));
    }

    @Step("I send request to delete a user")
    public void deleteUser(){
        SerenityRest.given()
                .delete(setApiEndpointSingleUser(6));
    }

    @Step("I receive valid data of all user")
    public void receiveUserData() {
        restAssuredThat(
                response -> {
                    response.body("email", notNullValue());
                    response.body("username", notNullValue());
                    response.body("password", notNullValue());
                    response.body("name", notNullValue());
                    response.body("adderss", notNullValue());
                    response.body("phone", notNullValue());
                }
        );
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("I receive valid data of single user")
    public void receiveSingleUserData() {
        restAssuredThat(response -> notNullValue());
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

}
