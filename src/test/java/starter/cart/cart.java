package starter.cart;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class cart {
    private static String url="https://fakestoreapi.com/carts/";
    String token="eyJhbGciOiJIUzI1NiIsInR";
    @Step("set API endpoint for all cart")
    public static String setApiEndpointAllCart() {
        return url;
    }

    @Step("set API endpoint for a single cart")
    public static String setApiEndpointSingleCart(int cartID) {
        return url + cartID;
    }

    @Step("set API endpoint for limiting cart results")
    public static String setApiEndpointLimitCartResult(int limit) {
        return url + "?limit=" + limit;
    }

    @Step("set API endpoint for sort cart results")
    public static String setApiEndpointSortCartResult(String sort){
        return url + "?sort=" + sort;
    }

    @Step("set API endpoint for get other user carts")
    public static String setApiEndpointOtherUserCart(int user){
        return url + "user/" + user;
    }

    @Step("set API endpoint for get carts in a date range")
    public static String setApiEndpointGetCartDateRange(){
        return url + "?sort=?startdate=2019-12-10&enddate=2020-10-10";
    }

    @Step(" I send request to get all product")
    public void getAllCarts() {
        SerenityRest.given()
                .get(setApiEndpointAllCart());
    }

    @Step("I send request to get a single product")
    public void getSingleCarts() {
        SerenityRest.given()
                .get(setApiEndpointSingleCart(5));
    }

    @Step("I send request to limit the result")
    public void limitCartResult() {
        SerenityRest.given()
                .get(setApiEndpointLimitCartResult(5));
    }

    @Step("I send request to sort products by descending")
    public void sortDescendingCarts() {
        SerenityRest.given()
                .get(setApiEndpointSortCartResult("desc"));
    }

    @Step("I send request to sort products by ascending")
    public void sortAscendingCarts() {
        SerenityRest.given()
                .get(setApiEndpointSortCartResult("asc"));
    }

    @Step("I send request to add new cart")
    public void addNewCart() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 5);
        requestBody.put("date", "2020-02-03");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", 5).put("quantity", 1))
                .put(new JSONObject().put("productId", 1).put("quantity", 5));
        requestBody.put("products", productsArray);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllCart());
    }

    @Step("I send request to add new cart with empty fields")
    public void addNewCartWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", "");
        requestBody.put("date", "");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", "").put("quantity", ""))
                .put(new JSONObject().put("productId", "").put("quantity", ""));
        requestBody.put("products", productsArray);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllCart());
    }

    @Step("I send request to update a cart")
    public void updateCart() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 7);
        requestBody.put("date", "2020-02-03");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", 5).put("quantity", 1))
                .put(new JSONObject().put("productId", 1).put("quantity", 5));
        requestBody.put("products", productsArray);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleCart(7));
    }

    @Step("I cannot update a cart with empty fields")
    public void updateCartWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId","");
        requestBody.put("date", "");
        JSONArray productsArray = new JSONArray()
                .put(new JSONObject().put("productId", "").put("quantity", ""))
                .put(new JSONObject().put("productId", "").put("quantity", ""));
        requestBody.put("products", productsArray);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleCart(7));
    }

    @Step("I send request to delete a cart")
    public void deleteCart(){
        SerenityRest.given()
                .delete(setApiEndpointSingleCart(6));
    }

    @Step("I receive valid data of all carts")
    public void receiveCartData() {
        restAssuredThat(
                response -> {
                    response.body("userId", notNullValue());
                    response.body("date", notNullValue());
                    response.body("products", notNullValue());
                }
        );
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("I receive valid data of single cart")
    public void receiveSingleCartData() {
        restAssuredThat(response -> notNullValue());
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("I send request to get other user carts")
    public void getOtherUserCart() {
        SerenityRest.given()
                .get(setApiEndpointOtherUserCart(2));
    }

    @Step("I send request to get carts by date range")
    public void getCartByDateRange() {
        SerenityRest.given()
                .get(setApiEndpointGetCartDateRange());
    }
}
