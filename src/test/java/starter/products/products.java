package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class products {
    private static String url="https://fakestoreapi.com/products/";
    String token="eyJhbGciOiJIUzI1NiIsInR";
    @Step("set API endpoint for all product")
    public static String setApiEndpointAllProducts() {
        return url;
    }

    @Step("set API endpoint for a single product")
    public static String setApiEndpointSingleProduct(int productID) {
        return url + productID;
    }

    @Step("set API endpoint for limiting results")
    public static String setApiEndpointLimitResult(int limit) {
        return url + "?limit=" + limit;
    }

    @Step("set API endpoint for sort results")
    public static String setApiEndpointSortResult(String sort){
        return url + "?sort=" + sort;
    }

    @Step("set API endpoint for categories")
    public static String setApiEndpointAllCategories() {
        return url + "categories";
    }

    @Step("set API endpoint for specific category")
    public static String setApiEndpointSpecificCategory(String category) {
        return url + "category/" + category;
    }

    @Step(" I send request to get all product")
    public void getAllProducts() {
        SerenityRest.given()
                .get(setApiEndpointAllProducts());
    }

    @Step("I send request to get a single product")
    public void getSingleProducts() {
        SerenityRest.given()
                .get(setApiEndpointSingleProduct(1));
    }

    @Step("I send request to limit the result")
    public void limitResult() {
        SerenityRest.given()
                .get(setApiEndpointLimitResult(5));
    }

    @Step("I send request to sort products by descending")
    public void sortDescendingProducts() {
        SerenityRest.given()
                .get(setApiEndpointSortResult("desc"));
    }

    @Step("I send request to sort products by ascending")
    public void sortAscendingProducts() {
        SerenityRest.given()
                .get(setApiEndpointSortResult("asc"));
    }

    @Step(" I send request to get all categories")
    public void getAllCategories() {
        SerenityRest.given()
                .get(setApiEndpointAllCategories());
    }

    @Step(" I send request to get specific category")
    public void getSpecificCategory() {
        SerenityRest.given()
                .get(setApiEndpointSpecificCategory("jewelery"));
    }



    @Step("I send request to add new product")
    public void addNewProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "test product");
        requestBody.put("price", 13.5);
        requestBody.put("description", "lorem ipsum set");
        requestBody.put("image", "https://i.pravatar.cc");
        requestBody.put("category", "electronic");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllProducts());
    }

    @Step("I send request to add new product with empty fields")
    public void addNewProductWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "");
        requestBody.put("price", "");
        requestBody.put("description", "");
        requestBody.put("image", "");
        requestBody.put("category", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointAllProducts());
    }

    @Step("I send request to update a product")
    public void updateProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "test product");
        requestBody.put("price", 13.5);
        requestBody.put("description", "lorem ipsum set");
        requestBody.put("image", "https://i.pravatar.cc");
        requestBody.put("category", "electronic");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleProduct(7));
    }

    @Step("I cannot update a product with empty fields")
    public void updateProductWithEmptyFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "");
        requestBody.put("price", "");
        requestBody.put("description", "");
        requestBody.put("image", "");
        requestBody.put("category", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .put(setApiEndpointSingleProduct(7));
    }

    @Step("I send request to delete a product")
    public void deleteProduct(){
        SerenityRest.given()
                .delete(setApiEndpointSingleProduct(6));
    }

    @Step("I receive valid data of all products")
    public void receiveProductsData() {
        restAssuredThat(
                response -> {
                    response.body("ID", notNullValue());
                    response.body("title", notNullValue());
                    response.body("price", notNullValue());
                    response.body("category", notNullValue());
                    response.body("description", notNullValue());
                    response.body("image", notNullValue());
                }
        );
        SerenityRest.given()
            .header("Authorization", "Bearer " + token);
    }

    @Step("I receive valid data of single products")
    public void receiveSingleProductsData() {
        restAssuredThat(response -> notNullValue());
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }
    @Step("I receive valid data of all categories")
    public void receiveCategoriesData() {
        restAssuredThat(response -> notNullValue());
    }

}
