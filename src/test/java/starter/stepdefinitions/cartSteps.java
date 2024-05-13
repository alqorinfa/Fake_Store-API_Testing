package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.cart.cart;

public class cartSteps {
    @Steps
    cart cart;

    @Given("I set API endpoint for all carts")
    public void setAPIEndpointForAllCart() {
        cart.setApiEndpointAllCart();
    }

    @When("I send request to get all carts")
    public void getAllCart() {
        cart.getAllCarts();
    }

    @And("I receive valid data of all carts")
    public void receiveValidDataAllCart() {
        cart.receiveCartData();
    }

    @When("I send request to get single cart")
    public void getSingleCart() {
        cart.getSingleCarts();
    }

    @And("I receive valid data of single cart")
    public void receiveValidDataOfCart() {
        cart.receiveSingleCartData();
    }

    @When("I send request to limit carts")
    public void limitCartResults() {
        cart.limitCartResult();
    }

    @And("I receive valid data of limit carts")
    public void receiveValidLimitCartResults() {
        cart.receiveCartData();
    }

    @When("I send request to sort carts by descending")
    public void sortCartDescending() {
        cart.sortDescendingCarts();
    }

    @And("I receive valid data of all cart by descending")
    public void receiveValidDataCartDescending() {
        cart.receiveCartData();
    }

    @When("I send request to sort carts by ascending")
    public void sortCartAscending() {
        cart.sortAscendingCarts();
    }

    @And("I receive valid data of all carts by ascending")
    public void receiveValidDataCartAscending() { cart.receiveCartData(); }

    @When("I send request to get other user carts")
    public void getOtherUserCart() {
        cart.getOtherUserCart();
    }

    @And("I receive valid data of other user carts")
    public void validDataOtherUserCart() {
        cart.receiveSingleCartData();
    }

    @When("I send request to get carts by date range")
    public void getCartByDateRange() {
        cart.getCartByDateRange();
    }

    @And("I receive valid data of all carts by date range")
    public void validDataCartByDateRange(){
        cart.receiveCartData();
    }

    @When("I send request to add new cart")
    public void addNewCart() {
        cart.addNewCart();
    }

    @And("I receive valid data of new cart")
    public void receiveDataNewCart() {
        cart.receiveSingleCartData();
    }

    @When("I send request to add new cart with empty fields")
    public void addNewCartWithEmptyFields() {
        cart.addNewCartWithEmptyFields();
    }

    @When("I send request to update a cart")
    public void updateCart() {
        cart.updateCart();
    }

    @And("I receive valid data of updated cart")
    public void receiveUpdatedCartData() {
        cart.receiveSingleCartData();
    }

    @When("I send request to update cart with empty fields")
    public void updateCartWithEmptyFields() {
        cart.updateCartWithEmptyFields();
    }

    @When("I send request to delete a cart")
    public void deleteCart() {
        cart.deleteCart();
    }
}
