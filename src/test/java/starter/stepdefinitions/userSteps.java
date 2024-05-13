package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.user;

public class userSteps {
    @Steps
    user user;

    @Given("I set API endpoint for all user")
    public void setAPIEndpointForAllUser() {
        user.setApiEndpointAllUser();
    }

    @When("I send request to get all user")
    public void getAllUser() {
        user.getAllUser();
    }

    @And("I receive valid data of all user")
    public void receiveValidDataAllUser() {
        user.receiveUserData();
    }

    @When("I send request to get a single user")
    public void getSingleUser() {
        user.getSingleUser();
    }

    @And("I receive valid data that user")
    public void receiveValidDataOfUser() {
        user.receiveSingleUserData();
    }

    @When("I send request to limit the user result")
    public void limitUserResults() {
        user.limitUserResult();
    }

    @And("I receive valid data of all user of limited result")
    public void receiveValidLimitUserResults() {
        user.receiveUserData();
    }

    @When("I send request to sort user by descending")
    public void sortUserUserDescending() {
        user.sortDescendingUser();
    }

    @And("I receive valid data of all user by descending")
    public void receiveValidUserDataDescending() {
        user.receiveUserData();
    }

    @When("I send request to sort user by ascending")
    public void sortUserAscending() {
        user.sortAscendingUser();
    }

    @And("I receive valid data of all user by ascending")
    public void receiveValidDataUserAscending() {
        user.receiveUserData();
    }

    @When("I send request to add new user")
    public void addNewUser() {
        user.addNewUser();
    }

    @And("I receive valid data of new user")
    public void receiveDataNewUser() {
        user.receiveSingleUserData();
    }

    @When("I send request to add new user with empty fields")
    public void addNewUserWithEmptyFields() {
        user.addNewUserWithEmptyFields();
    }

    @When("I send request to update a user")
    public void updateUser() {
        user.updateUser();
    }

    @And("I receive valid data of updated user")
    public void receiveUpdatedUserData() {
        user.receiveSingleUserData();
    }

    @When("I send request to update user with empty fields")
    public void updateUserWithEmptyFields() {
        user.updateUserWithEmptyFields();
    }

    @When("I send request to delete a user")
    public void deleteUser() {
        user.deleteUser();
    }
}
