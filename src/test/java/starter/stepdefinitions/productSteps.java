package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.products;

public class productSteps {
    @Steps
    products products;

    @Given("I set API endpoint for all product")
    public void setAPIEndpointForAllProduct() {
        products.setApiEndpointAllProducts();
    }

    @When("I send request to get all product")
    public void getAllProducts() {
        products.getAllProducts();
    }

    @And("I receive valid data of all products")
    public void receiveValidDataAllProducts() {
        products.receiveProductsData();
    }

    @When("I send request to get a single product")
    public void getSingleProduct() {
        products.getSingleProducts();
    }

    @And("I receive valid data that product")
    public void receiveValidDataOfProduct() {
        products.receiveSingleProductsData();
    }

    @When("I send request to limit the result")
    public void limitResults() {
        products.limitResult();
    }

    @And("I receive valid data of all products of limited result")
    public void receiveValidLimitResults() {
        products.receiveProductsData();
    }

    @When("I send request to sort products by descending")
    public void sortProductDescending() {
        products.sortDescendingProducts();
    }

    @And("I receive valid data of all products by descending")
    public void receiveValidDataDescending() {
        products.receiveProductsData();
    }

    @When("I send request to sort products by ascending")
    public void sortProductAscending() {
        products.sortAscendingProducts();
    }

    @And("I receive valid data of all products by ascending")
    public void receiveValidDataAscending() {
        products.receiveProductsData();
    }

    @Given("I set API endpoint for all category")
    public void setAPIendpointAllCategories() {
        products.setApiEndpointAllCategories();
    }

    @When("I send request to get all categories")
    public void getAllCategories() {
        products.getAllCategories();
    }

    @And("I receive valid data of all categories")
    public void receiveAllCategories() {
        products.receiveCategoriesData();
    }

    @When("I send request to get a specific category")
    public void getSpecificCategory() {
        products.getSpecificCategory();
    }

    @And("I receive valid data of a category")
    public void receiveValidDataCategory() {
        products.receiveCategoriesData();
    }

    @When("I send request to add new product")
    public void addNewProduct() {
        products.addNewProduct();
    }

    @And("I receive valid data of new product")
    public void receiveDataNewProduct() {
        products.receiveSingleProductsData();
    }

    @When("I send request to add new product with empty fields")
    public void addNewProductWithEmptyFields() {
        products.addNewProductWithEmptyFields();
    }

    @When("I send request to update a product")
    public void updateProduct() {
        products.updateProduct();
    }

    @And("I receive valid data of updated product")
    public void receiveUpdatedProductData() {
        products.receiveSingleProductsData();
    }

    @When("I send request to update product with empty fields")
    public void updateProductWithEmptyFields() {
        products.updateProductWithEmptyFields();
    }

    @When("I send request to delete a product")
    public void deleteProduct() {
        products.deleteProduct();
    }
}
