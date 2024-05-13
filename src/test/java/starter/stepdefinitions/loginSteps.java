package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.login.login;

public class loginSteps {
    @Steps
    login login;

    @Given("I set API endpoint for login")
    public void setAPIEndpointLogin() {
        login.setAPIEndpointForLogin();
    }

    @When("I send request to login with valid username and password")
    public void loginValidInputs() {
        login.loginWithValidInputs();
    }

    @Then("I receive status code 200")
    public void statsuCode200() {
        login.statusCode200();
    }

    @And("I get a token")
    public void getToken() {
        login.getToken();
    }

    @When("I send request to login with invalid username and valid password")
    public void loginWithInvalidUsername() {
        login.loginWithInvalidUsername();
    }

    @Then("I receive status code 400")
    public void statusCode400() {
        login.statusCode400();
    }

    @When("I send request to login with valid username and invalid password")
    public void loginWithInvalidPassword() {
        login.loginWithInvalidPassword();
    }

    @When("I send request to login with empty username and valid password")
    public void loginWithEmptyUsername() {
        login.loginWithEmptyUsername();
    }

    @When("I send request to login with valid username and empty password")
    public void loginWithEmptyPassword() {
        login.loginWithEmptyPassword();
    }

    @Then("I receive status code 401")
    public void statusCode401() {
        login.errorStatusCode401();
    }
}
